package DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Operation {
    protected int operationNumber;
    protected LocalDate date;
    protected double price;
    private Employee employee;

    protected Operation(LocalDate Date, double Price, Employee employe) {
        this.date = Date;
        this.price = Price;
        setEmployee(employe);
    }

    protected Operation() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(int operationNumber) {
        this.operationNumber = operationNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate Date) {
        date = Date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
