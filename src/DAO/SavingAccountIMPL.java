package DAO;

import DTO.Account;
import INTERFACES.AccountDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SavingAccountIMPL implements AccountDAO {
    @Override
    public Optional<Account> getOne(String AccNum) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Account insert(Account currentAccount) throws SQLException {
        return null;
    }

    @Override
    public Account update(Account currentAccount) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String AccNum) throws SQLException {
        return false;
    }

    @Override
    public List<Account> showByCreationDate() throws SQLException {
        return null;
    }

    @Override
    public List<Account> showByStatus() throws SQLException {
        return null;
    }

    @Override
    public List<Optional<Account>> getAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean changeStatut() throws SQLException {
        return null;
    }

    @Override
    public Account SearchByClient() throws SQLException {
        return null;
    }
}
