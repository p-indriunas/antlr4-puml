
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/*
public class EntityDiagram extends AbstractPumlListener {

    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Relation> relations = new ArrayList<>();

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public ArrayList<Relation> getRelations() {
        return relations;
    }

    public void load(InputStream inputStream) throws IOException {
        ErrorList lexErrors = new ErrorList();
        ErrorList syntaxErrors = new ErrorList();

        PumlLexer lexer = new PumlLexer(new ANTLRInputStream(inputStream));
        lexer.addErrorListener(lexErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PumlParser parser = new PumlParser(tokens);
        parser.addErrorListener(syntaxErrors);
        parser.addParseListener(this);

        PumlParser.DiagramContext context = parser.diagram();

    }

    @Override
    public void exitEntity(PumlParser.EntityContext ctx) {
        Entity entity = new Entity(ctx.entityId.getText());
        entities.add(entity);
    }

    @Override
    public void exitRelation(PumlParser.RelationContext ctx) {
        Relation relation = new Relation();
        relation.entityLeft = ctx.idLeft.getText();
        relation.relationLeft = ctx.L_REL().getText();
        relation.entityRight = ctx.idRight.getText();
        relation.relationRight = ctx.R_REL().getText();
        relations.add(relation);
    }

    public class Entity {

        private String name;

        public Entity(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public class Relation {
        String entityLeft;
        String relationLeft;
        String entityRight;
        String relationRight;

        @Override
        public String toString() {
            return "Relation{" +
                    "entityLeft='" + entityLeft + '\'' +
                    ", relationLeft='" + relationLeft + '\'' +
                    ", entityRight='" + entityRight + '\'' +
                    ", relationRight='" + relationRight + '\'' +
                    '}';
        }
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