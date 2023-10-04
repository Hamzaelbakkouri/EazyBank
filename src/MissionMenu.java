import java.sql.SQLException;
import java.util.Scanner;

public class MissionMenu {
    public MissionMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 : _____________ get all missions ________________  ");
        System.out.println("2 : ______________ Insert mission _________________  ");
        System.out.println("3 : ______________ Delete Mission _________________  ");

        System.out.println("\nEnter a number to implement the Method : \n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                menu.getAllMission();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "2":
                menu.insertMission();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "3":
                menu.deleteMission();
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
