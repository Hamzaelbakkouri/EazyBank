package INTERFACES;

import DTO.Client;
import DTO.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClientDAO extends DAO<Client> {
    @Override
    Optional<Client> getOne(String num) throws SQLException;

    @Override
    Optional<Client> insert(Client employe) throws SQLException;

    @Override
    Optional<Client> update(Client employe) throws SQLException;

    @Override
    boolean delete(String t) throws SQLException;

    @Override
    Map<String, Optional<Client>> getAll() throws SQLException;

    List<Optional<Client>> searchByAllAttributs(String attribut) throws SQLException;
}
