public class CoppiaDiCollisione {
    private final Corpo[] corpi = new Corpo[2];

    public CoppiaDiCollisione(Corpo c1, Corpo c2){
        corpi[0] = c1;
        corpi[1] = c2;
    }

    public Corpo[] getCorpi(){
        return corpi;
    }

    public boolean contieneCorpo(Corpo c){
        return corpi[0]==c || corpi[1]==c;
    }

}
