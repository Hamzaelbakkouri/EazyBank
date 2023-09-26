package DAO;

import DATABASE.DB;
import DTO.Account;
import DTO.CurrentAccount;
import DTO.Employee;
import INTERFACES.CurrentAccountDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CurrentAccountIPLM implements CurrentAccountDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<CurrentAccount> getOne(String AccNum) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<CurrentAccount> insert(CurrentAccount currentCurrentAccount) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<CurrentAccount> update(CurrentAccount currentCurrentAccount) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(String AccNum) throws SQLException {
        return false;
    }

    @Override
    public List<CurrentAccount> showByCreationDate() throws SQLException {
        return null;
    }

    @Override
    public List<CurrentAccount> showByStatus() throws SQLException {
        return null;
    }

    @Override
    public List<Optional<CurrentAccount>> getAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean changeStatut() throws SQLException {
        return null;
    }

    @Override
    public CurrentAccount SearchByClient() throws SQLException {
        return null;
    }
}
