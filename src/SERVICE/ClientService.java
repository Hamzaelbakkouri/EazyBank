package SERVICE;


import DAO.ClientIMPL;
import DAO.EmployeeIMPL;
import DTO.Client;
import DTO.Employee;
import INTERFACES.ClientDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientService {
    public Optional<Client> getOneByCode(String param) {
        Optional<Client> client = Optional.empty();
        try {
            ClientDAO clientdao = new ClientIMPL();
            Optional<Client> employee = clientdao.getOne(param);
            client = Optional.of(employee.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public List<Optional<Client>> searchByAttributs(String param) {
        List<Optional<Client>> clients = new ArrayList<>();
        try {
            ClientDAO clientdao = new ClientIMPL();
            List<Optional<Client>> employee = clientdao.searchByAllAttributs(param);
            clients = employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<Optional<Client>> getAll() {
        List<Optional<Client>> client = new ArrayList<>();
        try {
            ClientDAO clientdao = new ClientIMPL();
            List<Optional<Client>> employee = clientdao.getAll();
            client = employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Optional<Client> insertClient(Client employes) {
        Optional<Client> client = Optional.empty();
        try {
            ClientDAO clientdao = new ClientIMPL();
            client = clientdao.insert(employes);
            client = Optional.of(client.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Optional<Client> updateClient(Client employes) {
//        check if Registration Number is exist
        Optional<Client> client = Optional.empty();
        try {
            ClientDAO clientdao = new ClientIMPL();
            client = clientdao.update(employes);
            client = Optional.of(client.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Boolean deleteClient(String Rnum) {
        Boolean client = null;
        try {
            ClientDAO clientdao = new ClientIMPL();
            client = clientdao.delete(Rnum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }
}
