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

    public boolean aggiungiLuna(Luna luna){

        // da cio che ho capito dal README è che la grandezza dell'orbita massima dipende dalla massa del pianeta
        // e che una luna non può avere la stessa orbita di un'altra luna

        // (Forza di attrazione)
        // VISTO CHE DOBBIAMO PARLARNE ho supposto per semplicità e ricerca che la distanza massima a cui può stare una luna
        // è esattamente uguale alla massa del pianeta

        double distanzaMassimaConsentita = this.massa;

        if (luna.getDistanza() > distanzaMassimaConsentita) {
            // la luna è lontana e quindi il pianeta non riesce ad attrarla
            return false;
        }

        // ho controllato se l orbita è occupata

        for (int i = 0; i < this.lune.size(); i++) {

            Luna lunaEsistente = this.lune.get(i);
            // Se hanno la stessa distanza dal pianeta, l'orbita è occupata
            if (luna.getDistanza() == lunaEsistente.getDistanza()) {
                return false;
            }
        }

        this.lune.add(luna);

        return true;
    }
}
