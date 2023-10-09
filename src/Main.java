import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void PricipalMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("  ***** WELCOME TO OUR EAZYBANK ***** ");
        System.out.println("1 : ____ Person _____________________  ");
        System.out.println("2 : ____ Account ____________________  ");
        System.out.println("3 : ____ Operation __________________  ");
        System.out.println("4 : ____ Mission ____________________ ");
        System.out.println("5 : ____ Affectation ________________  ");
        System.out.println("6 : ____ Agence _____________________  ");

        System.out.println("\nEnter a number to implement the Method : \n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                new PersonMenu();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "2":
                new AffectationMenu();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "3":
                new OperationMenu();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "4":
                new MissionMenu();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "5":
                new AffectationMenu();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "6":
                new AgenceMenu();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            default:
                System.out.println("choice not found");
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
        }
    }

    public static void main(String[] args) throws SQLException {
        PricipalMenu();
    }
}