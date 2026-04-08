import java.util.ArrayList;

public class Pianeta extends Corpo{

    ArrayList<Luna> lune = new ArrayList<>();

    public Pianeta(String id, int massa, int coordX, int coordY) {
        super(id, massa, 2, coordX, coordY);
    }

    public ArrayList<Luna> getLune() {
        return lune;
    }
}
