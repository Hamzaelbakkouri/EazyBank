package DAO;

import DATABASE.DB;
import DTO.Employee;
import DTO.Employee;
import INTERFACES.EmployeeDAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeIMPL implements EmployeeDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<Employee> getOne(String Rnum) throws SQLException {
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
    public Optional<Employee> insert(Employee person) throws SQLException {
        Optional<Employee> returnInsert = Optional.ofNullable(person);
        try (
                PreparedStatement ps = connection.prepareStatement(
                        "BEGIN;" +
                                "INSERT INTO person (firstName, lastName, dateofbirth, phonenumber) VALUES (?, ?, ?, ?);" +
                                "INSERT INTO employe (id, registrationNumber, recrutmentDate, email) VALUES ((SELECT id FROM person WHERE firstName = ? AND lastName = ? AND dateofbirth = ?), ?, ?, ? );" +
                                "COMMIT;")) {

            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setDate(3, Date.valueOf(person.getDateOfBirth()));
            ps.setString(4, person.getPhoneNumber());
            ps.setString(5, person.getFirstName());
            ps.setString(6, person.getLastName());
            ps.setDate(7, Date.valueOf(person.getDateOfBirth()));
            ps.setString(8, person.getRegistrationNumber());
            ps.setDate(9, Date.valueOf(person.getRecruitmentDate()));
            ps.setString(10, person.getEmail());

            int rs = ps.executeUpdate();
            return returnInsert;
        }
    }

    @Override
    public Optional<Employee> update(Employee person) throws SQLException {
        Optional<Employee> returnInsert = Optional.ofNullable(person);
        try (
                PreparedStatement ps = connection.prepareStatement(
                        "BEGIN;" +
                                "UPDATE person SET firstName = ?, lastName = ?, dateofbirth = ?, phonenumber = ? WHERE id = (SELECT id FROM employe WHERE registrationNumber = ?);" +
                                "UPDATE employe SET recrutmentDate = ?, email = ? WHERE registrationNumber = ?;" +
                                "COMMIT;")) {

            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setDate(3, Date.valueOf(person.getDateOfBirth()));
            ps.setString(4, person.getPhoneNumber());
            ps.setString(5, person.getRegistrationNumber());
            ps.setDate(6, Date.valueOf(person.getRecruitmentDate()));
            ps.setString(7, person.getEmail());
            ps.setString(8, person.getRegistrationNumber());

            int rs = ps.executeUpdate();
            return returnInsert;
        }
    }

    @Override
    public boolean delete(String Rnum) throws SQLException {
        PreparedStatement ps = null;

        String sql = """
                BEGIN;
                DELETE FROM person
                WHERE id = (SELECT id FROM employe WHERE registrationNumber = ?);
                                
                DELETE FROM employe
                WHERE registrationNumber = ?;
                COMMIT ;

                """;

        ps = connection.prepareStatement(sql);
        ps.setString(1, Rnum);
        ps.setString(2, Rnum);
        int rowsDeleted = ps.executeUpdate();
        boolean bool = rowsDeleted > 0;
        return bool;
    }

    @Override
    public List<Optional<Employee>> getAll() throws SQLException {
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
