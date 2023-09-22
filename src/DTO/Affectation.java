package DTO;

import java.time.LocalDate;

public class Affectation {
    private Employee employee;
    private Mission mission;
    private LocalDate createDate;

    public Affectation(Employee Employee, Mission Mission, LocalDate Createdate) {
        this.createDate = Createdate;
        this.mission = Mission;
        this.employee = Employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
