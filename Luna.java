public class Luna extends Corpo{

    private final Pianeta pianeta;

    public Luna(String id, int massa, int coordX, int coordY, Pianeta pianeta) {
        super(id, massa, 3, coordX, coordY);
        this.pianeta = pianeta;

        // calcolo della distanza della luna dal suo pianeta
        this.distanza = Math.round(Math.sqrt(Math.pow( coordX - pianeta.getCoordX() , 2) + Math.pow( coordY - pianeta.getCoordY(), 2)) * 100.0 ) / 100.0;
    }

    public Pianeta getPianeta() {
        return pianeta;
    }

    @Override
    public Corpo getInferiore() {
        return this.pianeta;
    }
}
