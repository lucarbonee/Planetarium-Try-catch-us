import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Input dell'utente
        Scanner scanner = new Scanner(System.in);
        String UserInput;

        // Punto di riferimento del sistema stellare (Stella)
        Stella stella = null;

        // Sout di formattazione
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Benvenuto in Planetarium!!!");
        System.out.println("\nPrima di tutto dobbiamo andare a creare la STELLA attorno alla quale orbitano tutti i tuoi pianeti: ");

        while (stella==null ) {
            try {


                System.out.print("\nInserisci il nome della stella: ");
                String id = scanner.nextLine();

                System.out.print("\nInserisci la massa della stella: ");
                int massa = Integer.parseInt(scanner.nextLine());

                stella = new Stella(id, massa);

            } catch (Exception e) {
                System.out.println("\n !!!!!!!!! Inserisci dei valori adeguati !!!!!!!!!");
            }
        }

        for(int i=0; i<100; i++){
            System.out.println();
        }
        System.out.println("Congratulazioni!! hai fatto il primo passo per creare il tuo fantastico sistema stellare ");
        pulisciConsole(scanner);

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

                    break;
                }
                case("cerca"):{
                    cercaCorpo(stella, scanner);
                    pulisciConsole(scanner);
                    stampaMenu(); // ho provato a mettere solo per vedere comne va
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

//        Stella s1 = new Stella("stellaaa", 25);
//        int[] s1coord = s1.getCoord();
//        System.out.println("x = " + s1coord[0] + " || y = " + s1coord[1]);
//        System.out.println("distanza = " + s1.getDistanza());
//        System.out.println( s1.getId() );
//        System.out.println( s1.getMassa() );
//        System.out.println( s1.getGrado() );
//
//        System.out.println("\n");
//
//        Pianeta p1 = new Pianeta("pianetaaa", 10, 10, 10);
//        int[] p1coord = p1.getCoord();
//        System.out.println("x = " + p1coord[0] + " || y = " + p1coord[1]);
//        System.out.println("distanza = " + p1.getDistanza());
//        System.out.println( p1.getId() );
//        System.out.println( p1.getMassa() );
//        System.out.println( p1.getGrado() );
//
//        s1.pianeti.add(p1);
//        System.out.println("\n");
//        System.out.println(s1.pianeti.getFirst().id);
//
//        System.out.println("\n");
//        Luna l1 = new Luna("Lunaaa", 2, 12, 9, p1);
//        int[] l1coord = l1.getCoord();
//        System.out.println("x = " + l1coord[0] + " || y = " + l1coord[1]);
//        System.out.println("distanza = " + l1.getDistanza());
//        System.out.println( l1.getId() );
//        System.out.println( l1.getMassa() );
//        System.out.println( l1.getGrado() );
//
//        p1.lune.add(l1);
//        System.out.println(p1.lune.getFirst().id);

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
        System.out.println("menu   -> apri questa sezione");
        System.out.println("esci   -> esci dal programma");
        System.out.println("+corpo -> crea pianeta/luna");
        System.out.println("-corpo -> rimuovi pianeta/luna");
        System.out.println("cerca  -> cerca un determinato corpo");
        System.out.println("//////////////////");
        System.out.println();
    }

    // Aggiungi corpo
    private static void aggiungiCorpo(Stella stella, Scanner scanner){
        // Scanner scanner = new Scanner(System.in);
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

                case "indietro":
                    check = false;
                    break;

                default:{
                    System.out.println("Comando non trovato, puoi aggiungere un pianeta o una luna, oppure tornare indietro");
                }
            }

        }while(check);

    }

    private static void aggiungiPianeta(Stella stella, Scanner scanner) {
        boolean check;
        int massa = 0, coordX = 0, coordY= 0;

        System.out.print("\nInserisci il nome del pianeta: ");
        String id = scanner.nextLine();

        do {
            try {
                System.out.print("\nInserisci la massa del pianeta: ");
                massa = Integer.parseInt(scanner.nextLine());
                check = false;
            }catch (Exception e){
                System.out.println("\n !!!! Inserisci dei valori adeguati !!!!");
                check = true;
            }
        }while (check);

        // Controllo aggiunto!
        do {
            check = false;
            try {
                System.out.print("\nInserisci la coordinata X del pianeta: ");
                coordX = Integer.parseInt(scanner.nextLine());
                System.out.print("\nInserisci la coordinata Y del pianeta: ");
                coordY = Integer.parseInt(scanner.nextLine());
                if ((coordX < -100 || coordY < -100) || (coordX > 100 || coordY > 100)) {
                    System.out.println("\n !!!! inserisci dei valori compresi tra -100 e 100 !!!!");
                    check = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n !!!! Inserisci dei valori adeguati !!!!");
                check = true;
            }
        } while (check);

        // Dopo aver modificato la classe Stella ho fatto modifiche qui

        Pianeta pianeta =  new Pianeta(id, massa, coordX, coordY);

        boolean aggiuntoConSuccesso = stella.aggiungiPianeta(pianeta);

        if (aggiuntoConSuccesso == true){
            System.out.println("\nPianeta '" + id + "' aggiunto con successo.");
            System.out.println("Si trova sulla sua orbita a una distanza di: " + pianeta.getDistanza());
        } else {

            System.out.println("\n Orbita già occupata ");
        }
    }

    private static void aggiungiLuna(Stella stella, Scanner scanner) {
        //Scanner scanner = new Scanner(System.in);

        System.out.print("\nInserisci il nome del pianeta a cui vuoi aggiungere la luna: ");
        String nomePianetaCercato = scanner.nextLine();

        Pianeta pianetaTrovato = null;

        // Cerco il pianeta nella lista della stella
        for(int i = 0; i < stella.getPianeti().size(); i++) {
            Pianeta p = stella.getPianeti().get(i);
            if (p.getId().equalsIgnoreCase(nomePianetaCercato)) {
                pianetaTrovato = p;
                break; // Pianeta trovato
            }
        }

        if (pianetaTrovato == null) {
            System.out.println("\nnon trovato nel sistema stellare!");
            return;
        }

        System.out.print("\nInserisci il nome della luna: ");
        String idLuna = scanner.nextLine();

        boolean check;
        int massa = 0, coordX = 0, coordY = 0;

        // Controllo massa
        do {
            try {
                System.out.print("\nInserisci la massa della luna: ");
                massa = Integer.parseInt(scanner.nextLine());
                check = false;
            }catch (Exception e){
                System.out.println("\n !!!! Inserisci dei valori adeguati !!!!");
                check = true;
            }
        }while (check);

        // Controllo coordinate
        do {
            check = false;
            try {
                System.out.print("\nInserisci la coordinata X della luna: ");
                coordX = Integer.parseInt(scanner.nextLine());
                System.out.print("\nInserisci la coordinata Y della luna: ");
                coordY = Integer.parseInt(scanner.nextLine());
                if ((coordX < -100 || coordY < -100) || (coordX > 100 || coordY > 100)) {
                    System.out.println("\n !!!! inserisci dei valori compresi tra -100 e 100 !!!!");
                    check = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n !!!! Inserisci dei valori adeguati !!!!");
                check = true;
            }
        } while (check);

        Luna nuovaLuna = new Luna(idLuna, massa, coordX, coordY, pianetaTrovato);

        boolean aggiuntoConSuccesso = pianetaTrovato.aggiungiLuna(nuovaLuna);

        if (aggiuntoConSuccesso == true) {
            System.out.println("\nLuna '" + idLuna + "' aggiunta con successo attorno al pianeta '" + pianetaTrovato.getId() + "'!");
            System.out.println("Distanza dal pianeta: " + nuovaLuna.getDistanza());
        } else {
            System.out.println(" Non riuscito, l'orbita è già occupata da un'altra luna oppure la distanza supera la massa del pianeta.");
        }
    }

    // TODO
    // Rimuovi corpo
    // Cerca corpo

    private static void cercaCorpo(Stella stella, Scanner scanner){
        // Scanner scanner = new Scanner(System.in);

        System.out.println("\n Inserire il nome del corpo da cercare: ");
        String nomeCercato = scanner.nextLine();

        System.out.println("\n Ricerca in corso di: " + nomeCercato );

        // vado a controllare la stella

        if (stella.getId().equalsIgnoreCase(nomeCercato)){
            System.out.println(" Corpo trovato,  e' la stella del sistema.");
            System.out.println("- Nome: " + stella.getId());
            System.out.println("- Massa: " + stella.getMassa());
            int[] coordinate = stella.getCoord();
            System.out.println("- Coordinate: (" + coordinate[0] + ", " + coordinate[1] + ")");

            return;
        }

        // vado a controllare i pianeti e le lune

        for (int i = 0; i < stella.getPianeti().size(); i++){
            Pianeta pianetaAttuale = stella.getPianeti().get(i);

            // voglio vedere se è il pianta che cerchiamo
            if (pianetaAttuale.getId().equalsIgnoreCase(nomeCercato)){
                System.out.println("\n Trovato e' un Pianeta.");
                System.out.println("- Nome: " + pianetaAttuale.getId());
                System.out.println("- Massa: " + pianetaAttuale.getMassa());
                int[] coordinate = pianetaAttuale.getCoord();
                System.out.println("- Coordinate: (" + coordinate[0] + ", " + coordinate[1] + ")");
                System.out.println("- Distanza dalla Stella: " + pianetaAttuale.getDistanza());

                return;
            }

            for (int j = 0; j < pianetaAttuale.getLune().size(); j++){
                Luna lunaAttuale = pianetaAttuale.getLune().get(j);

                if (lunaAttuale.getId().equalsIgnoreCase(nomeCercato)) {
                    System.out.println("Trovato! È una Luna.");
                    System.out.println("- Nome: " + lunaAttuale.getId());
                    System.out.println("- Orbita attorno a: " + pianetaAttuale.getId());
                    System.out.println("- Massa: " + lunaAttuale.getMassa());
                    int[] coordinate = lunaAttuale.getCoord();
                    System.out.println("- Coordinate: (" + coordinate[0] + ", " + coordinate[1] + ")");
                    System.out.println("- Distanza dal suo Pianeta: " + lunaAttuale.getDistanza());

                    return;
                }
            }
        }
        // qua scriverei altro
        System.out.println("\n !!!! Inserisci dei valori adeguati !!!!");

    }



}

