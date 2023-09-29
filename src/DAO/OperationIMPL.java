package DAO;

import DATABASE.DB;
import DTO.CurrentAccount;
import DTO.Operation;
import INTERFACES.OperationDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class OperationIMPL implements OperationDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<Operation> insert(Operation operation) throws SQLException {
        Optional<Operation> returnInsert = Optional.ofNullable(operation);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO operation (date, type, price,accountNumber,registrationNumber) VALUES (?, ?::operationType, ?, ?, ?)");

        ps.setDate(1, Date.valueOf((LocalDate) operation.getDate()));
        ps.setString(2, operation.getType().toString());
        ps.setDouble(3, operation.getPrice());
        ps.setString(4, operation.getAccount().getAccNum());
        ps.setString(5, operation.getEmployee().getRegistrationNumber());

        int rs = ps.executeUpdate();
        return returnInsert;
    }

    @Override
    public Optional<Operation> getOne(int operationNumber) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String t) throws SQLException {
        return false;
    }
}