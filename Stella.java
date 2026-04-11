import java.util.ArrayList;

public class Stella extends Corpo {

    ArrayList<Pianeta> pianeti = new ArrayList<>();

    public Stella(String id, int massa) {
        super(id, massa, 1, 0, 0);
    }

    public ArrayList<Pianeta> getPianeti() {
        return pianeti;
    }

    // Se il pianeta non collide con altri può essere aggiunto, altrimenti no
    public boolean aggiungiPianeta(Pianeta pianeta){
        return this.pianeti.add(pianeta);
    }

    @Override
    public Corpo getInferiore() {
        return this;
    }
}
