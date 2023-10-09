package DAO;

import DATABASE.DB;
import DTO.*;
import INTERFACES.OperationDAO;
import INTERFACES.operationType;
import INTERFACES.statut;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class OperationIMPL implements OperationDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<SimpleOperation> insert(SimpleOperation operation) throws SQLException {
        Optional<SimpleOperation> returnInsert = Optional.ofNullable(operation);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO operation (date, type, price,accountNumber,registrationNumber) VALUES (?, ?::operationType, ?, ?, ?)");

        ps.setDate(1, Date.valueOf((LocalDate) operation.getDate()));
        ps.setString(2, operation.getType().toString());
        ps.setDouble(3, operation.getPrice());
        ps.setString(4, operation.getAccount().getAccNum());
        ps.setString(5, operation.getEmployee().getRegistrationNumber());

        int rs = ps.executeUpdate();
        return Optional.of(operation);
    }

    @Override
    public Optional<SimpleOperation> getOne(int operationNumber) throws SQLException {
        Optional<SimpleOperation> operation = Optional.empty();
        operationType types;
        String sql = "SELECT * FROM operation AS op INNER JOIN employe as em ON em.registrationNumber = op.registrationNumber Inner Join person as p ON em.id = p.id INNER JOIN account as a ON a.accountNumber = op.accountNumber  WHERE op.operationNumber = ?  ";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, operationNumber);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            LocalDate Date = rs.getDate("creationdate").toLocalDate();
            String Type = rs.getString("Type");
            types = operationType.valueOf(Type);
            double price = rs.getDouble("price");

            Employee employye = new Employee(
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getDate("dateofbirth").toLocalDate(),
                    rs.getString("phonenumber"),
                    rs.getString("registrationnumber"),
                    rs.getDate("recrutmentdate").toLocalDate(),
                    rs.getString("email")
            );

//            acc Employee
            String sql2 = "SELECT * FROM account AS a INNER JOIN employe as emp ON a.employee_code = emp.registrationnumber Inner Join person ON emp.id = person.id WHERE a.accountNumber = ?  ";
            ps = connection.prepareStatement(sql2);
            ps.setString(1, rs.getString("accountNumber"));
            ResultSet rs2 = ps.executeQuery();
            Employee employees = null;
            if (rs2.next()) {
                employees = new Employee(
                        rs2.getString("firstname"),
                        rs2.getString("lastname"),
                        rs2.getDate("dateofbirth").toLocalDate(),
                        rs2.getString("phonenumber"),
                        rs2.getString("registrationnumber"),
                        rs2.getDate("recrutmentdate").toLocalDate(),
                        rs2.getString("email")
                );
            }

//            acc client
            String sql3 = "SELECT * FROM account AS a INNER JOIN client as cl ON a.client_code = cl.code Inner Join person ON cl.id = person.id WHERE a.accountNumber = ?  ";
            ps = connection.prepareStatement(sql3);
            ps.setString(1, rs.getString("accountNumber"));
            ResultSet rs3 = ps.executeQuery();
            Client Clients = null;
            if (rs3.next()) {
                Clients = new Client(
                        rs3.getString("firstname"),
                        rs3.getString("lastname"),
                        rs3.getDate("dateofbirth").toLocalDate(),
                        rs3.getString("phonenumber"),
                        rs3.getString("code"),
                        rs3.getString("adress"));
            }
            rs2.close();
            rs3.close();

            String stat = rs.getString("status");
            statut statues = statut.valueOf(stat);
//            account
            Account account = new Account(
                    rs.getString("accountNumber"),
                    rs.getDouble("balance"),
                    rs.getDate("creationdate").toLocalDate(),
                    statues,
                    Clients,
                    employees
            );
            operation = Optional.of(new SimpleOperation(Date, price, employye, types, account));
        }
        rs.close();
        ps.close();
        return operation;
    }

    @Override
    public boolean delete(int num) throws SQLException {
        String sql = "DELETE FROM operation WHERE operation.operationNumber = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, num);
        int rowsDeleted = ps.executeUpdate();
        return rowsDeleted > 0;
    }

}