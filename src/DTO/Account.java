package DTO;

import INTERFACES.statut;

import java.time.LocalDate;
import java.util.List;

public class Account {
    private String AccNum;
    private double Balance;
    private LocalDate creationDate;
    private statut Statut;
    private List<Operation> operation;

    public Account(String accnum, double balance, LocalDate creationdate, statut status) {
        this.AccNum = accnum;
        this.Balance = balance;
        this.creationDate = creationdate;
        this.Statut = status;
    }

    public String getAccNum() {
        return AccNum;
    }

    public void setAccNum(String accNum) {
        AccNum = accNum;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public statut getStatut() {
        return Statut;
    }

    public void setStatut(statut statut) {
        Statut = statut;
    }
}
