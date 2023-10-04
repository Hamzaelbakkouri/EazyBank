import java.sql.SQLException;
import java.util.Scanner;

public class OperationMenu {
    public OperationMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 : ____________ insert Operation ________________ ");
        System.out.println("2 : ___________ delete Operation _________________ ");
        System.out.println("3 : ___ get One Operation By operation Number ____ ");
        System.out.println("4 : ______ get Account By operation Number _______ ");

        System.out.println("\nEnter a number to implement the Method : \n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                menu.insertOperation();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "2":
                menu.deleteOperation();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "3":
                menu.getOneOperation();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "4":
                menu.SearchByOpNumType();
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
