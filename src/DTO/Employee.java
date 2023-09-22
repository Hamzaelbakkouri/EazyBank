package DTO;

import java.time.LocalDate;

public class Employee extends Person {

    private String registrationNumber;
    private LocalDate recruitmentDate;
    private String email;


    public Employee(String firstname, String lastname, LocalDate dateOfbirth, String phonenumber, String registrationnumber, LocalDate recruitmentdate, String Email) {
        super(firstname, lastname, dateOfbirth, phonenumber);
        this.email = Email;
        this.recruitmentDate = recruitmentdate;
        this.registrationNumber = registrationnumber;
    }

    public void setRecruitmentDate(LocalDate recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public LocalDate getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
