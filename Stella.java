import java.util.ArrayList;

public class Stella extends Corpo {

    ArrayList<Pianeta> pianeti = new ArrayList<>();

    public Stella(String id, int massa) {
        super(id, massa, 1, 0, 0);
    }

    public ArrayList<Pianeta> getPianeti() {
        return pianeti;
    }

    public boolean aggiungiPianeta(Pianeta pianeta){
        // se il pianeta non collide con un'altro può essere aggiunto sennò no
        this.pianeti.add(pianeta);
        return true;
    }
}
