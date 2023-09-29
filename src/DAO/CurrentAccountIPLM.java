package DAO;

import DATABASE.DB;
import DTO.Client;
import DTO.CurrentAccount;
import DTO.Employee;
import INTERFACES.CurrentAccountDAO;
import INTERFACES.statut;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class CurrentAccountIPLM implements CurrentAccountDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<CurrentAccount> getOne(String accountNumber) throws SQLException {
        Optional<CurrentAccount> currentAccount = Optional.empty();
        statut statues;
        String sql = "SELECT * FROM account AS a INNER JOIN currentAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id WHERE a.accountnumber = ?  ";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, accountNumber);
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
                        + "UPDATE account SET balance = ?, status = ?::status WHERE accountNumber = ? ;"
                        + "UPDATE currentAccount SET maxprice = ? WHERE id = ?;" +
                        "COMMIT;");

        ps.setDouble(1, currentCurrentAccount.getBalance());
        ps.setString(2, currentCurrentAccount.getStatut().toString());
        ps.setString(3, currentCurrentAccount.getAccNum());
        ps.setDouble(4, currentCurrentAccount.getMaxPrice());
        ps.setString(5, currentCurrentAccount.getAccNum());

        int rs = ps.executeUpdate();
        return returnInsert;
    }

    @Override
    public boolean delete(String AccNum) throws SQLException {
        PreparedStatement ps = null;

        String sql = "DELETE FROM account WHERE account.accountNumber = ?;";

        ps = connection.prepareStatement(sql);
        ps.setString(1, AccNum);
        int rowsDeleted = ps.executeUpdate();

        return rowsDeleted > 0;
    }

    @Override
    public Map<String, Optional<CurrentAccount>> getAll() throws SQLException {
        Map<String, Optional<CurrentAccount>> currentAccounts = new HashMap<>();
        String sql = "SELECT * FROM account AS a INNER JOIN currentAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id ";

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
            double maxprice = rs.getDouble("maxprice");

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

            currentAccounts.put(accnum, Optional.of(new CurrentAccount(accnum, balance, creationdate, statues, client, maxprice, employee)));
        }
        rs.close();
        ps.close();
        return currentAccounts;
    }

    @Override
    public Map<String, Optional<CurrentAccount>> showByCreationDate(LocalDate date) throws SQLException {
        Map<String, Optional<CurrentAccount>> currentAccounts = new HashMap<>();
        String sql = "SELECT * FROM account AS a INNER JOIN currentAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id WHERE a.creationdate = ?";

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
            double maxprice = rs.getDouble("maxprice");

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

            currentAccounts.put(accnum, Optional.of(new CurrentAccount(accnum, balance, creationdate, statues, client, maxprice, employee)));
        }
        rs.close();
        ps.close();
        return currentAccounts;
    }

    @Override
    public Map<String, Optional<CurrentAccount>> showByStatus(statut stats) throws SQLException {
        Map<String, Optional<CurrentAccount>> currentAccounts = new HashMap<>();
        String sql = "SELECT * FROM account AS a INNER JOIN currentAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id WHERE a.status = ?::status";

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
            double maxprice = rs.getDouble("maxprice");

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

            currentAccounts.put(accnum, Optional.of(new CurrentAccount(accnum, balance, creationdate, statues, client, maxprice, employee)));
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
    public Map<String, Optional<CurrentAccount>> SearchByClient(String client_code) throws SQLException {
        Map<String, Optional<CurrentAccount>> currentAccounts = new HashMap<>();
        String sql = "SELECT * FROM account AS a INNER JOIN currentAccount as ca ON ca.id = a.accountNumber INNER JOIN client as cl ON a.client_code = cl.code Inner Join person as p ON cl.id = p.id WHERE a.client_code = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, client_code);
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
            double maxprice = rs.getDouble("maxprice");

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

            currentAccounts.put(accnum, Optional.of(new CurrentAccount(accnum, balance, creationdate, statues, client, maxprice, employee)));
        }
        rs.close();
        ps.close();
        return currentAccounts;
    }


}
