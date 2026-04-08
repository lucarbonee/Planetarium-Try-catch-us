public abstract class Corpo {
    String id;
    int massa = 0, grado, coordX, coordY;
    double distanza;

    protected Corpo(String id, int massa, int grado, int coordX, int coordY) {
        this.id = id;
        this.massa = massa;
        this.coordX = coordX;
        this.coordY = coordY;
        this.distanza = Math.sqrt(Math.pow(distanza, 2) + Math.pow(grado, 2));
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
