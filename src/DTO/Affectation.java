package DTO;

import java.time.LocalDate;

public class Affectation {
    private Employee employee;
    private String mission;
    private LocalDate Endate;
    private LocalDate startDate;

    public Affectation(Employee Employee, String Mission, LocalDate Enddate, LocalDate startdate) {
        this.Endate = Enddate;
        this.mission = Mission;
        this.employee = Employee;
        this.startDate = startdate;
    }

    public LocalDate getEndate() {
        return Endate;
    }

    public void setEndate(LocalDate endate) {
        Endate = endate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
