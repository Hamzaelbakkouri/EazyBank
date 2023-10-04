import java.sql.SQLException;
import java.util.Scanner;

public class AffectationMenu {
    public AffectationMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 : _____________ New Affectation ________________  ");
        System.out.println("2 : _______ get Affectations With Employee _______  ");

        System.out.println("\nEnter a number to implement the Method : \n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                menu.insertAffectation();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "2":
                menu.getAffectationsWithEmployee();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            default:
                System.out.println("choice not found");
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
        }
    }
}
