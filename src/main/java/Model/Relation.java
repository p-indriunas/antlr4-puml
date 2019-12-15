package Model;

public class Relation {
    public String entityLeft;
    public String commentLeft;
    public String relationLeft;

    public String entityRight;
    public String commentRight;
    public String relationRight;

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
