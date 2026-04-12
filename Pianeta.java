import java.util.ArrayList;

public class Pianeta extends Corpo{

    private final Stella stella;
    private final ArrayList<Luna> lune = new ArrayList<>();

    public Pianeta(String id, int massa, int coordX, int coordY, Stella stella) {
        super(id, massa, 2, coordX, coordY);

        // calcolo della distanza del pianeta dalla stella (centro)
        this.distanza = Math.round(Math.sqrt(Math.pow(coordX, 2) + Math.pow(coordY, 2)) * 100.0) / 100.0;
        this.stella = stella;
    }

    public ArrayList<Luna> getLune() {
        return lune;
    }

    public boolean aggiungiLuna(Luna luna){
        return this.lune.add(luna);
    }

    @Override
    public Corpo getInferiore() {
        return this.stella;
    }
}
