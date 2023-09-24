import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void PricipalMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                menu.getOneEmploye();
            case "3":
                System.out.println("hamza");
            default:
                System.out.println("choice not found");
        }
    }
    public static void main(String[] args) throws SQLException {
        PricipalMenu();
        Scanner scanner = new Scanner(System.in);
        if (Integer.parseInt(scanner.nextLine()) == 1) {
            PricipalMenu();
        } else {
            return;
        }
    }
}