import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // variabile di controllo
        boolean check = true;

        // Input dell'utente
        Scanner scanner = new Scanner(System.in);
        String UserInput;

        // Punto di riferimento del sistema stellare (Stella)
        Stella stella = null;
        System.out.println("\nPrima di tutto dobbiamo andare a creare la STELLA attorno alla quale orbitano tutti i nostri pianeti: ");

        while (check) {
            try {
                System.out.print("\nInserisci il nome della stella: ");
                String id = scanner.nextLine();
                System.out.print("\nInserisci la massa della stella: ");
                int massa = Integer.parseInt(scanner.nextLine());
                stella = new Stella(id, massa);

                check = false;
            } catch (Exception e) {
                System.out.println("\n !!!!!!!!! Inserisci dei valori adeguati !!!!!!!!!");
            }
        }




        // Main loop
        stampaMenu();
        do{
            System.out.print("~home~ ");
            UserInput = scanner.nextLine();

            switch (UserInput.toLowerCase()){
                case("menu"):{
                    stampaMenu();
                    pulisciConsole();
                    break;
                }
                case("+corpo"):{
                    aggiungiCorpo(stella);
                    pulisciConsole();
                    break;
                }
                case("-corpo"):{

                    break;
                }
                case("esci"):{
                    System.out.println("Ciao bello :)");
                    break;
                }
                default:{
                    System.out.print("Comando non trovato :(");
                    pulisciConsole();
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

    // Gestore leggibilità console
    private static void pulisciConsole(){
        System.out.println();
        System.out.print("Premi invio per continuare ");
        Scanner s = new Scanner(System.in);
        s.nextLine();
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
    }

    // Aggiungi corpo
    private static void aggiungiCorpo(Stella stella){
        Scanner scanner = new Scanner(System.in);
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
                    aggiungiPianeta(stella);
                    break;
                }

                case "luna":{
                    check = false;
                    aggiungiLuna();
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

    private static void aggiungiPianeta(Stella s) {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInserisci il nome del pianeta: ");
        String id = scanner.nextLine();
        int massa = 0;
        int coordX;
        int coordY;

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


        do {
            check = false;
            System.out.print("\nInserisci la coordinata X del pianeta: ");
            coordX = Integer.parseInt(scanner.nextLine());
            System.out.print("\nInserisci la coordinata Y del pianeta: ");
            coordY = Integer.parseInt(scanner.nextLine());
            if((coordX < -100 || coordY < -100) || (coordX > 100 || coordY > 100 )) {
                System.out.println("\n !!!! inserisci dei valori compresi tra -100 e 100 !!!!");
                check = true;
            }
        }while (check);

        s.pianeti.add(new Pianeta(id, massa, coordX, coordY));

        System.out.println("pianeta aggiunto");
    }

    private static void aggiungiLuna() {



        System.out.println("luna aggiunta");
    }


    // Rimuovi corpo

}

