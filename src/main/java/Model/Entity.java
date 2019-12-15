package Model;

public class Entity {
    public String name;

    public Entity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
