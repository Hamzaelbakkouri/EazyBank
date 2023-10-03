package INTERFACES;

import DTO.Account;
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

    Map<String, Optional<SavingAccount>> showByCreationDate(LocalDate date) throws SQLException;

    Map<String, Optional<SavingAccount>> showByStatus(statut stats) throws SQLException;

    Boolean changeStatut(String accnum, statut stats) throws SQLException;

    Map<String, Optional<SavingAccount>> SearchByClient(String clintCode) throws SQLException;
    String getOneAccountByOpNum(int operationNumber) throws SQLException;
}
