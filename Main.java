import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Input dell'utente
        Scanner scanner = new Scanner(System.in);
        String UserInput;

        // Punto di riferimento del sistema stellare
        Stella stella;


        // Main loop
        stampaMenu();
        do{
            System.out.print("-- ");
            UserInput = scanner.nextLine();

            switch (UserInput.toLowerCase()){
                case("menu"):{
                    stampaMenu();
                    pulisciConsole();
                    break;
                }
                case("+corpo"):{

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
        System.out.println("menu -> apri questa sezione");
        System.out.println("esci -> esci dal programma");
        System.out.println("+corpo -> crea stella/pianeta/luna");
        System.out.println("-corpo -> romuovi stella/pianeta/luna");
        System.out.println("//////////////////");
    }

    // Aggiungi corpo
    private void aggiungiCorpo(){

    }


    // Rimuovi corpo

}

