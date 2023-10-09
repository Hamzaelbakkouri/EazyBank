package DTO;

import java.time.LocalDate;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String phoneNumber;

    public Person(){

    }

    public Person(String firstname, String lastname, LocalDate dateOfbirth, String phonenumber) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.dateOfBirth = dateOfbirth;
        this.phoneNumber = phonenumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
