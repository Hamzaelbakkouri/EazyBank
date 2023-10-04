import java.sql.SQLException;
import java.util.Scanner;

public class AccountMenu {
    public AccountMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 : _____________ create account __________________  ");
        System.out.println("2 : ____________ search an account ________________  ");
        System.out.println("3 : _____________ updtae account __________________  ");
        System.out.println("4 : ____________ get All accounts _________________  ");
        System.out.println("5 : ______________ get By Status __________________  ");
        System.out.println("6 : __________ get By Creation Date _______________  ");
        System.out.println("7 : ______________ get By Client __________________  ");
        System.out.println("8 : _____________ deleted Account _________________  ");

        System.out.println("\nEnter a number to implement the Method : \n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                menu.chooseAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "2":
                menu.SearchAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "3":
                menu.updtaeAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "4":
                menu.getAllAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "5":
                menu.getByStatutAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "6":
                menu.getByCreationDateAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "7":
                menu.getByClientAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "8":
                menu.DeleteAccountType();
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
