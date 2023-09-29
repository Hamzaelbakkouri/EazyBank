package DTO;

import INTERFACES.operationType;

import java.time.LocalDate;

public class Operation {
    private int operationNumber;
    private LocalDate date;
    private operationType type;
    private double price;
    private Employee employee;
    private Account account;

    public Operation(LocalDate Date, operationType Type, double Price, Employee employe, Account account) {
        this.account = account;
        this.date = Date;
        this.employee = employe;
        this.price = Price;
        this.type = Type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public operationType getType() {
        return type;
    }

    public void setType(operationType Type) {
        type = Type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
