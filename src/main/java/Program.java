import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = Program.class.getResourceAsStream("/sample.puml");

        EntityDiagram diagram = new EntityDiagram();
        diagram.load(inputStream);

        for(EntityDiagram.Entity e : diagram.getEntities()) {
            System.out.println(e);
        }
        System.out.println();

        for(EntityDiagram.Relation r : diagram.getRelations()) {
            System.out.println(r);
        }
    }
}
