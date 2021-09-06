import java.util.ArrayList;
import java.util.List;

public class Stuff {

    private  String name;


    public Stuff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n" + name;
    }
}
