package SERVICE;

import DAO.EmployeeIMPL;
import DTO.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeService {
    public Optional<Employee> getOneByRegistrationNum(String param) {
        Optional<Employee> Employe = Optional.empty();
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            Optional<Employee> employee = employedao.getOne(param);
            Employe = Optional.of(employee.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Employe;
    }

    public List<Optional<Employee>> getAll() {
        List<Optional<Employee>> Employe = new ArrayList<>();
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            List<Optional<Employee>> employee = employedao.getAll();
            Employe = employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Employe;
    }

    public Optional<Employee> insertEmployee(Employee employes) {
        Optional<Employee> Employe = Optional.empty();
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            Employe = employedao.insert(employes);
            Employe = Optional.of(Employe.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Employe;
    }

    public Optional<Employee> updateEmployee(Employee employes) {
//        check if Registration Number is exist
        Optional<Employee> Employe = Optional.empty();
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            Employe = employedao.update(employes);
            Employe = Optional.of(Employe.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Employe;
    }

    public Boolean deleteEmployee(String Rnum) {
        Boolean Employe = null;
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            Employe = employedao.delete(Rnum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Employe;
    }
}