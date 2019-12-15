import Model.Diagram;
import Visitors.DiagramVisitor;
import antlr4puml.parser.PackLexer;
import antlr4puml.parser.PackParser;
import org.antlr.v4.runtime.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

public class PackTest {

    @Test
    public void testParser() throws IOException {

        Diagram diagram = parse(getResourceStream("/sample2.puml"));

        assertNotNull(diagram);
    }

    private static InputStream getResourceStream(String resource) {
        return Program.class.getResourceAsStream(resource);
    }

    private static Diagram parse(InputStream stream) throws IOException {
        CharStream input = CharStreams.fromStream(stream);

        PackLexer lexer = new PackLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PackParser parser = new PackParser(tokenStream);

        DiagramVisitor visitor = new DiagramVisitor();
        Diagram result = visitor.visitDiagram(parser.diagram());
        return result;
    }
}
