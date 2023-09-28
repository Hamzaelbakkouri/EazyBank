import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void PricipalMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("************ WELCOME TO OUR EazyBank ******************** ");
        System.out.println("1 : ______________ Add Employee ____________________  ");
        System.out.println("2 : ____________ search one Employee _______________  ");
        System.out.println("3 : _____________ get all Employees ________________  ");
        System.out.println("4 : ______________ Delete Employee _________________  ");
        System.out.println("5 : ______________ Update Employee _________________  ");
        System.out.println("6 : ____ Search Employes with all Attributes _______  ");
        System.out.println("7 : ________________ Add Client ____________________  ");
        System.out.println("8 : ____________ search one Client _________________  ");
        System.out.println("9 : _____________ get all Clients __________________  ");
        System.out.println("10 : ______________ Delete Client __________________  ");
        System.out.println("11 : ______________ Update Client __________________  ");
        System.out.println("12 : _____ Search Client with all Attributes _______  ");
        System.out.println("13 : _____________ create account __________________  ");
        System.out.println("14 : ____________ search an account ________________  ");
        System.out.println("15 : _____________ updtae account __________________  ");
        System.out.println("15 : ____________ get All accounts ________________  ");
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
            case "6":
                menu.searchByAllAttributs();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "7":
                menu.insertClient();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "8":
                menu.getOneClient();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "9":
                menu.getAllClients();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "10":
                menu.deleteClient();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "11":
                menu.updateClient();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "12":
                menu.searchByAttributsClients();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "13":
                menu.chooseAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "14":
                menu.SearchAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "15":
                menu.updtaeAccountType();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PricipalMenu();
                } else {
                    break;
                }
            case "16":
                menu.getAllAccountType();
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