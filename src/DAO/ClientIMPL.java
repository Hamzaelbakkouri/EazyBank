package DAO;

import DTO.Client;
import INTERFACES.ClientDAO;
import INTERFACES.EmployeeDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClientIMPL implements ClientDAO {

    @Override
    public Optional<Client> getOne(String num) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Client> insert(Client person) throws SQLException {
        return null;
    }

    @Override
    public Optional<Client> update(Client person) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String person) throws SQLException {
        return false;
    }

    @Override
    public List<Optional<Client>> getAll() throws SQLException {
        return null;
    }
}
