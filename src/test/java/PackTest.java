import Model.Diagram;
import Model.Package;
import Visitors.DiagramVisitor;
import antlr4puml.parser.PackLexer;
import antlr4puml.parser.PackParser;
import org.antlr.v4.runtime.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PackTest {

    @Test
    public void testParser() throws IOException {

        Diagram diagram = parse(getResourceStream("/sample2.puml"));

        assertNotNull(diagram);
    }

    @Test
    public void testParseEmpty() throws IOException {
        String source =
                "@startuml" + "\r\n" +
                "@enduml";

        Diagram diagram = parse(source);
        assertNotNull(diagram);
        assertNotNull(diagram.body);
    }

    @Test
    public void testParseEntity() throws IOException {
        String source =
                "@startuml MyDiagram" + "\r\n" +
                "entity ABC" + "\r\n" +
                "@enduml";

        Diagram diagram = parse(source);
        assertNotNull(diagram);
        assertNotNull(diagram.body);

        assertEquals("Unexpected entity count", 1,  diagram.body.entities.size());
        assertEquals("Unexpected entity name", "ABC", diagram.body.entities.get(0).name);
    }

    @Test
    public void testParseRelation() throws IOException {
        String source =
                "@startuml MyDiagram" + "\r\n" +
                "A }--{ B" + "\r\n" +
                "@enduml";

        Diagram diagram = parse(source);
        assertNotNull(diagram);
        assertNotNull(diagram.body);

        assertEquals("Unexpected relation count", 1,  diagram.body.relations.size());
        assertEquals("Unexpected relation entity name", "A", diagram.body.relations.get(0).entityLeft);
        assertEquals("Unexpected relation entity name", "B", diagram.body.relations.get(0).entityRight);
    }

    @Test
    public void testParsePackage() throws IOException {
        String source = "@startuml MyDiagram" + "\r\n" +
                "package PackA" + "\r\n" +
                "<" + "\r\n" +
                "   package PackAB <" + "\r\n" +
                "   >" + "\r\n" +
                ">" + "\r\n" +
                "package PackC" +
                "@enduml";

        Diagram diagram = parse(source);
        assertNotNull(diagram);
        assertNotNull(diagram.body);

        assertEquals("Unexpected diagram name", "MyDiagram", diagram.name);

        List<Package> packages = diagram.getPackages();
        assertEquals("Unexpected package count", 3, packages.size());
        assertEquals("Unexpected package name", "PackA", packages.get(0).name);
        assertEquals("Unexpected package name", "PackAB", packages.get(1).name);
        assertEquals("Unexpected package name", "PackC", packages.get(2).name);
    }

    private static InputStream getResourceStream(String resource) {
        return Program.class.getResourceAsStream(resource);
    }

    private static Diagram parse(String source) throws IOException {
        CharStream input = CharStreams.fromString(source);
        return parse(input);
    }

    private static Diagram parse(InputStream stream) throws IOException {
        CharStream input = CharStreams.fromStream(stream);
        return parse(input);
    }

    private static Diagram parse(CharStream input) {
        PackLexer lexer = new PackLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PackParser parser = new PackParser(tokenStream);

        DiagramVisitor visitor = new DiagramVisitor();
        Diagram result = visitor.visitDiagram(parser.diagram());
        return result;
    }
}
