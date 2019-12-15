import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.junit.Ignore;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Unit test for simple App.
 */
/*
@Ignore
public class GrammarTest extends TestCase
{
    public GrammarTest(String testName)
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( GrammarTest.class );
    }

    class ErrorCollector implements ANTLRErrorListener {
        private List<String> errors = new ArrayList<>();

        public List<String> getErrors() {
            return errors;
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
            errors.add(s);
        }

        @Override
        public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
            errors.add("ambiguity");
        }

        @Override
        public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
            errors.add("full context");
        }

        @Override
        public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
            errors.add("context sensitivity");
        }
    }

    public void testParser() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = getResourceStream("/sample2.puml");

        ErrorCollector lexErrors = new ErrorCollector();
        ErrorCollector syntaxErrors = new ErrorCollector();

        PumlLexer lexer = new PumlLexer(new ANTLRInputStream(inputStream));
        lexer.addErrorListener(lexErrors);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PumlParser parser = new PumlParser(tokens);
        parser.addErrorListener(syntaxErrors);
        PumlParser.DiagramContext diagramCtx = parser.diagram();

        assertEquals(0, lexErrors.getErrors().size());
        assertEquals(0, syntaxErrors.getErrors().size());
    }

    public void testLexer() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        //File file = new File(classLoader.getResource("usecase1.plantuml").getFile());
        InputStream inputStream = getResourceStream("/sample2.puml");

        ErrorCollector lexErrors = new ErrorCollector();

        //PumlLexer lexer = new PumlLexer(new ANTLRInputStream(new FileInputStream(file)));
        PumlLexer lexer = new PumlLexer(new ANTLRInputStream(inputStream));
        lexer.addErrorListener(lexErrors);
        for (Token token = lexer.nextToken();
             token.getType() != Token.EOF;
             token = lexer.nextToken())
        {
            System.out.println("* "+token);
        }
        assertEquals(0, lexErrors.getErrors().size());
    }

    private static InputStream getResourceStream(String resource) {
        return Program.class.getResourceAsStream(resource);
    }
}

 */