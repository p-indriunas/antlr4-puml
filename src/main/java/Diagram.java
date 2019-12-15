import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/*
public class Diagram {

    public void load(InputStream inputStream) throws IOException {
        ErrorList lexErrors = new ErrorList();
        ErrorList syntaxErrors = new ErrorList();

        PumlLexer lexer = new PumlLexer(new ANTLRInputStream(inputStream));
        lexer.addErrorListener(lexErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PumlParser parser = new PumlParser(tokens);
        parser.addErrorListener(syntaxErrors);
        //parser.addParseListener(this);

        PumlParser.DiagramContext context = parser.diagram();

    }

    private static class ErrorList implements ANTLRErrorListener {

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


}
*/