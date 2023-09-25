import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void PricipalMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("************ WELCOME TO OUR EazyBank ******************** ");
        System.out.println("1 : ______________ Add Employee ____________________  ");
        System.out.println("2 : ______________ get one Employee __________________  ");
        System.out.println("3 : ______________ get all Employees _________________  ");
        System.out.println("4 : ______________ Delete Employee _________________  ");
        System.out.println("5 : ______________ Update Employee _________________  ");
        System.out.println("\nEnter a number to implement the Method : \n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                menu.insertEmploye();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "2":
                menu.getOneEmploye();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "3":
                menu.getAllEmployes();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "4":
                menu.deleteEmploye();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "5":
                menu.updateEmployee();
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