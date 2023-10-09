import DAO.AgenceIMPL;
import DTO.Agence;
import DTO.Employee;
import INTERFACES2.AgenceDAO;
import SERVICE.AgenceService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class AgenceMenu {
    Scanner scanner = new Scanner(System.in);
    AgenceDAO agenceImpl = new AgenceIMPL();
    AgenceService newAgence = new AgenceService(agenceImpl);

    public AgenceMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 : _____________ Create Agence __________________  ");
        System.out.println("2 : ___________ get Agence by code _______________  ");
        System.out.println("3 : _________ get Agence by adresse ______________  ");
        System.out.println("4 : _____________ get All Agency _________________  ");
        System.out.println("5 : ____________ get By Employee _________________  ");
        System.out.println("6 : ___________ get Agences Contat _______________  ");
        System.out.println("7 : ______________ update Agence _________________  ");
        System.out.println("8 : ______________ delete Agence _________________  ");

        System.out.println("\nEnter a number to implement the Method : \n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                insertAgence();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "2":
                getOneByCode();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "3":
                getOneByAdresse();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "4":
                getAll();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "5":
                getOneByEmployee();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "6":
                contact();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "7":
                updateAgence();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    Main.PricipalMenu();
                } else {
                    break;
                }
            case "8":
                deleteAgence();
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

    public void insertAgence() {
        System.out.println("Enter Agence Code :");
        String Code = scanner.nextLine();
        System.out.println("Enter Agence Name :");
        String Name = scanner.nextLine();
        System.out.println("Enter Agence Adresse :");
        String adresse = scanner.nextLine();
        System.out.println("Enter Agence PhoneNumber :");
        String PhoneNumber = scanner.nextLine();

        Agence agence = new Agence(Code, Name, adresse, PhoneNumber);
        Optional<Agence> thNewAgency = newAgence.insert(agence);
        if (thNewAgency.isPresent()) {
            System.out.println("Agence Code : " + thNewAgency.get().getCode());
            System.out.println("Agence Name : " + thNewAgency.get().getName());
            System.out.println("Agence adresse : " + thNewAgency.get().getAdresse());
            System.out.println("Agence PhoneNumber : " + thNewAgency.get().getPhoneNumber());
        } else {
            System.out.println("Agency Not Found");
        }
    }

    public void updateAgence() {
        System.out.println("update Agence Code :");
        String Code = scanner.nextLine();
        System.out.println("update Agence Name :");
        String Name = scanner.nextLine();
        System.out.println("update Agence Adresse :");
        String adresse = scanner.nextLine();
        System.out.println("update Agence PhoneNumber :");
        String PhoneNumber = scanner.nextLine();

        Agence agence = new Agence(Code, Name, adresse, PhoneNumber);
        Optional<Agence> thNewAgency = newAgence.update(agence);
        if (thNewAgency.isPresent()) {
            System.out.println("Agence Code : " + Code);
            System.out.println("Agence Name : " + thNewAgency.get().getName());
            System.out.println("Agence adresse : " + thNewAgency.get().getAdresse());
            System.out.println("Agence PhoneNumber : " + thNewAgency.get().getPhoneNumber());
        } else {
            System.out.println("Agency Not Found");
        }
    }

    public void getOneByCode() {
        System.out.println("Enter Agence Code :");
        String Code = scanner.nextLine();

        Agence agence = new Agence();
        agence.setCode(Code);
        Optional<Agence> thNewAgency = newAgence.findByCode(agence);
        if (thNewAgency.isPresent()) {
            System.out.println("Agence Code : " + Code);
            System.out.println("Agence Name : " + thNewAgency.get().getName());
            System.out.println("Agence adresse : " + thNewAgency.get().getAdresse());
            System.out.println("Agence PhoneNumber : " + thNewAgency.get().getPhoneNumber());
            System.out.println("________________________________________________________________");
        } else {
            System.out.println("Agency Not Found");
        }
    }

    public void getOneByAdresse() {
        System.out.println("Enter Agence Code :");
        String adresse = scanner.nextLine();

        Agence agence = new Agence();
        agence.setAdresse(adresse);
        Optional<Agence> thNewAgency = newAgence.getByAdress(agence);
        if (thNewAgency.isPresent()) {
            System.out.println("Agence adresse : " + adresse);
            System.out.println("Agence Code : " + thNewAgency.get().getCode());
            System.out.println("Agence Name : " + thNewAgency.get().getName());
            System.out.println("Agence PhoneNumber : " + thNewAgency.get().getPhoneNumber());
            System.out.println("________________________________________________________________");
        } else {
            System.out.println("Agency Not Found");
        }
    }

    public void getOneByEmployee() {
        System.out.println("Enter Employee registration number :");
        String Rnum = scanner.nextLine();

        Employee employe = new Employee();
        employe.setRegistrationNumber(Rnum);
        List<Agence> thNewAgency = newAgence.getByEmployee(employe);
        for (Agence agence : thNewAgency) {
            System.out.println("Agence Name : " + agence.getName());
            System.out.println("Agence Code : " + agence.getCode());
            System.out.println("Agence adresse : " + agence.getAdresse());
            System.out.println("Agence PhoneNumber : " + agence.getPhoneNumber());
            System.out.println("________________________________________________________________");

        }
    }

    public void getAll() {
        List<Agence> thNewAgency = newAgence.getAll();
        for (Agence agence : thNewAgency) {
            System.out.println("Agence Name : " + agence.getName());
            System.out.println("Agence Code : " + agence.getCode());
            System.out.println("Agence adresse : " + agence.getAdresse());
            System.out.println("Agence PhoneNumber : " + agence.getPhoneNumber());
            System.out.println("________________________________________________________________");

        }
    }

    public void contact() {
        List<Agence> thNewAgency = newAgence.agenceContact();
        for (Agence agence : thNewAgency) {
            System.out.println("Agence adresse : " + agence.getAdresse());
            System.out.println("Agence PhoneNumber : " + agence.getPhoneNumber());
            System.out.println("________________________________________________________________");
        }
    }

    public void deleteAgence() {
        System.out.println("Enter Agence Code : ");
        String Code = scanner.nextLine();
        Agence agence = new Agence();
        agence.setCode(Code);
        boolean isDeleted = newAgence.delete(agence);
        if (isDeleted) {
            System.out.println("Agence deleted successfully");
        } else {
            System.out.println("something went wrong");
        }
    }
}
