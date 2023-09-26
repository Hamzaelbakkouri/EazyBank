package INTERFACES;

import DTO.CurrentAccount;
import DTO.SavingAccount;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface SavingAccountDAO extends DAO<SavingAccount> {
    @Override
    Optional<SavingAccount> getOne(String AccNum) throws SQLException;

    @Override
    Optional<SavingAccount> insert(SavingAccount currentSavingAccount) throws SQLException;

    @Override
    Optional<SavingAccount> update(SavingAccount currentSavingAccount) throws SQLException;

    @Override
    boolean delete(String AccNum) throws SQLException;

    @Override
    List<Optional<SavingAccount>> getAll() throws SQLException;

    List<SavingAccount> showByCreationDate() throws SQLException;

    List<SavingAccount> showByStatus() throws SQLException;


    Boolean changeStatut() throws SQLException;

    SavingAccount SearchByClient() throws SQLException;
}
