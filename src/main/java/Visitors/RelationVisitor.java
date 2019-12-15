package Visitors;

import Model.Relation;
import antlr4puml.parser.PackParser;

public class RelationVisitor extends antlr4puml.parser.PackBaseVisitor<Relation> {

    @Override
    public Relation visitRelation(PackParser.RelationContext ctx) {
        Relation result = new Relation();

        result.entityLeft = ctx.entityLeft.getText();
        result.commentLeft = ctx.commentLeft != null ? ctx.commentLeft.getText() : "";
        result.relationLeft = ctx.relationLeft.getText();

        result.entityRight = ctx.entityRight.getText();
        result.commentRight = ctx.commentRight != null ? ctx.commentRight.getText() : "";
        result.relationRight = ctx.relationRight.getText();

        return result;
    }
}
