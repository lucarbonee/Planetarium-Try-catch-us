import java.util.ArrayList;

public class Stella extends Corpo {

    ArrayList<Pianeta> pianeti = new ArrayList<>();

    public Stella(String id, int massa) {
        super(id, massa, 1, 0, 0);
    }

    public ArrayList<Pianeta> getPianeti() {
        return pianeti;
    }
}
