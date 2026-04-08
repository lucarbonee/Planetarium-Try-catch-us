import java.util.ArrayList;

public class Pianeta extends Corpo{

    ArrayList<Luna> lune = new ArrayList<>();

    public Pianeta(String id, int massa, int coordX, int coordY) {
        super(id, massa, 2, coordX, coordY);

        // calcolo della distanza del pianeta dalla stella (centro)
        this.distanza = Math.round(Math.sqrt(Math.pow(coordX, 2) + Math.pow(coordY, 2)) * 100.0) / 100.0;
    }

    public ArrayList<Luna> getLune() {
        return lune;
    }
}
