package DAO;

import DATABASE.DB;
import DTO.*;
import INTERFACES.ClientDAO;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class ClientIMPL implements ClientDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<Client> getOne(String num) throws SQLException {
        Optional<Client> client = Optional.empty();

        String sql = "SELECT * FROM person AS pr INNER JOIN client as cl ON cl.id = pr.id WHERE cl.code like ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + num + "%");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            LocalDate dateOfBirth = rs.getDate("dateofbirth").toLocalDate();
            String phoneNumber = rs.getString("phonenumber");
            String code = rs.getString("code");
            String adress = rs.getString("adress");

            client = Optional.of(new Client(firstname, lastname, dateOfBirth, phoneNumber, code, adress));
        }
        rs.close();
        ps.close();
        return client;
    }

    @Override
    public Optional<Client> insert(Client client) throws SQLException {
        Optional<Client> returnInsert = Optional.ofNullable(client);
        try (PreparedStatement ps = connection.prepareStatement("BEGIN;" + "INSERT INTO person (firstName, lastName, dateofbirth, phonenumber) VALUES (?, ?, ?, ?);" + "INSERT INTO client (id, code, adress) VALUES ((SELECT id FROM person WHERE firstName = ? AND lastName = ? AND dateofbirth = ?), ?, ? );" + "COMMIT;")) {

            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setDate(3, Date.valueOf(client.getDateOfBirth()));
            ps.setString(4, client.getPhoneNumber());
            ps.setString(5, client.getFirstName());
            ps.setString(6, client.getLastName());
            ps.setDate(7, Date.valueOf(client.getDateOfBirth()));
            ps.setString(8, client.getCode());
            ps.setString(9, client.getAdress());

            int rs = ps.executeUpdate();
            return returnInsert;
        }
    }

    @Override
    public Optional<Client> update(Client person) throws SQLException {
        Optional<Client> returnInsert = Optional.ofNullable(person);
        try (PreparedStatement ps = connection.prepareStatement("BEGIN;" + "UPDATE person SET firstName = ?, lastName = ?, dateofbirth = ?, phonenumber = ? WHERE id = (SELECT id FROM client WHERE code = ?);" + "UPDATE client SET adress = ? WHERE code = ?;" + "COMMIT;")) {

            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setDate(3, Date.valueOf(person.getDateOfBirth()));
            ps.setString(4, person.getPhoneNumber());
            ps.setString(5, person.getCode());
            ps.setString(6, person.getAdress());
            ps.setString(7, person.getCode());

            int rs = ps.executeUpdate();
            return returnInsert;
        }
    }

    @Override
    public boolean delete(String code) throws SQLException {
        PreparedStatement ps = null;

        String sql = " BEGIN; DELETE FROM personWHERE id = (SELECT id FROM client WHERE code = ?); DELETE FROM clientWHERE code = ?; COMMIT ;";

        ps = connection.prepareStatement(sql);
        ps.setString(1, code);
        ps.setString(2, code);
        int rowsDeleted = ps.executeUpdate();
        boolean bool = rowsDeleted > 0;
        return bool;
    }

    @Override
    public Map<String, Optional<Client>> getAll() throws SQLException {
        Map<String, Optional<Client>> Clients = new HashMap<>();
        String sql = "SELECT * FROM client as em INNER JOIN person as pr ON pr.id = em.id";
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            LocalDate dateOfBirth = rs.getDate("dateofbirth").toLocalDate();
            String phoneNumber = rs.getString("phonenumber");
            String code = rs.getString("code");
            String adress = rs.getString("adress");

            Client employee = new Client(firstname, lastname, dateOfBirth, phoneNumber, code, adress);
            Clients.put(code, Optional.of(employee));
        }
        rs.close();
        ps.close();
        return Clients;
    }

    @Override
    public List<Optional<Client>> searchByAllAttributs(String attribut) throws SQLException {
        List<Optional<Client>> Clients = new ArrayList<>();
        String sql = "SELECT * FROM client as em INNER JOIN person as pr ON pr.id = em.id WHERE firstName LIKE ? OR lastName LIKE ? OR phonenumber LIKE ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + attribut + "%");
        ps.setString(2, "%" + attribut + "%");
        ps.setString(3, "%" + attribut + "%");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            LocalDate dateOfBirth = rs.getDate("dateofbirth").toLocalDate();
            String phoneNumber = rs.getString("phonenumber");
            String code = rs.getString("code");
            String adress = rs.getString("adress");

            Client client = new Client(firstname, lastname, dateOfBirth, phoneNumber, code, adress);
            Clients.add(Optional.of(client));
        }
        rs.close();
        ps.close();
        return Clients;
    }
}
