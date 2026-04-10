import java.util.ArrayList;

public class Stella extends Corpo {

    ArrayList<Pianeta> pianeti = new ArrayList<>();

    public Stella(String id, int massa) {
        super(id, massa, 1, 0, 0);
    }

    public ArrayList<Pianeta> getPianeti() {
        return pianeti;
    }

    // TODO -> Fare comparire il commento adeguato in base all'errore che l'utente commette
    // Se il pianeta non collide con altri può essere aggiunto, altrimenti no
    public boolean aggiungiPianeta(Pianeta pianeta){
        boolean aggiungi = true;

        // Uso un ciclo for per fare il controllo delle orbite, facendo uno scorrimento tra i pianeti già salvati
        for (Pianeta pianetaEsistente : this.pianeti) {

            // Controllo se la distanza di un pianeta appena creato è uguale a quella di uno gia esistente, in tal caso l'orbita è occupata
            // Oppure se l'utente vuole aggiungere un pianeta in centro al sistema stellare
            if ( (pianeta.getDistanza() == pianetaEsistente.getDistanza() ) || (pianeta.getDistanza() == 0) ) {
                aggiungi = false;
                break;
            }
        }
        if (aggiungi) {
            this.pianeti.add(pianeta);
        }
        return aggiungi;
    }
}
