package INTERFACES;

import DTO.CurrentAccount;
import DTO.SavingAccount;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
    Map<String, Optional<SavingAccount>> getAll() throws SQLException;

    List<SavingAccount> showByCreationDate(LocalDate date) throws SQLException;

    List<SavingAccount> showByStatus() throws SQLException;

    Boolean changeStatut(String accnum, statut stats) throws SQLException;

    List<Optional<SavingAccount>> SearchByClient(String clintCode) throws SQLException;
}
