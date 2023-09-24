package INTERFACES;

import DTO.Account;
import DTO.CurrentAccount;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AccountDAO extends DAO<Account> {
    @Override
    Optional<Account> getOne(String AccNum) throws SQLException;

    @Override
    Account insert(Account currentAccount) throws SQLException;

    @Override
    Account update(Account currentAccount) throws SQLException;

    @Override
    boolean delete(String AccNum) throws SQLException;

    @Override
    List<Optional<Account>> getAll() throws SQLException;

    List<Account> showByCreationDate() throws SQLException;

    List<Account> showByStatus() throws SQLException;


    Boolean changeStatut() throws SQLException;

    Account SearchByClient() throws SQLException;

}
