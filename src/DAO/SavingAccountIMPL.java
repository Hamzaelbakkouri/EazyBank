package DAO;

import DATABASE.DB;
import DTO.*;
import INTERFACES.SavingAccountDAO;
import INTERFACES.statut;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class SavingAccountIMPL implements SavingAccountDAO {

    Connection connection = DB.getConnection();

    @Override
    public Optional<SavingAccount> getOne(String clientCode) throws SQLException {
        Optional<SavingAccount> Savingaccount = Optional.empty();
        statut statues;
        String sql = "SELECT * FROM account AS a INNER JOIN savingaccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id WHERE cl.code like ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + clientCode + "%");
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
            double interestrate = rs.getDouble("interestrate");

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
                Savingaccount = Optional.of(new SavingAccount(accnum, balance, creationdate, statues, interestrate, client, employye));
            }
        }
        rs.close();
        ps.close();
        return Savingaccount;
    }

    @Override
    public Optional<SavingAccount> insert(SavingAccount Savingaccount) throws SQLException {
        Optional<SavingAccount> returnInsert = Optional.ofNullable(Savingaccount);
        PreparedStatement ps = connection.prepareStatement("BEGIN;" +
                "INSERT INTO account (accountNumber, balance, creationdate, client_code,employee_code,status) VALUES (?, ?, ?, ?, ?, ?::status);" +
                "INSERT INTO savingaccount (id, interestrate) VALUES (?, ?);" +
                "COMMIT;");

        ps.setString(1, Savingaccount.getAccNum());
        ps.setDouble(2, Savingaccount.getBalance());
        ps.setDate(3, Date.valueOf((LocalDate) Savingaccount.getCreationDate()));
        ps.setString(4, Savingaccount.getClient().getCode());
        ps.setString(5, Savingaccount.getEmployye().getRegistrationNumber());
        ps.setString(6, Savingaccount.getStatut().toString());
        ps.setString(7, Savingaccount.getAccNum());
        ps.setDouble(8, Savingaccount.getInterestRate());

        int rs = ps.executeUpdate();
        return returnInsert;
    }

    @Override
    public Optional<SavingAccount> update(SavingAccount currentSavingAccount) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(String AccNum) throws SQLException {
        return false;
    }

    @Override
    public List<Optional<SavingAccount>> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<SavingAccount> showByCreationDate() throws SQLException {
        return null;
    }

    @Override
    public List<SavingAccount> showByStatus() throws SQLException {
        return null;
    }

    @Override
    public Boolean changeStatut() throws SQLException {
        return null;
    }

    @Override
    public SavingAccount SearchByClient() throws SQLException {
        return null;
    }
}
