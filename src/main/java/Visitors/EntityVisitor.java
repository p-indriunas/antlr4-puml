package Visitors;

import Model.Entity;
import antlr4puml.parser.PackParser;

public class EntityVisitor extends antlr4puml.parser.PackBaseVisitor<Entity> {

    @Override
    public Entity visitEntity(PackParser.EntityContext ctx) {
        return new Entity(ctx.name.getText());
    }
}
