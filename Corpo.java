public abstract class Corpo {
    String id;
    int massa, grado, coordX, coordY;
    double distanza=0;

    protected Corpo(String id, int massa, int grado, int coordX, int coordY) {
        this.id = id;
        this.massa = massa;
        this.coordX = coordX;
        this.coordY = coordY;

    }

    public String getId() {
        return id;
    }

    public int getGrado() {
        return grado;
    }

    public int getMassa() {
        return massa;
    }

    public int[] getCoord() {
        return new int[]{coordX, coordY};
    }

    public double getDistanza() {
        return distanza;
    }

}
