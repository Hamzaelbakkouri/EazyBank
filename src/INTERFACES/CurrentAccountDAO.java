package INTERFACES;

import DTO.CurrentAccount;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CurrentAccountDAO extends DAO<CurrentAccount> {
    @Override
    Optional<CurrentAccount> getOne(String AccNum) throws SQLException;

    @Override
    Optional<CurrentAccount> insert(CurrentAccount currentCurrentAccount) throws SQLException;

    @Override
    Optional<CurrentAccount> update(CurrentAccount currentCurrentAccount) throws SQLException;

    @Override
    boolean delete(String AccNum) throws SQLException;

    @Override
    List<Optional<CurrentAccount>> getAll() throws SQLException;

    List<CurrentAccount> showByCreationDate() throws SQLException;

    List<CurrentAccount> showByStatus() throws SQLException;


    Boolean changeStatut() throws SQLException;

    CurrentAccount SearchByClient() throws SQLException;

}
