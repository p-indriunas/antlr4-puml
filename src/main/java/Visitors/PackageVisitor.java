package Visitors;

import Model.Package;
import antlr4puml.parser.PackParser;

public class PackageVisitor extends antlr4puml.parser.PackBaseVisitor<Package>  {

    private BodyVisitor bodyVisitor;

    public PackageVisitor(BodyVisitor bodyVisitor) {
        this.bodyVisitor = bodyVisitor;
    }

    @Override
    public Package visitPackageDecl(PackParser.PackageDeclContext ctx) {
        Package result = new Package(ctx.name.getText());
        result.body = bodyVisitor.visitBody(ctx.body());
        return result;
    }
}
