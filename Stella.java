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

        // Ho usato un ciclo for per fare il controllo delle orbite, faccendo un scorrimento tra i pianeti gia salvati
        for (int i = 0; i< this.pianeti.size(); i++){

            // Non giudicatemi per la nome della variabile ne parleremo haha
            Pianeta pianetaEsistente = this.pianeti.get(i);

            // poi ho pensato di controllare se la distanza di un pianta appena creato sia uguale a quella di uno gia esistente
            if (pianeta.getDistanza() == pianetaEsistente.getDistanza()){
                return false;
            }
        }
        this.pianeti.add(pianeta);
        return true;
    }
}
