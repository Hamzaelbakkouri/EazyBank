package DAO;

import DATABASE.DB;
import DTO.*;
import INTERFACES.SavingAccountDAO;
import INTERFACES.statut;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map<String, Optional<SavingAccount>> getAll() throws SQLException {
        Map<String, Optional<SavingAccount>> currentAccounts = new HashMap<>();
        String sql = "SELECT * FROM account AS a INNER JOIN savingAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id ";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
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
            statut statues = statut.valueOf(status);
            double interestrate = rs.getDouble("interestrate");

            String sql2 = "SELECT * FROM account AS a INNER JOIN employe as emp ON a.employee_code = emp.registrationnumber Inner Join person ON emp.id = person.id WHERE a.accountNumber = ?  ";
            ps = connection.prepareStatement(sql2);
            ps.setString(1, rs.getString("accountNumber"));
            ResultSet rs2 = ps.executeQuery();
            Employee employee = null;
            if (rs2.next()) {
                employee = new Employee(
                        rs2.getString("firstname"),
                        rs2.getString("lastname"),
                        rs2.getDate("dateofbirth").toLocalDate(),
                        rs2.getString("phonenumber"),
                        rs2.getString("registrationnumber"),
                        rs2.getDate("recrutmentdate").toLocalDate(),
                        rs2.getString("email")
                );
            }
            rs2.close();

            currentAccounts.put(accnum, Optional.of(new SavingAccount(accnum, balance, creationdate, statues, interestrate, client, employee)));
        }
        rs.close();
        ps.close();
        return currentAccounts;
    }

    @Override
    public Map<String, Optional<SavingAccount>> showByCreationDate(LocalDate date) throws SQLException {
        Map<String, Optional<SavingAccount>> currentAccounts = new HashMap<>();
        String sql = "SELECT * FROM account AS a INNER JOIN savingAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id WHERE a.creationdate = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, Date.valueOf((LocalDate) date));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
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
            statut statues = statut.valueOf(status);
            double interestrate = rs.getDouble("interestrate");

            String sql2 = "SELECT * FROM account AS a INNER JOIN employe as emp ON a.employee_code = emp.registrationnumber Inner Join person ON emp.id = person.id WHERE a.accountNumber = ?  ";
            ps = connection.prepareStatement(sql2);
            ps.setString(1, rs.getString("accountNumber"));
            ResultSet rs2 = ps.executeQuery();
            Employee employee = null;
            if (rs2.next()) {
                employee = new Employee(
                        rs2.getString("firstname"),
                        rs2.getString("lastname"),
                        rs2.getDate("dateofbirth").toLocalDate(),
                        rs2.getString("phonenumber"),
                        rs2.getString("registrationnumber"),
                        rs2.getDate("recrutmentdate").toLocalDate(),
                        rs2.getString("email")
                );
            }
            rs2.close();

            currentAccounts.put(accnum, Optional.of(new SavingAccount(accnum, balance, creationdate, statues, interestrate, client, employee)));
        }
        rs.close();
        ps.close();
        return currentAccounts;
    }

    @Override
    public Map<String, Optional<SavingAccount>> showByStatus(statut stats) throws SQLException {
        Map<String, Optional<SavingAccount>> currentAccounts = new HashMap<>();
        String sql = "SELECT * FROM account AS a INNER JOIN savingAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id WHERE a.status = ?::status";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, stats.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
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
            statut statues = statut.valueOf(status);
            double interestrate = rs.getDouble("interestrate");

            String sql2 = "SELECT * FROM account AS a INNER JOIN employe as emp ON a.employee_code = emp.registrationnumber Inner Join person ON emp.id = person.id WHERE a.accountNumber = ?  ";
            ps = connection.prepareStatement(sql2);
            ps.setString(1, rs.getString("accountNumber"));
            ResultSet rs2 = ps.executeQuery();
            Employee employee = null;
            if (rs2.next()) {
                employee = new Employee(
                        rs2.getString("firstname"),
                        rs2.getString("lastname"),
                        rs2.getDate("dateofbirth").toLocalDate(),
                        rs2.getString("phonenumber"),
                        rs2.getString("registrationnumber"),
                        rs2.getDate("recrutmentdate").toLocalDate(),
                        rs2.getString("email")
                );
            }
            rs2.close();

            currentAccounts.put(accnum, Optional.of(new SavingAccount(accnum, balance, creationdate, statues, interestrate, client, employee)));
        }
        rs.close();
        ps.close();
        return currentAccounts;
    }


    @Override
    public Boolean changeStatut(String accnum, statut stats) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE account SET status = ?::status WHERE accountNumber = ? ");

        ps.setString(1, stats.toString());
        ps.setString(2, accnum);

        int rs = ps.executeUpdate();
        return rs > 0;
    }

    @Override
    public Map<String, Optional<SavingAccount>> SearchByClient(String clintCode) throws SQLException {
        return null;
    }

}
