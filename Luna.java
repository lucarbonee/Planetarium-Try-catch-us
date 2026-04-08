public class Luna extends Corpo{

    Pianeta pianeta;

    public Luna(String id, int massa, int coordX, int coordY, Pianeta pianeta) {
        super(id, massa, 3, coordX, coordY);
        this.pianeta = pianeta;

        // calcolo della distanza della luna dal suo pianeta
        this.distanza = Math.sqrt(Math.pow( coordX - pianeta.coordX , 2) + Math.pow( coordY - pianeta.coordY, 2));
    }

}
