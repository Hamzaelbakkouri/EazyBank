package DAO;

import DATABASE.DB;
import DTO.Employee;
import DTO.Employee;
import INTERFACES.EmployeeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeIMPL implements EmployeeDAO {
    @Override
    public Optional<Employee> getOne(String Rnum) throws SQLException {
        Connection connection = DB.getConnection();
        Optional<Employee> employee = Optional.empty();

        String sql = "SELECT * FROM person AS pr INNER JOIN employe as em ON em.id = pr.id WHERE em.registrationnumber = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, Rnum);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            LocalDate dateOfBirth = rs.getDate("dateofbirth").toLocalDate();
            String phoneNumber = rs.getString("phonenumber");
            String registrationNumber = rs.getString("registrationnumber");
            LocalDate recruitmentDate = rs.getDate("recrutmentdate").toLocalDate();
            String email = rs.getString("email");

            employee = Optional.of(new Employee(firstname, lastname, dateOfBirth, phoneNumber, registrationNumber, recruitmentDate, email));
        }
        rs.close();
        ps.close();
        return employee;
    }

    @Override
    public Employee insert(Employee person) throws SQLException {
        return null;
    }

    @Override
    public Employee update(Employee person) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String t) throws SQLException {
        return false;
    }

    @Override
    public List<Optional<Employee>> getAll() throws SQLException {
        Connection connection = DB.getConnection();
        List<Optional<Employee>> Employes = new ArrayList<>();
        String sql = "SELECT * FROM employe as em INNER JOIN person as pr ON pr.id = em.id";
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            LocalDate dateOfBirth = rs.getDate("dateofbirth").toLocalDate();
            String phoneNumber = rs.getString("phonenumber");
            String registrationNumber = rs.getString("registrationnumber");
            LocalDate recruitmentDate = rs.getDate("recrutmentdate").toLocalDate();
            String email = rs.getString("email");

            Employee employee = new Employee(firstname, lastname, dateOfBirth, phoneNumber, registrationNumber, recruitmentDate, email);
            Employes.add(Optional.of(employee));
        }
        rs.close();
        ps.close();
        return Employes;
    }
}
