package DTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public final class Employee extends Person {

    private int id;
    private String registrationNumber;
    private LocalDate recruitmentDate;
    private String email;
    private List<Operation> operation;
    @Setter
    @Getter
    private List<Affectation> affectations;
    @Setter
    @Getter
    private List<EmployeeAffectation> employeeAffectations;


    public Employee(String firstname, String lastname, LocalDate dateOfbirth, String phonenumber, String registrationnumber, LocalDate recruitmentdate, String Email) {
        super(firstname, lastname, dateOfbirth, phonenumber);
        this.email = Email;
        this.recruitmentDate = recruitmentdate;
        this.registrationNumber = registrationnumber;
    }
    public Employee(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Operation> getOperation() {
        return operation;
    }

    public void setOperation(List<Operation> operation) {
        this.operation = operation;
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

    public String toJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
