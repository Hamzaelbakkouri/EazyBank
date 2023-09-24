package INTERFACES;

import DTO.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ClientDAO extends DAO<Client> {
    @Override
    Optional<Client> getOne(String num) throws SQLException;

    @Override
    Client insert(Client employe) throws SQLException;

    @Override
    Client update(Client employe) throws SQLException;

    @Override
    boolean delete(String t) throws SQLException;

    @Override
    List<Optional<Client>> getAll() throws SQLException;
}
