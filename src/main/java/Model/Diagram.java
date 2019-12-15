package Model;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
    public String name;
    public String file;
    public String[] includes;
    public Body body;

    public List<Package> getPackages() {
        List<Package> result = new ArrayList<>();
        collectPackages(body, result);
        return result;
    }

    private static void collectPackages(Body body, List<Package> result) {
        if (body == null || body.packages == null)
            return;

        for (Package pack : body.packages) {
            result.add(pack);
            collectPackages(pack.body, result);
        }
    }
}

