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
    }

    // Gestore leggibilità console
    private static void pulisciConsole(){
        System.out.println();
        System.out.print("Premi un tasto per continuare ");
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

    // Rimuovi corpo

}

