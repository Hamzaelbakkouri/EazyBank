import DTO.Employee;
import SERVICE.PersonService;

import java.util.Optional;
import java.util.Scanner;

public class menu {
    public static void getOneEmploye() {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        PersonService personService = new PersonService();
        Optional<Employee> getOneEmploye = personService.getOneEmployeBy(num);
        Employee Employee = getOneEmploye.get();

        System.out.println("\nregistration Number : " + Employee.getRegistrationNumber());
        System.out.println("\nRecrutment Date : " + Employee.getRecruitmentDate());
        System.out.println("\nfirst name : " + Employee.getFirstName());
        System.out.println("\nlast name : " + Employee.getLastName());
        System.out.println("\nbirthday : " + Employee.getDateOfBirth());
        System.out.println("\nemail : " + Employee.getEmail());
        System.out.println("\nphone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }
}
