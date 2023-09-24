package DTO;

import INTERFACES.statut;

import java.time.LocalDate;

public class CurrentAccount extends Account {
    private double maxPrice;
    public CurrentAccount(String accnum, double balance, LocalDate creationdate, statut status, double maxprice) {
        super(accnum, balance, creationdate, status);
        this.maxPrice = maxprice;
    }
    public void setMaxPrice(double maxPrice)    {
        this.maxPrice = maxPrice;
    }
    public double getMaxPrice() {
        return maxPrice;
    }

}
