package Model;

public class Package {
    public String name;
    public Body body;

    public Package(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
