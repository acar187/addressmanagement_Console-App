import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Adressbuch adressbuch = new Adressbuch();
        adressbuch.kontakteLaden("liste.txt");

        adressbuch.alleKontakteAnzeigen();

        boolean weiter = true;
        while (weiter) {
            System.out.println("\n--- Adressbuch Menu ---");
            System.out.println("1. Alle Kontakte anzeigen");
            System.out.println("2. Neuen Kontakt hinzufügen");
            System.out.println("3. Beenden");
            System.out.print("Wahl:");

            int wahl = scanner.nextInt();
            scanner.nextLine(); //Eingabezeile leeren

            switch (wahl) {
                case 1:
                    adressbuch.alleKontakteAnzeigen();
                    break;
                case 2:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Telefon: ");
                    String telefon = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Kontakt k = new Kontakt(name, telefon, email);
                    adressbuch.kontaktHinzufügen(k);
                    adressbuch.kontakteSpeichern("liste.txt");
                    System.out.println("Kontakt gespeichert.");
                    break;
                case 3: 
                    weiter = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
                }
            }

            scanner.close();
        }
}
