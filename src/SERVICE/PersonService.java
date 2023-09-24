package SERVICE;

import DAO.EmployeeIMPL;
import DTO.Employee;
import DTO.Employee;

import java.sql.SQLException;
import java.util.Optional;

public class PersonService {
    public Optional<Employee> getOneEmployeBy(String param) {
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
}