import DAO.EmployeeIMPL;
import DTO.Client;
import DTO.CurrentAccount;
import DTO.Employee;
import INTERFACES.statut;
import SERVICE.ClientService;
import SERVICE.CurentAccountService;
import SERVICE.EmployeeService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class menu {
    public static void getOneEmploye() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Registration Employee Number :");
        String num = scanner.nextLine();
        EmployeeService personService = new EmployeeService();
        Optional<Employee> getOneEmploye = personService.getOneByRegistrationNum(num);
        Employee Employee = getOneEmploye.get();

        System.out.println("registration Number : " + Employee.getRegistrationNumber());
        System.out.println("Recrutment Date : " + Employee.getRecruitmentDate());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("email : " + Employee.getEmail());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void getAllEmployes() throws SQLException {
        EmployeeIMPL employedao = new EmployeeIMPL();
        List<Optional<Employee>> Employes = employedao.getAll();
        int counter = 1;
        for (Optional<Employee> employeee : Employes) {
            System.out.println("Book number " + counter + ":");
            System.out.println("registration Number : " + employeee.get().getRegistrationNumber());
            System.out.println("Recrutment Date : " + employeee.get().getRecruitmentDate());
            System.out.println("first name : " + employeee.get().getFirstName());
            System.out.println("last name : " + employeee.get().getLastName());
            System.out.println("Date Of Birth : " + employeee.get().getDateOfBirth());
            System.out.println("email : " + employeee.get().getEmail());
            System.out.println("phone number : " + employeee.get().getPhoneNumber());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public static void searchByAllAttributs() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        EmployeeIMPL employedao = new EmployeeIMPL();
        System.out.println("Enter any Attribute :");
        String Attribute = scanner.nextLine();
        List<Optional<Employee>> Employes = employedao.searchByAllAttributs(Attribute);
        int counter = 1;
        for (Optional<Employee> employeee : Employes) {
            System.out.println("Book number " + counter + ":");
            System.out.println("registration Number : " + employeee.get().getRegistrationNumber());
            System.out.println("Recrutment Date : " + employeee.get().getRecruitmentDate());
            System.out.println("first name : " + employeee.get().getFirstName());
            System.out.println("last name : " + employeee.get().getLastName());
            System.out.println("Date Of Birth : " + employeee.get().getDateOfBirth());
            System.out.println("email : " + employeee.get().getEmail());
            System.out.println("phone number : " + employeee.get().getPhoneNumber());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public static void insertEmploye() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration Number :");
        String registrationNumber = scanner.nextLine();
        System.out.println("Enter Recrutment Date  :");
        LocalDate RecrutmentDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter first name  :");
        String firstname = scanner.nextLine();
        System.out.println("Enter last name :");
        String lastname = scanner.nextLine();
        System.out.println("Enter Date Of Birth :");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter email :");
        String email = scanner.nextLine();
        System.out.println("Enter phone number :");
        String phonenumber = scanner.nextLine();


        EmployeeService employeeService = new EmployeeService();
        Employee newEmploye = new Employee(firstname, lastname, DateOfBirth, phonenumber, registrationNumber, RecrutmentDate, email);
        Optional<Employee> Data = employeeService.insertEmployee(newEmploye);
        Employee Employee = Data.get();

        System.out.println("\nThe New Employe :");
        System.out.println("registration Number : " + Employee.getRegistrationNumber());
        System.out.println("Recrutment Date : " + Employee.getRecruitmentDate());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("email : " + Employee.getEmail());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration Number to Update Employee:");
        String registrationNumber = scanner.nextLine();
        System.out.println("Update Recrutment Date  :");
        LocalDate RecrutmentDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Update first name  :");
        String firstname = scanner.nextLine();
        System.out.println("Update last name :");
        String lastname = scanner.nextLine();
        System.out.println("Update Date Of Birth :");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Update email :");
        String email = scanner.nextLine();
        System.out.println("Update phone number :");
        String phonenumber = scanner.nextLine();


        EmployeeService employeeService = new EmployeeService();
        Employee newEmploye = new Employee(firstname, lastname, DateOfBirth, phonenumber, registrationNumber, RecrutmentDate, email);
        Optional<Employee> Data = employeeService.updateEmployee(newEmploye);
        Employee Employee = Data.get();

        System.out.println("\nThe New Employe :");
        System.out.println("registration Number : " + Employee.getRegistrationNumber());
        System.out.println("Recrutment Date : " + Employee.getRecruitmentDate());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("email : " + Employee.getEmail());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void deleteEmploye() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration number for Employe : ");
        String Rnum = scanner.nextLine();
        EmployeeService employeeService = new EmployeeService();
        Boolean isDeleted = employeeService.deleteEmployee(Rnum);
        if (isDeleted) {
            System.out.println("deleted Successfully");
        } else {
            System.out.println("delete Failed");
        }
    }


//    CLIENT SIDE


    public static void getOneClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Client Code :");
        String num = scanner.nextLine();
        ClientService personService = new ClientService();
        Optional<Client> getOneEmploye = personService.getOneByCode(num);
        Client Employee = getOneEmploye.get();

        System.out.println("Code : " + Employee.getCode());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("adress : " + Employee.getAdress());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void getAllClients() throws SQLException {
        ClientService employedao = new ClientService();
        List<Optional<Client>> Employes = employedao.getAll();
        int counter = 1;
        for (Optional<Client> employeee : Employes) {
            System.out.println("Book number " + counter + ":");
            System.out.println("Code : " + employeee.get().getCode());
            System.out.println("first name : " + employeee.get().getFirstName());
            System.out.println("last name : " + employeee.get().getLastName());
            System.out.println("Date Of Birth : " + employeee.get().getDateOfBirth());
            System.out.println("Adress : " + employeee.get().getAdress());
            System.out.println("phone number : " + employeee.get().getPhoneNumber());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public static void searchByAttributsClients() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ClientService employedao = new ClientService();
        System.out.println("Enter any Attribute :");
        String Attribute = scanner.nextLine();
        List<Optional<Client>> Employes = employedao.searchByAttributs(Attribute);
        int counter = 1;
        for (Optional<Client> employeee : Employes) {
            System.out.println("Book number " + counter + ":");
            System.out.println("Code : " + employeee.get().getCode());
            System.out.println("first name : " + employeee.get().getFirstName());
            System.out.println("last name : " + employeee.get().getLastName());
            System.out.println("Date Of Birth : " + employeee.get().getDateOfBirth());
            System.out.println("Adress : " + employeee.get().getAdress());
            System.out.println("phone number : " + employeee.get().getPhoneNumber());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public static void insertClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Code :");
        String code = scanner.nextLine();
        System.out.println("Enter first name  :");
        String firstname = scanner.nextLine();
        System.out.println("Enter last name :");
        String lastname = scanner.nextLine();
        System.out.println("Enter Date Of Birth :");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter Adress :");
        String adress = scanner.nextLine();
        System.out.println("Enter phone number :");
        String phonenumber = scanner.nextLine();


        ClientService employeeService = new ClientService();
        Client newEmploye = new Client(firstname, lastname, DateOfBirth, phonenumber, code, adress);
        Optional<Client> Data = employeeService.insertClient(newEmploye);
        Client Employee = Data.get();

        System.out.println("\nThe New Employe :");
        System.out.println("Code : " + Employee.getCode());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("adress : " + Employee.getAdress());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void updateClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Code to Update Client:");
        String code = scanner.nextLine();
        System.out.println("Update first name  :");
        String firstname = scanner.nextLine();
        System.out.println("Update last name :");
        String lastname = scanner.nextLine();
        System.out.println("Update Date Of Birth :");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Update Adress :");
        String Adress = scanner.nextLine();
        System.out.println("Update phone number :");
        String phonenumber = scanner.nextLine();


        ClientService employeeService = new ClientService();
        Client newEmploye = new Client(firstname, lastname, DateOfBirth, phonenumber, code, Adress);
        Optional<Client> Data = employeeService.updateClient(newEmploye);
        Client Employee = Data.get();

        System.out.println("\nThe New Employe :");
        System.out.println("Code : " + Employee.getCode());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("adress : " + Employee.getAdress());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void deleteClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration number for Employe : ");
        String Rnum = scanner.nextLine();
        ClientService ClientService = new ClientService();
        Boolean isDeleted = ClientService.deleteClient(Rnum);
        if (isDeleted) {
            System.out.println("deleted Successfully");
        } else {
            System.out.println("delete Failed");
        }
    }

//    Account Side

    public static void insertCurrentAcc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Client Code To Create Current account :");
        String clientCode = scanner.nextLine();

        ClientService personService = new ClientService();
        Optional<Client> getOneEmploye = personService.getOneByCode(clientCode);
        Client client = getOneEmploye.get();

        System.out.println("Enter accnum :");
        String accnum = scanner.nextLine();
        System.out.println("Enter Balance :");
        double balance = Double.parseDouble(scanner.nextLine());
        LocalDate creationdate = LocalDate.now();
        System.out.println("Enter maxprice :");
        double maxprice = Double.parseDouble(scanner.nextLine());


        CurentAccountService curentaccountService = new CurentAccountService();
        CurrentAccount newCurrentAccount = new CurrentAccount(accnum, balance, creationdate, statut.active, client, maxprice);
        Optional<CurrentAccount> Data = curentaccountService.insertCurrentAcc(newCurrentAccount);
        CurrentAccount Currentaccount = Data.get();

        System.out.println("\nThe New Account :");
        System.out.println("Account Number : " + Currentaccount.getAccNum());
        System.out.println("Client Code : " + Currentaccount.getClient().getCode());
        System.out.println("max price : " + Currentaccount.getMaxPrice());
        System.out.println("Balance : " + Currentaccount.getBalance());
        System.out.println("Statut : " + Currentaccount.getStatut());
        System.out.println("Creation Date : " + Currentaccount.getCreationDate());
        System.out.println("---------------------------------------");
    }

    public static void insertSavingAcc() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Client Code To Create Current account :");
//        String clientCode = scanner.nextLine();
//
//        ClientService personService = new ClientService();
//        Optional<Client> getOneEmploye = personService.getOneByCode(clientCode);
//        Client client = getOneEmploye.get();
//
//        System.out.println("Enter accnum :");
//        String accnum = scanner.nextLine();
//        System.out.println("Enter Balance :");
//        double balance = Double.parseDouble(scanner.nextLine());
//        System.out.println("Enter creation date :");
//        LocalDate creationdate = LocalDate.parse(scanner.nextLine());
//        System.out.println("Enter phone number :");
//        double maxprice = Double.parseDouble(scanner.nextLine());
//
//
//        CurentAccountService curentaccountService = new CurentAccountService();
//        CurrentAccount newCurrentAccount = new CurrentAccount(accnum, balance, creationdate, statut.active, client, maxprice);
//        Optional<CurrentAccount> Data = curentaccountService.insertCurrentAcc(newCurrentAccount);
//        CurrentAccount Currentaccount = Data.get();
//
//        System.out.println("\nThe New Account :");
//        System.out.println("Account Number : " + Currentaccount.getAccNum());
//        System.out.println("Client Code : " + Currentaccount.getClient().getCode());
//        System.out.println("max price : " + Currentaccount.getMaxPrice());
//        System.out.println("Balance : " + Currentaccount.getBalance());
//        System.out.println("Statut : " + Currentaccount.getStatut());
//        System.out.println("Creation Date : " + Currentaccount.getCreationDate());
//        System.out.println("---------------------------------------");
    }

    public static void chooseAccountType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : to create Current account \n2 : to create Saving account ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            insertCurrentAcc();
        } else if (choice == 2) {
            insertSavingAcc();
        } else {
            System.out.println("wrong choice !!");
        }
    }

    public static void searchForCurrentAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Client code to search for an CurrentAccount");
        String Client_code = scanner.nextLine();
        CurentAccountService CurentAccountservicee = new CurentAccountService();
        Optional<CurrentAccount> CurentAccount = CurentAccountservicee.getOneCurrentAccount(Client_code);
        CurrentAccount acc = CurentAccount.get();

        System.out.println("\nThe Account :");
        System.out.println("Account Number : " + acc.getAccNum());
        System.out.println("Client First name : " + acc.getClient().getFirstName());
        System.out.println("Client Last name : " + acc.getClient().getLastName());
        System.out.println("Client Code : " + acc.getClient().getCode());
        System.out.println("max price : " + acc.getMaxPrice() + "DH");
        System.out.println("Balance : " + acc.getBalance() + "DH");
        System.out.println("Statut : " + acc.getStatut());
        System.out.println("Creation Date : " + acc.getCreationDate());
        System.out.println("---------------------------------------");
    }

    public static void searchForSavingAccount() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Account number to search for an CurrentAccount");
//        String accnum = scanner.nextLine();
//        CurentAccountService CurentAccountservicee = new CurentAccountService();
//        Optional<CurrentAccount> CurentAccount = CurentAccountservicee.getOneCurrentAccount(accnum);

    }

    public static void SearchAccountType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : to search a Current account \n2 : to search a Saving account ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            searchForCurrentAccount();
        } else if (choice == 2) {
            searchForSavingAccount();
        } else {
            System.out.println("wrong choice !!");
        }
    }
}
