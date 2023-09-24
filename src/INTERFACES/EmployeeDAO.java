package INTERFACES;

import DTO.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface EmployeeDAO extends DAO<Employee> {
    @Override
    Optional<Employee> getOne(String num) throws SQLException;

    @Override
    Employee insert(Employee employe) throws SQLException;

    @Override
    Employee update(Employee employe) throws SQLException;

    @Override
    boolean delete(String t) throws SQLException;

    @Override
    List<Optional<Employee>> getAll() throws SQLException;
}
