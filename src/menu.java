import DAO.EmployeeIMPL;
import DTO.Client;
import DTO.CurrentAccount;
import DTO.Employee;
import DTO.SavingAccount;
import INTERFACES.statut;
import SERVICE.ClientService;
import SERVICE.CurentAccountService;
import SERVICE.EmployeeService;
import SERVICE.SavingAccountService;

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
        Map<String, Optional<Employee>> Employes = employedao.getAll();

        for (Map.Entry<String, Optional<Employee>> entry : Employes.entrySet()) {
            String accountNumber = entry.getKey();
            Optional<Employee> currentAccountOptional = entry.getValue();

            if (currentAccountOptional.isPresent()) {
                Employee currentAccount = currentAccountOptional.get();
                System.out.println("Account Number: " + accountNumber);
                System.out.println("registration Number : " + currentAccount.getRegistrationNumber());
                System.out.println("Recrutment Date : " + currentAccount.getRecruitmentDate());
                System.out.println("first name : " + currentAccount.getFirstName());
                System.out.println("last name : " + currentAccount.getLastName());
                System.out.println("Date Of Birth : " + currentAccount.getDateOfBirth());
                System.out.println("email : " + currentAccount.getEmail());
                System.out.println("phone number : " + currentAccount.getPhoneNumber());
                System.out.println("---------------------------------------");

            } else {
                System.out.println("Account Number: " + accountNumber);
                System.out.println(" Current Accounts not found.");
            }
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
        Map<String, Optional<Client>> Clients = employedao.getAll();

        for (Map.Entry<String, Optional<Client>> entry : Clients.entrySet()) {
            String accountNumber = entry.getKey();
            Optional<Client> currentAccountOptional = entry.getValue();

            if (currentAccountOptional.isPresent()) {
                Client currentAccount = currentAccountOptional.get();
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Code : " + currentAccount.getCode());
                System.out.println("first name : " + currentAccount.getFirstName());
                System.out.println("last name : " + currentAccount.getLastName());
                System.out.println("Date Of Birth : " + currentAccount.getDateOfBirth());
                System.out.println("adress : " + currentAccount.getAdress());
                System.out.println("phone number : " + currentAccount.getPhoneNumber());
                System.out.println("---------------------------------------");

            } else {
                System.out.println("Account Number: " + accountNumber);
                System.out.println(" Current Accounts not found.");
            }
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
        System.out.println("Enter Employee registration num To Create Saving account :");
        String employee = scanner.nextLine();
        EmployeeService EmployeService = new EmployeeService();
        Optional<Employee> getoneEmployee = EmployeService.getOneByRegistrationNum(employee);

        System.out.println("Enter Client Code To Create Current account :");
        String clientCode = scanner.nextLine();

        ClientService personService = new ClientService();
        Optional<Client> getOneEmploye = personService.getOneByCode(clientCode);
        if (getOneEmploye.isPresent()) {

            Client client = getOneEmploye.get();
            Employee employe = getoneEmployee.get();
            System.out.println("Enter accnum :");
            String accnum = scanner.nextLine();
            System.out.println("Enter Balance :");
            double balance = Double.parseDouble(scanner.nextLine());
            LocalDate creationdate = LocalDate.now();
            System.out.println("Enter maxprice :");
            double maxprice = Double.parseDouble(scanner.nextLine());


            CurentAccountService curentaccountService = new CurentAccountService();
            CurrentAccount newCurrentAccount = new CurrentAccount(accnum, balance, creationdate, statut.active, client, maxprice, employe);
            Optional<CurrentAccount> Data = curentaccountService.insertCurrentAcc(newCurrentAccount);
            if (Data.isPresent()) {
                CurrentAccount Currentaccount = Data.get();

                System.out.println("\nThe New Account :");
                System.out.println("Account Number : " + Currentaccount.getAccNum());
                System.out.println("Client Code : " + Currentaccount.getClient().getCode());
                System.out.println("max price : " + Currentaccount.getMaxPrice());
                System.out.println("Balance : " + Currentaccount.getBalance());
                System.out.println("Statut : " + Currentaccount.getStatut());
                System.out.println("Creation Date : " + Currentaccount.getCreationDate());
                System.out.println("---------------------------------------");
            } else {
                System.out.println("Current account not found");
            }
        } else {
            System.out.println("Client not found");
        }
    }

    public static void insertSavingAcc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee registration num To Create Saving account :");
        String employee = scanner.nextLine();
        EmployeeService EmployeService = new EmployeeService();
        Optional<Employee> getoneEmployee = EmployeService.getOneByRegistrationNum(employee);

        System.out.println("Enter Client Code To Create Saving account :");
        String clientCode = scanner.nextLine();
        ClientService personService = new ClientService();
        Optional<Client> getOneClient = personService.getOneByCode(clientCode);
        if (getOneClient.isPresent()) {
            Client client = getOneClient.get();
            Employee employe = getoneEmployee.get();
            System.out.println("Enter accnum :");
            String accnum = scanner.nextLine();
            System.out.println("Enter Balance :");
            double balance = Double.parseDouble(scanner.nextLine());
            LocalDate creationdate = LocalDate.now();
            System.out.println("Interest Rate :");
            double interestrate = Double.parseDouble(scanner.nextLine());


            SavingAccountService SavingAccountservice = new SavingAccountService();
            SavingAccount newCurrentAccount = new SavingAccount(accnum, balance, creationdate, statut.active, interestrate, client, employe);
            Optional<SavingAccount> Data = SavingAccountservice.insertSavingAcc(newCurrentAccount);
            if (Data.isPresent()) {
                SavingAccount Savingaccount = Data.get();

                System.out.println("\nThe New Account :");
                System.out.println("Account Number : " + Savingaccount.getAccNum());
                System.out.println("Client Code : " + Savingaccount.getClient().getCode());
                System.out.println("Interest Rate : " + Savingaccount.getInterestRate());
                System.out.println("Balance : " + Savingaccount.getBalance());
                System.out.println("Statut : " + Savingaccount.getStatut());
                System.out.println("Creation Date : " + Savingaccount.getCreationDate());
                System.out.println("---------------------------------------");
            } else {
                System.out.println("Saving account not found");
            }
        } else {
            System.out.println("Client not found");
        }
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
        if (CurentAccount.isPresent()) {
            CurrentAccount acc = CurentAccount.get();

            System.out.println("\nThe Account :");
            System.out.println("Account Number : " + acc.getAccNum());
            System.out.println("Client First name : " + acc.getClient().getFirstName());
            System.out.println("Client Last name : " + acc.getClient().getLastName());
            System.out.println("max price : " + acc.getMaxPrice() + "DH");
            System.out.println("Balance : " + acc.getBalance() + "DH");
            System.out.println("Statut : " + acc.getStatut());
            System.out.println("Creation Date : " + acc.getCreationDate());

            System.out.println("\u001b[32mClient :\u001b[0m");
            System.out.println("Client Code : " + acc.getClient().getCode());
            System.out.println("First name : " + acc.getClient().getFirstName());
            System.out.println("Last name : " + acc.getClient().getLastName());

            System.out.println("\u001b[32mEmployee :\u001b[0m");
            System.out.println("registration number : " + acc.getEmployye().getRegistrationNumber());
            System.out.println("First name : " + acc.getEmployye().getFirstName());
            System.out.println("Last name : " + acc.getEmployye().getLastName());
            System.out.println("---------------------------------------");
        }
    }

    public static void searchForSavingAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Client Code to search for an Saving Account");
        String accnum = scanner.nextLine();
        SavingAccountService SavingaccountService = new SavingAccountService();
        Optional<SavingAccount> Savingaccount = SavingaccountService.getOneSavingAccount(accnum);
        if (Savingaccount.isPresent()) {
            SavingAccount acc = Savingaccount.get();

            System.out.println("\nThe Account :");
            System.out.println("Account Number : " + acc.getAccNum());
            System.out.println("Client First name : " + acc.getClient().getFirstName());
            System.out.println("Client Last name : " + acc.getClient().getLastName());
            System.out.println("Balance : " + acc.getBalance() + " DH");
            System.out.println("Interest Rate : " + acc.getInterestRate());
            System.out.println("Statut : " + acc.getStatut());
            System.out.println("Creation Date : " + acc.getCreationDate());

            System.out.println("\u001b[32mClient :\u001b[0m");
            System.out.println("Client Code : " + acc.getClient().getCode());
            System.out.println("First name : " + acc.getClient().getFirstName());
            System.out.println("Last name : " + acc.getClient().getLastName());

            System.out.println("\u001b[32mEmployee :\u001b[0m");
            System.out.println("registration number : " + acc.getEmployye().getRegistrationNumber());
            System.out.println("First name : " + acc.getEmployye().getFirstName());
            System.out.println("Last name : " + acc.getEmployye().getLastName());
            System.out.println("Creation Date : " + acc.getCreationDate());
            System.out.println("---------------------------------------");
        }
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

    public static void updtaeCurrentAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account Number To Update Current account :");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter Balance :");
        double balance = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter Statut :\n 1 :active Account \n 2 :inactive Account");
        int statutchoose = Integer.parseInt(scanner.nextLine());
        statut stats = null;
        if (statutchoose == 1) {
            stats = statut.active;
        } else if (statutchoose == 2) {
            stats = statut.inactive;
        } else {
            stats = statut.active;
        }
        System.out.println("Enter maxprice :");
        double maxprice = Double.parseDouble(scanner.nextLine());


        CurentAccountService curentaccountService = new CurentAccountService();
        CurrentAccount newCurrentAccount = new CurrentAccount(accountNumber, balance, null, stats, null, maxprice, null);
        Optional<CurrentAccount> Data = curentaccountService.updateCurrentAccount(newCurrentAccount);
        if (Data.isPresent()) {
            CurrentAccount Currentaccount = Data.get();

            System.out.println("\nAccount updated :");
            System.out.println("Account Number : " + Currentaccount.getAccNum());
            System.out.println("Balance : " + Currentaccount.getBalance() + " DH");
            System.out.println("Statut : " + Currentaccount.getStatut());
            System.out.println("max price : " + Currentaccount.getMaxPrice());
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Current account not found");
        }
    }

    public static void updtaeSavingAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account Number To Update Current account :");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter Balance :");
        double balance = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter Statut :\n 1 :active Account \n 2 : inactive Account");
        int statutchoose = Integer.parseInt(scanner.nextLine());
        statut stats = null;
        if (statutchoose == 1) {
            stats = statut.active;
        } else if (statutchoose == 2) {
            stats = statut.inactive;
        } else {
            stats = statut.active;
        }
        System.out.println("Enter maxprice :");
        double maxprice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter interestrate :");
        double interestrate = Double.parseDouble(scanner.nextLine());


        SavingAccountService savingaccountService = new SavingAccountService();
        SavingAccount newSavingAccount = new SavingAccount(accountNumber, balance, null, stats, interestrate, null, null);
        Optional<SavingAccount> Data = savingaccountService.updateSavingAccount(newSavingAccount);
        if (Data.isPresent()) {
            SavingAccount Currentaccount = Data.get();

            System.out.println("\nAccount changes :");
            System.out.println("Account Number : " + Currentaccount.getAccNum());
            System.out.println("Balance : " + Currentaccount.getBalance());
            System.out.println("Statut : " + Currentaccount.getStatut());
            System.out.println("max price : " + Currentaccount.getInterestRate());
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Current account not found");
        }
    }

    public static void changeStatut() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account name :");
        String accnum = scanner.nextLine();
        System.out.println("Enter Statut :\n 1 : active Account \n 2 : inactive Account");
        int Stats = Integer.parseInt(scanner.nextLine());
        statut changestat = null;
        if (Stats == 1) {
            changestat = statut.active;
        } else if (Stats == 2) {
            changestat = statut.inactive;
        } else {
            System.out.println("statut not found");
        }

        CurentAccountService curentaccountService = new CurentAccountService();
        Boolean Data = curentaccountService.changeStatut(accnum, changestat);
        if (Data) {
            System.out.println("statut chnged successfully");
        } else {
            System.out.println("something went wrong");
        }
    }

    public static void updtaeAccountType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : to update a Current account \n2 : to update a Saving account \n3 : to update an account statut");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            updtaeCurrentAccount();
        } else if (choice == 2) {
            updtaeSavingAccount();
        } else if (choice == 3) {
            changeStatut();
        } else {
            System.out.println("wrong choice !!");
        }
    }

    public static void getAllCurrent() {
        CurentAccountService currentAccAll = new CurentAccountService();
        Map<String, Optional<CurrentAccount>> currentAccounts = currentAccAll.getAllAcc();

        for (Map.Entry<String, Optional<CurrentAccount>> entry : currentAccounts.entrySet()) {
            String accountNumber = entry.getKey();
            Optional<CurrentAccount> currentAccountOptional = entry.getValue();

            if (currentAccountOptional.isPresent()) {
                CurrentAccount currentAccount = currentAccountOptional.get();
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Client Code : " + currentAccount.getClient().getCode());
                System.out.println("max price : " + currentAccount.getMaxPrice());
                System.out.println("Balance : " + currentAccount.getBalance());
                System.out.println("Statut : " + currentAccount.getStatut());
                System.out.println("Creation Date : " + currentAccount.getCreationDate());
                System.out.println("--------------------------------------------");

            } else {
                System.out.println("Account Number: " + accountNumber);
                System.out.println(" Current Accounts not found.");
            }
        }
    }

    public static void getAllSaving() {
        SavingAccountService currentAccAll = new SavingAccountService();
        Map<String, Optional<SavingAccount>> SavingAccountAccounts = currentAccAll.getAllSavingAcc();

        for (Map.Entry<String, Optional<SavingAccount>> entry : SavingAccountAccounts.entrySet()) {
            String accountNumber = entry.getKey();
            Optional<SavingAccount> savingAccountOptional = entry.getValue();

            if (savingAccountOptional.isPresent()) {
                SavingAccount Savingaccount = savingAccountOptional.get();
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Client Code : " + Savingaccount.getClient().getCode());
                System.out.println("Interest Rate : " + Savingaccount.getInterestRate());
                System.out.println("Balance : " + Savingaccount.getBalance());
                System.out.println("Statut : " + Savingaccount.getStatut());
                System.out.println("Creation Date : " + Savingaccount.getCreationDate());
                System.out.println("--------------------------------------------");

            } else {
                System.out.println("Account Number: " + accountNumber);
                System.out.println(" Current Accounts not found.");
            }
        }
    }

    public static void getAllAccountType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : to get all Current accounts \n2 : to get all Saving accounts");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            getAllCurrent();
        } else if (choice == 2) {
            getAllSaving();
        } else {
            System.out.println("wrong choice !!");
        }
    }

    public static void getByStatutCurrent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1 :active account\n 2 :inactive account");
        int choice = Integer.parseInt(scanner.nextLine());
        statut stat;
        if (choice == 1) {
            stat = statut.active;
        } else if (choice == 2) {
            stat = statut.active;
        } else {
            System.out.println("Choice not Found");
            return;
        }
        CurentAccountService currentAccAll = new CurentAccountService();
        Map<String, Optional<CurrentAccount>> currentAccounts = currentAccAll.getByStatut(stat);

        for (Map.Entry<String, Optional<CurrentAccount>> entry : currentAccounts.entrySet()) {
            String accountNumber = entry.getKey();
            Optional<CurrentAccount> currentAccountOptional = entry.getValue();

            if (currentAccountOptional.isPresent()) {
                CurrentAccount currentAccount = currentAccountOptional.get();
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Client Code : " + currentAccount.getClient().getCode());
                System.out.println("max price : " + currentAccount.getMaxPrice());
                System.out.println("Balance : " + currentAccount.getBalance());
                System.out.println("Statut : " + currentAccount.getStatut());
                System.out.println("Creation Date : " + currentAccount.getCreationDate());
                System.out.println("--------------------------------------------");

            } else {
                System.out.println("Account Number: " + accountNumber);
                System.out.println(" Current Accounts not found.");
            }
        }
    }

    public static void getByStatutSaving() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1 :active account\n 2 :inactive account");
        int choice = Integer.parseInt(scanner.nextLine());
        statut stat;
        if (choice == 1) {
            stat = statut.active;
        } else if (choice == 2) {
            stat = statut.active;
        } else {
            System.out.println("Choice not Found");
            return;
        }
        SavingAccountService currentAccAll = new SavingAccountService();
        Map<String, Optional<SavingAccount>> SavingAccountAccounts = currentAccAll.getByStatut(stat);

        for (Map.Entry<String, Optional<SavingAccount>> entry : SavingAccountAccounts.entrySet()) {
            String accountNumber = entry.getKey();
            Optional<SavingAccount> savingAccountOptional = entry.getValue();

            if (savingAccountOptional.isPresent()) {
                SavingAccount Savingaccount = savingAccountOptional.get();
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Client Code : " + Savingaccount.getClient().getCode());
                System.out.println("Interest Rate : " + Savingaccount.getInterestRate());
                System.out.println("Balance : " + Savingaccount.getBalance());
                System.out.println("Statut : " + Savingaccount.getStatut());
                System.out.println("Creation Date : " + Savingaccount.getCreationDate());
                System.out.println("--------------------------------------------");

            } else {
                System.out.println("Account Number: " + accountNumber);
                System.out.println(" Current Accounts not found.");
            }
        }
    }

    public static void getByStatutAccountType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : to get Current accounts \n2 : to get Saving accounts");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            getByStatutCurrent();
        } else if (choice == 2) {
            getByStatutSaving();
        } else {
            System.out.println("wrong choice !!");
        }
    }
}
