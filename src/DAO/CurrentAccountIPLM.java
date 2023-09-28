package DAO;

import DATABASE.DB;
import DTO.Client;
import DTO.CurrentAccount;
import DTO.Employee;
import INTERFACES.CurrentAccountDAO;
import INTERFACES.statut;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CurrentAccountIPLM implements CurrentAccountDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<CurrentAccount> getOne(String clientCode) throws SQLException {
        Optional<CurrentAccount> currentAccount = Optional.empty();
        statut statues;
        String sql = "SELECT * FROM account AS a INNER JOIN currentAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id WHERE cl.code = ?  ";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, clientCode);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            double balance = rs.getDouble("balance");
            String accnum = rs.getString("accountNumber");
            LocalDate creationdate = rs.getDate("creationdate").toLocalDate();
            Client client = new Client(
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getDate("dateofbirth").toLocalDate(),
                    rs.getString("phonenumber"),
                    rs.getString("code"),
                    rs.getString("adress"));
            String status = rs.getString("status");
            statues = statut.valueOf(status);
            double maxprice = rs.getDouble("maxprice");

            String sql2 = "SELECT * FROM account AS a INNER JOIN employe as emp ON a.employee_code = emp.registrationnumber Inner Join person ON emp.id = person.id WHERE a.accountNumber = ?  ";
            ps = connection.prepareStatement(sql2);
            ps.setString(1, rs.getString("accountNumber"));
            rs = ps.executeQuery();
            if (rs.next()) {
                Employee employye = new Employee(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getDate("dateofbirth").toLocalDate(),
                        rs.getString("phonenumber"),
                        rs.getString("registrationnumber"),
                        rs.getDate("recrutmentdate").toLocalDate(),
                        rs.getString("email")
                );
                currentAccount = Optional.of(new CurrentAccount(accnum, balance, creationdate, statues, client, maxprice, employye));
            }
        }
        rs.close();
        ps.close();
        return currentAccount;
    }

    @Override
    public Optional<CurrentAccount> insert(CurrentAccount currentCurrentAccount) throws SQLException {
        Optional<CurrentAccount> returnInsert = Optional.ofNullable(currentCurrentAccount);
        PreparedStatement ps = connection.prepareStatement(
                "BEGIN;" +
                        "INSERT INTO account (accountNumber, balance, creationdate, client_code,employee_code,status) VALUES (?, ?, ?, ?, ?, ?::status);" +
                        "INSERT INTO currentAccount (id, maxprice) VALUES (?, ?);" +
                        "COMMIT;");

        ps.setString(1, currentCurrentAccount.getAccNum());
        ps.setDouble(2, currentCurrentAccount.getBalance());
        ps.setDate(3, Date.valueOf((LocalDate) currentCurrentAccount.getCreationDate()));
        ps.setString(4, currentCurrentAccount.getClient().getCode());
        ps.setString(5, currentCurrentAccount.getEmployye().getRegistrationNumber());
        ps.setString(6, currentCurrentAccount.getStatut().toString());
        ps.setString(7, currentCurrentAccount.getAccNum());
        ps.setDouble(8, currentCurrentAccount.getMaxPrice());

        int rs = ps.executeUpdate();
        return returnInsert;
    }

    @Override
    public Optional<CurrentAccount> update(CurrentAccount currentCurrentAccount) throws SQLException {
        Optional<CurrentAccount> returnInsert = Optional.ofNullable(currentCurrentAccount);
        PreparedStatement ps = connection.prepareStatement(
                "BEGIN;"
                        + "UPDATE account SET accountNumber = ?, balance = ?, creationdate = ?, client_code = ?,status = ? WHERE accountNumber = ? "
                        + "UPDATE currentaccount id, maxprice " +
                        "COMMIT;");

        ps.setString(1, currentCurrentAccount.getAccNum());
        ps.setDouble(2, currentCurrentAccount.getBalance());
        ps.setDate(3, Date.valueOf((LocalDate) currentCurrentAccount.getCreationDate()));
        ps.setString(4, currentCurrentAccount.getClient().getCode());
        ps.setString(5, currentCurrentAccount.getStatut().toString());
        ps.setString(6, currentCurrentAccount.getAccNum());
        ps.setDouble(7, currentCurrentAccount.getMaxPrice());

        int rs = ps.executeUpdate();
        return returnInsert;
    }

    @Override
    public boolean delete(String AccNum) throws SQLException {
        return false;
    }

    @Override
    public List<CurrentAccount> showByCreationDate() throws SQLException {
        return null;
    }

    @Override
    public List<CurrentAccount> showByStatus() throws SQLException {
        return null;
    }

    @Override
    public List<Optional<CurrentAccount>> getAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean changeStatut() throws SQLException {
        return null;
    }

    @Override
    public CurrentAccount SearchByClient() throws SQLException {
        return null;
    }
}
