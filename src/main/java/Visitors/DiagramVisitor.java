package Visitors;

import Model.Diagram;
import antlr4puml.parser.PackParser;

public class DiagramVisitor extends antlr4puml.parser.PackBaseVisitor<Diagram>  {

    private BodyVisitor bodyVisitor = new BodyVisitor();

    @Override
    public Diagram visitDiagram(PackParser.DiagramContext ctx) {

        Diagram result = new Diagram();

        if (ctx.startuml().name != null)
            result.name = ctx.startuml().name.getText();
        result.body = bodyVisitor.visit(ctx.body());

        return result;
    }
}
