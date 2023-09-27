package DAO;

import DTO.Account;
import DTO.SavingAccount;
import INTERFACES.SavingAccountDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SavingAccountIMPL implements SavingAccountDAO {

    @Override
    public Optional<SavingAccount> getOne(String AccNum) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<SavingAccount> insert(SavingAccount currentSavingAccount) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<SavingAccount> update(SavingAccount currentSavingAccount) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(String AccNum) throws SQLException {
        return false;
    }

    @Override
    public List<Optional<SavingAccount>> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<SavingAccount> showByCreationDate() throws SQLException {
        return null;
    }

    @Override
    public List<SavingAccount> showByStatus() throws SQLException {
        return null;
    }

    @Override
    public Boolean changeStatut() throws SQLException {
        return null;
    }

    @Override
    public SavingAccount SearchByClient() throws SQLException {
        return null;
    }
}
