package Visitors;

import Model.Body;
import antlr4puml.parser.PackParser;

import static java.util.stream.Collectors.toList;

public class BodyVisitor extends antlr4puml.parser.PackBaseVisitor<Body> {
    private PackageVisitor packageVisitor;
    private EntityVisitor entityVisitor;
    private RelationVisitor relationVisitor;

    public BodyVisitor() {
        entityVisitor = new EntityVisitor();
        relationVisitor = new RelationVisitor();
        packageVisitor = new PackageVisitor(this);
    }

    @Override
    public Body visitBody(PackParser.BodyContext ctx) {
        Body result = new Body();

        result.entities = ctx.element()
                .stream()
                .map(e -> entityVisitor.visitElement(e))
                .filter(e -> e != null)
                .collect(toList());

        result.relations = ctx.element()
                .stream()
                .map(r -> relationVisitor.visitElement(r))
                .filter(r-> r != null)
                .collect(toList());

        result.packages = ctx.element()
                .stream()
                .map(p -> packageVisitor.visitElement(p))
                .filter(p -> p != null)
                .collect(toList());

        return result;
    }
}
