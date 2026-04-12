import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

// TODO funzionalità base
// Ultima controllata al readme

// TODO funzionalità aggiuntive
// Collisioni:
// Pianeta-Pianeta --------------------> [fatto]
// Luna-Luna (stessa orbita) ----------> [fatto]
// Luna-Luna (orbita incidente) ------->
// Luna-Pianeta ----------------------->
// Luna-Stella ------------------------>

public class Main {
    final static int MIN = 20;
    final static int MAX = 40;
    private static final ArrayList<Corpo> collisioni = new ArrayList<>(); // contiene i corpi che possono potenzialmente collidere con altri.


    public static void main(String[] args) {

        // Input dell'utente
        Scanner scanner = new Scanner(System.in);
        String UserInput;
        String id="";

        // Punto di riferimento del sistema stellare (Stella)
        Stella stella = null;

        System.out.println("\n\nBenvenuto in Planetarium!!!");
        System.out.println("\nPrima di tutto dobbiamo andare a creare la STELLA attorno alla quale orbitano tutti i tuoi pianeti: ");

        while(id.isEmpty() || id.contains(" ") || id.contains("\t")){
            System.out.print("\nInserisci il nome della stella: ");
            id = scanner.nextLine();
            if(id.isEmpty()  || id.contains(" ") || id.contains("\t")){
                System.out.println("Il nome della stella non può essere vuoto o contenere spazi!");
            }
        }

        while (stella == null) {
            try {
                System.out.print("\nInserisci la massa della stella: ");
                int massa = Integer.parseInt(scanner.nextLine());

                if (massa >= MIN && massa <= MAX)
                    stella = new Stella(id, massa);
                else
                    System.out.println("La massa deve essere compresa tra " + MIN + " e " + MAX);

            } catch (Exception e) {
                System.out.println("\n!!! Inserisci dei valori adeguati !!!");
            }
        }

        for(int i=0; i<100; i++){
            System.out.println();
        }
        System.out.println("Congratulazioni!! hai fatto il primo passo per creare il tuo fantastico sistema stellare ");
        pulisciConsole(scanner);

        // Generatore di pianeti/lune per testare il programma
        generaCorpi(stella);

        // Main loop
        stampaMenu();
        do{
            System.out.print("~home~ ");
            UserInput = scanner.nextLine();

            switch (UserInput.toLowerCase()){
                case("menu"):{
                    stampaMenu();
                    //pulisciConsole(scanner);
                    break;
                }
                case("+corpo"):{
                    aggiungiCorpo(stella, scanner);
                    pulisciConsole(scanner);
                    break;
                }
                case("-corpo"):{
                    rimuoviCorpo(stella, scanner);
                    pulisciConsole(scanner);
                    break;
                }
                case("cerca"):{
                    cercaCorpo(stella, scanner, true);
                    pulisciConsole(scanner);
                    break;
                }
                case("rotta"):{
                    calcolaRotta(stella, scanner);
                    pulisciConsole(scanner);
                    break;
                }
                case("cmassa"):{
                    calcoloCentroMassa(stella);
                    pulisciConsole(scanner);
                    break;
                }
                case("collisioni"):{
                    MostraCollisioni();
                    pulisciConsole(scanner);
                    break;
                }
                case("esci"):{
                    System.out.println("Grazie di aver utilizzato Planetarium!!");
                    break;
                }
                default:{
                    System.out.print("Comando non trovato :(");
                    pulisciConsole(scanner);
                }
            }

        }while(!(UserInput.equalsIgnoreCase("esci")));

    }

    // Da vedere -dani
    // Gestore leggibilità console
    private static void pulisciConsole(Scanner scanner){
        System.out.println();
        System.out.print("Premi invio per continuare ");
        scanner.nextLine();
        for(int i=0; i<100; i++){
            System.out.println();
        }
    }

    // Stampa menu'
    private static void stampaMenu(){
        System.out.println("//////////////////");
        System.out.println("Benvenuto nel menù");
        System.out.println("menu    -> apri questa sezione");
        System.out.println("esci    -> esci dal programma");
        System.out.println("+corpo  -> crea pianeta/luna");
        System.out.println("-corpo  -> rimuovi pianeta/luna");
        System.out.println("cerca   -> cerca un determinato corpo");
        System.out.println("rotta   -> visualizza la rotta da un corpo all'altro");
        System.out.println("cMassa  -> calcola il centro di massa del sistema stellare");
        System.out.println("collisioni -> indica se sono presenti delle collisioni nel S. stellare");
        System.out.println("//////////////////");
        System.out.println();
    }

    // Aggiungi corpo
    private static void aggiungiCorpo(Stella stella, Scanner scanner){
        System.out.println("""
                pianeta  -> aggiungi un pianeta
                luna     -> aggiungi una luna
                indietro -> torna alla home""");

        boolean check = true;
        do {
            System.out.print("~+~ ");
            String UserInput = scanner.nextLine();
            switch (UserInput.toLowerCase()){
                case "pianeta":{
                    check = false;
                    aggiungiPianeta(stella, scanner);
                    break;
                }

                case "luna":{
                    check = false;
                    aggiungiLuna(stella, scanner);
                    break;
                }

                case "indietro": {
                    check = false;
                    break;
                }

                default:{
                    System.out.println("Comando non trovato, puoi aggiungere un pianeta o una luna, oppure tornare indietro");
                }
            }

        }while(check);

    }

    private static void aggiungiPianeta(Stella stella, Scanner scanner) {
        boolean corretto, nuovo;
        int massa = 0, coordX = 0, coordY= 0;
        String id="";

        do {
            nuovo = true;
            while(id.isEmpty() || id.contains(" ") || id.contains("\t")){
                System.out.print("\nInserisci il nome del pianeta: ");
                id = scanner.nextLine();
                if(id.isEmpty()  || id.contains(" ") || id.contains("\t")){
                    System.out.println("Il nome dell pianeta non può essere vuoto o contenere spazi!");
                }
            }

            if(esiste(id, stella) || id.equalsIgnoreCase(stella.getId())){
                System.out.println("Nome già in uso nel sistema stellare!");
                id = "";
                nuovo = false;
            }
        }while (!nuovo);


        do {
            try {
                System.out.print("\nInserisci la massa del pianeta: ");
                massa = Integer.parseInt(scanner.nextLine());

                if(massa >= stella.massa || massa<= 1) {
                    System.out.println("La massa del pianeta non può essere maggiore o uguale a quella della stella o minore o uguale a 1!");
                    corretto = false;
                } else
                    corretto = true;

            }catch (Exception e){
                System.out.println("\n !!! Inserisci dei valori adeguati !!!");
                corretto = false;
            }
        }while (!corretto);

        do {
            corretto = true;
            try {
                System.out.print("\nInserisci la coordinata X del pianeta: ");
                coordX = Integer.parseInt(scanner.nextLine());
                System.out.print("\nInserisci la coordinata Y del pianeta: ");
                coordY = Integer.parseInt(scanner.nextLine());
                if ((coordX < -100 || coordY < -100) || (coordX > 100 || coordY > 100)) {
                    System.out.println("\n !!! inserisci dei valori compresi tra -100 e 100 !!!");
                    corretto = false;
                }
                if ( coordX == 0 && coordY == 0 ) {
                    System.out.println("\n !!! Il pianeta non può essere al centro del sistema stellare !!!");
                    corretto = false;
                }

                //controllo che la posizione del pianeta sia libera
                int[] coordNuovoPianeta = {coordX, coordY};
                if(corretto){
                    corretto = coordLibere(coordNuovoPianeta, stella);
                }


            } catch (NumberFormatException e) {
                System.out.println("\n !!! Inserisci dei valori adeguati !!!");
                corretto = false;
            }
        } while (!corretto);

        Pianeta pianeta =  new Pianeta(id, massa, coordX, coordY, stella);

        boolean pianetaAggiunto = stella.aggiungiPianeta(pianeta);
        if (pianetaAggiunto){
            System.out.println("\nPianeta '" + id + "' aggiunto con successo.");
            System.out.println("Si trova sulla sua orbita a una distanza di: " + pianeta.getDistanza());

            if (collidonoPP(pianeta, stella))
                collisioni.add(pianeta);

        } else {
            System.out.println("\nQualcosa è andato storto !");
        }
    }

    private static void aggiungiLuna(Stella stella, Scanner scanner) {

        // Controllo che esistano pianeti
        if(!stella.getPianeti().isEmpty()){

            // Stampo l'elenco dei pianeti
            System.out.println("\nEcco l'elenco dei pianeti presenti nel sistema stellare: ");
            for(Pianeta p : stella.getPianeti()){
                int[] coord = p.getCoord();
                System.out.println("- "+"'"+p.getId()+"'"+" distanza da "+stella.getId()+": "+p.getDistanza()+"  [x:"+coord[0]+", y:"+coord[1]+"]" );
            }


            System.out.print("\n\nInserisci il nome del pianeta a cui vuoi aggiungere la luna: ");
            String nomePianetaCercato = scanner.nextLine();

            Pianeta pianetaTrovato = null;

            // Cerco il pianeta nella lista della stella
            for(int i = 0; i < stella.getPianeti().size() && pianetaTrovato == null; i++) {
                Pianeta p = stella.getPianeti().get(i);
                if (p.getId().equalsIgnoreCase(nomePianetaCercato)) {
                    pianetaTrovato = p;
                }
            }

            if (pianetaTrovato == null) {
                System.out.println("\nNon trovato nel sistema stellare!");
                return;
            }

            String idLuna = "";
            boolean nuovo;

            do {
                try{
                    nuovo = true;
                    while(idLuna.isEmpty() || idLuna.contains(" ") || idLuna.contains("\t")){
                        System.out.print("\nInserisci il nome della luna: ");
                        idLuna = scanner.nextLine();
                        if(idLuna.isEmpty()  || idLuna.contains(" ") || idLuna.contains("\t")){
                            System.out.println("Il nome della luna non può essere vuoto o contenere spazi!");
                        }
                    }

                    if(esiste(idLuna, stella)  || idLuna.equalsIgnoreCase(stella.getId())){
                        System.out.println("Nome già in uso nel sistema stellare!");
                        idLuna = "";
                        nuovo = false;
                    }
                } catch (Exception e) {
                    System.out.println("\n !!! Inserisci dei valori adeguati !!!");
                    nuovo = false;
                }

            }while (!nuovo);

            boolean corretto;
            int massa = 0, coordX = 0, coordY = 0;

            // Controllo massa
            do {
                try {
                    corretto = true;
                    System.out.print("\nInserisci la massa della luna: ");
                    massa = Integer.parseInt(scanner.nextLine());
                    if (massa >= pianetaTrovato.massa) {
                        System.out.println("La massa della luna non può essere maggiore o uguale a quella del proprio centro gravitazionale, ovvero di " + pianetaTrovato.massa);
                        corretto = false;
                    }
                    if (massa <= 0) {
                        System.out.println("La massa non può essere nulla o negativa");
                        corretto = false;
                    }
                }catch (Exception e){
                    System.out.println("\n !!! Inserisci dei valori adeguati !!!");
                    corretto = false;
                }
            }while (!corretto);

            // Controllo coordinate
            do {
                corretto = true;
                try {
                    System.out.print("\nInserisci la coordinata X della luna: ");
                    coordX = Integer.parseInt(scanner.nextLine());
                    System.out.print("\nInserisci la coordinata Y della luna: ");
                    coordY = Integer.parseInt(scanner.nextLine());
                    if ((coordX < -100 || coordY < -100) || (coordX > 100 || coordY > 100)) {
                        System.out.println("\n!!! inserisci dei valori compresi tra -100 e 100 !!!");
                        corretto = false;
                    }
                    if (corretto && (coordX == 0 && coordY == 0)) {
                        System.out.println("\n!!! La luna non può trovarsi al centro del sistema stellare !!!");
                        corretto = false;
                    }

                    int[] coordNuovaLuna = {coordX, coordY};
                    //controllo che la posizione della luna sia libera
                    if (corretto && (Arrays.equals(coordNuovaLuna, pianetaTrovato.getCoord()))) {
                        System.out.println("\nNon puoi posizionare la Luna alle stesse coordinate del suo pianeta");
                        corretto = false;
                    } else if(corretto){
                        corretto = coordLibere(coordNuovaLuna, stella);
                    }

                    int distanzaMassimaConsentita = pianetaTrovato.massa;

                    // (Forza di attrazione)
                    // Ho supposto per semplicità che la distanza massima a cui può stare una luna
                    // è esattamente uguale alla massa del pianeta
                    if (Math.round(Math.sqrt(Math.pow( coordX - pianetaTrovato.coordX , 2) + Math.pow( coordY - pianetaTrovato.coordY, 2)) * 100.0 ) / 100.0 > distanzaMassimaConsentita) {
                        // la luna è lontana e quindi il pianeta non riesce ad attrarla
                        System.out.println("\nLuna troppo lontana dal pianeta!");
                        corretto =  false;
                    }


                } catch (NumberFormatException e) {
                    System.out.println("\n!!! Inserisci dei valori adeguati !!!");
                    corretto = false;
                }
            } while (!corretto);

            Luna nuovaLuna = new Luna(idLuna, massa, coordX, coordY, pianetaTrovato);

            boolean aggiuntoConSuccesso = pianetaTrovato.aggiungiLuna(nuovaLuna);

            if (aggiuntoConSuccesso) {
                System.out.println("\nLuna '" + idLuna + "' aggiunta con successo attorno al pianeta '" + pianetaTrovato.getId() + "'!");
                System.out.println("Distanza dal pianeta: " + nuovaLuna.getDistanza());
                if (collidonoLL_stessaOrbita(nuovaLuna)){
                    collisioni.add(nuovaLuna);
                }

            } else {
                System.out.println("\nQualcosa è andato storto nell'aggiunta di: "+ nuovaLuna.getId() + ".");
            }
        } else{
            System.out.println("Non ci sono pianeti a cui aggiungere una luna!!");
        }

    }

    // Cerca corpo
    private static Corpo cercaCorpo(Stella stella, Scanner scanner, Boolean execute){

        System.out.print("\nInserire il nome del corpo: ");
        String nomeCercato = scanner.nextLine();

        if(execute){System.out.println("\nRicerca in corso di: " + nomeCercato );}

        // vado a controllare la stella

        if (stella.getId().equalsIgnoreCase(nomeCercato)){
            if(execute){
                System.out.println("Corpo trovato! È la stella del sistema.");
                System.out.println("- Nome: " + stella.getId());
                System.out.println("- Massa: " + stella.getMassa());
                int[] coordinate = stella.getCoord();
                System.out.println("- Coordinate: (" + coordinate[0] + ", " + coordinate[1] + ")");
            }
            return stella;

        } else{
            // vado a controllare i pianeti e le lune
            for (int i = 0; i < stella.getPianeti().size(); i++){
                Pianeta pianetaAttuale = stella.getPianeti().get(i);

                // voglio vedere se è il pianeta che cerchiamo
                if (pianetaAttuale.getId().equalsIgnoreCase(nomeCercato)){
                    if(execute){
                        System.out.println("\nTrovato! È un Pianeta.");
                        System.out.println("- Nome: " + pianetaAttuale.getId());
                        System.out.println("- Massa: " + pianetaAttuale.getMassa());
                        int[] coordinate = pianetaAttuale.getCoord();
                        System.out.println("- Coordinate: (" + coordinate[0] + ", " + coordinate[1] + ")");
                        System.out.println("- Distanza dalla Stella: " + pianetaAttuale.getDistanza());

                        // Stampa lune che ruotano attorno al pianeta:
                        if(!pianetaAttuale.getLune().isEmpty()){
                            System.out.println("Ecco le lune che orbitano attorno al pianeta:");
                            System.out.println();
                            for(Luna l : pianetaAttuale.getLune()){
                                if(pianetaAttuale.getLune().size()>1){
                                    System.out.print(l.getId()+", ");
                                } else{
                                    System.out.print(l.getId());
                                }
                            }
                            System.out.println();
                        } else {
                            System.out.println("Il pianeta non possiede alcuna luna che gli orbita attorno");
                        }
                    }
                    return pianetaAttuale;
                }

                for (int j = 0; j < pianetaAttuale.getLune().size(); j++){
                    Luna lunaAttuale = pianetaAttuale.getLune().get(j);

                    if (lunaAttuale.getId().equalsIgnoreCase(nomeCercato)) {
                        if(execute){
                            System.out.println("Trovato! È una Luna.");
                            System.out.println("- Nome: " + lunaAttuale.getId());
                            System.out.println("- Orbita attorno a: " + pianetaAttuale.getId());
                            System.out.println("- Massa: " + lunaAttuale.getMassa());
                            int[] coordinate = lunaAttuale.getCoord();
                            System.out.println("- Coordinate: (" + coordinate[0] + ", " + coordinate[1] + ")");
                            System.out.println("- Distanza dal suo Pianeta: " + lunaAttuale.getDistanza());
                            System.out.println("Percorso per essere raggiunta: "+stella.getId()+" > "+pianetaAttuale.getId()+" > "+lunaAttuale.getId());
                        }
                        return lunaAttuale;
                    }
                }
            }
        }

        if(execute){
            System.out.println("\nNon e' stato trovato nessun corpo, controlla di aver digitato il nome corretto");
        }
        return null;

    }

    // Rimuovi corpo
    private static void rimuoviCorpo(Stella stella, Scanner scanner){
        Corpo c = cercaCorpo(stella, scanner,false);
        String userInput;
        if(c!=null){
            if(c.getGrado()==2){ // è un pianeta e lo rimuovo
                Pianeta p = (Pianeta) c; //Downcasting
                do{
                    System.out.println();
                    System.out.println("Sei sicuro di voler eliminare il pianeta '"+c.getId()+"' ?");
                    if(p.getLune().isEmpty()){
                        System.out.println("Il pianeta non possiede lune");
                    }
                    else{
                        System.out.println("Ricordati che assieme al pianeta eliminerai anche le sue lune: ");
                        System.out.print("- ");
                        for(Luna l : p.getLune()){
                            if(p.getLune().size()>1){
                                System.out.print(l.getId()+", ");
                            }
                            else{
                                System.out.print(l.getId());
                            }
                        }
                    }
                    System.out.println();
                    System.out.print("(si/no)? -- ");
                    userInput = scanner.nextLine();

                }while((!userInput.equalsIgnoreCase("si")) && (!userInput.equalsIgnoreCase("no")));

                if(userInput.equals("si")){
                    stella.getPianeti().remove(c);
                    System.out.println("Il pianeta '"+c.getId()+"' e' stato rimosso con successo dal sistema stellare");
                }
                else{
                    System.out.println("Ritorno al menu' principale");
                }

            }
            else if(c.getGrado()==3){
                Luna l = (Luna) c;
                Pianeta p = l.getPianeta(); // Downcasting da corpo a luna
                p.getLune().remove(l);
                System.out.println("La luna '"+l.getId()+"' e' stata rimossa con successo dal pianeta '"+p.getId()+"'");
            }
            else{
                System.out.println("Non puoi rimuovere la stella del sistema!");
            }
        }
        else{
            System.out.println("Il corpo che cerchi di eliminare non esiste!");
        }
    }

    // Calcolo rotte
    private static void calcolaRotta(Stella stella, Scanner scanner){

        ArrayList<String> rotta = new ArrayList<>();
        ArrayList<String> rotta1 = new ArrayList<>();
        double distanza = 0;
        Corpo[] corpi = new Corpo[2];
        corpi[0] = new Corpo("a",1,1,1,1);
        corpi[1] = new Corpo("a",1,1,1,1);
        // Cerco il corpo
        System.out.println("Ora ti verranno richiesti i nomi dei due corpi");
        System.out.println("Inserisci il corpo di partenza, poi quello di arrivo");
        for(int i=0;i<2 && (corpi[0]!=null && corpi[1]!=null);i++){
            corpi[i] = cercaCorpo(stella,scanner,false);
        }

        if(corpi[0] == null || corpi[1] == null){
            System.out.println("Il corpo che hai inserito non esiste, impossibile calcolare la rotta");
        }
        else{
            if(((corpi[0].getGrado()==corpi[1].getGrado()) && corpi[0].getGrado()==3) && corpi[0].getInferiore()==corpi[1].getInferiore()){
                System.out.print("La rotta tra i due pianeti e': ");
                System.out.println(corpi[0].getId() + " " +corpi[0].getInferiore().getId()+" "+corpi[1].getId());
                distanza = calcolaDistanza(corpi[0],corpi[0].getInferiore()) + calcolaDistanza(corpi[0].getInferiore(),corpi[1]);
            } else if (corpi[0]==corpi[1]) {
                System.out.print("La rotta tra i due pianeti e': ");
                System.out.println(corpi[0].getId());
            } else{


                while(corpi[0]!=stella){
                    rotta.add(corpi[0].getId());
                    distanza += calcolaDistanza(corpi[0],corpi[0].getInferiore());
                    corpi[0] = corpi[0].getInferiore();

                }

                rotta.add(stella.getId());

                while(corpi[1]!=stella){
                    rotta1.add(corpi[1].getId());
                    distanza += calcolaDistanza(corpi[1],corpi[1].getInferiore());
                    corpi[1] = corpi[1].getInferiore();
                }

                Collections.reverse(rotta1);

                rotta.addAll(rotta1);
                System.out.print("La rotta tra i due pianeti e': ");
                for(String s : rotta){
                    System.out.print(s+"    ");
                }
                System.out.println();
            }
            System.out.println("La distanza totale della rotta corrisponde a: "+distanza);
        }

    }

    // Calcolo centro di massa
    private static void calcoloCentroMassa(Stella stella){
        double sommaMasse, sommaX, sommaY;
        sommaMasse = stella.getMassa();
        sommaX = stella.coordX*sommaMasse;
        sommaY = stella.coordY*sommaMasse;

        for(Pianeta p : stella.getPianeti()){
            sommaMasse += p.getMassa();
            sommaX += p.coordX*p.getMassa();
            sommaY += p.coordY*p.getMassa();
            for(Luna l : p.getLune()){
                sommaMasse += l.getMassa();
                sommaX += l.coordX*l.getMassa();
                sommaY += l.coordY*l.getMassa();
            }
        }
        System.out.println("Il centro di massa corrisponde alle coordinate: ("+(Math.round((sommaX/sommaMasse*1000.0))/1000.0)+","+(Math.round((sommaY/sommaMasse*1000.0))/1000.0)+")");
    }

    // Calcolo distanza tra due corpi dati
    private static double calcolaDistanza(Corpo c1, Corpo c2){
        return Math.round(Math.sqrt(Math.pow(c1.coordX-c2.coordX, 2) + Math.pow(c1.coordY-c2.coordY, 2)) * 100.0) / 100.0;
    }

    // Genera corpi
    private static void generaCorpi(Stella stella){
        for(int i=0;i<80;i+=2){
            Pianeta p = new Pianeta("Pianeta"+i,12,i,i,stella);
            stella.aggiungiPianeta(p);
            for(int k=0;k<10;k++){
                p.aggiungiLuna(new Luna("Luna"+i+k,2,i+1,i+1,p));
            }
        }
    }

    // Cerca se esiste un corpo con lo stesso nome dato.
    private static boolean esiste (String nomeCorpo, Stella stella){
        boolean esiste = false;
        for (Pianeta p : stella.pianeti){
            if (p.getId().equalsIgnoreCase(nomeCorpo)) {
                esiste = true;
                break;
            }
            for (Luna l : p.lune){
                if (l.getId().equalsIgnoreCase(nomeCorpo)) {
                    esiste = true;
                    break;
                }
            }
        }
        return esiste;
    }

    public static void MostraCollisioni(){
        for (Corpo c: collisioni){
            System.out.println("\nIl corpo " + c.getId() + " è in rotta di collisione");
        }
    }

    private static boolean collidonoPP (Pianeta p, Stella s) {
        boolean collidono = false;

        for (Pianeta pCiclo: s.pianeti){
            if (p.getDistanza() == pCiclo.getDistanza()){
                collidono = true;
                break;
            }
        }

        return collidono;
    }

    private static boolean collidonoLL_stessaOrbita (Luna l) {
        boolean collidono = false;
        for (Luna lCiclo : l.getPianeta().getLune()){
            if (l.getDistanza() == lCiclo.getDistanza()){
                collidono = true;
                break;
            }
        }

        return collidono;
    }

    private static boolean coordLibere(int[] c, Stella stella){
        boolean diverse = true;
        for (Pianeta p : stella.pianeti) {
            if ( Arrays.equals(p.getCoord(), c) ) {
                System.out.println("\nCoordinate già occupate da: " + p.getId() + ".");
                diverse = false;
                break;
            }
            for (Luna l : p.lune) {
                if (Arrays.equals(l.getCoord(), c)) {
                    System.out.println("\nCoordinate già occupate da: " + l.getId() + ".");
                    diverse = false;
                    break;
                }
            }
        }
        return diverse;
    }


}

