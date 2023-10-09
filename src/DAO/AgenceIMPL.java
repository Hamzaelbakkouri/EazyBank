package DAO;

import DATABASE.DB;
import DTO.Employee;
import INTERFACES2.AgenceDAO;
import DTO.Agence;

import java.util.List;
import java.util.Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AgenceIMPL implements AgenceDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<Agence> insert(Agence agence) {
        try {
            String query = "INSERT INTO agence(code, name, adresse, phonenumber) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, agence.getCode());
            preparedStatement.setString(2, agence.getName());
            preparedStatement.setString(3, agence.getAdresse());
            preparedStatement.setString(4, agence.getPhoneNumber());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 0) {
                return Optional.empty();
            } else {
                return Optional.of(agence);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Agence> update(Agence agence) {
        try {
            String query = "UPDATE agence SET name=?, adresse=?, phonenumber=? WHERE code=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, agence.getName());
            preparedStatement.setString(2, agence.getAdresse());
            preparedStatement.setString(3, agence.getPhoneNumber());
            preparedStatement.setString(4, agence.getCode());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 0) {
                return Optional.empty();
            } else {
                return Optional.of(agence);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Agence agence) {
        int rowAffected = 0;
        try {
            String query = "DELETE FROM agence WHERE code=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, agence.getCode());
            rowAffected = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rowAffected > 0;
    }

    @Override
    public List<Agence> findByEmploye(Employee employe) {
        List<Agence> agenceList = new ArrayList<>();
        try {
            String query = "SELECT * FROM EmployeeAffectation where employe = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employe.getRegistrationNumber());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Agence agence = new Agence();
                agence.setCode(resultSet.getString("code"));
                this.getOne(agence).ifPresent(agenceList::add);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return agenceList;
    }

    @Override
    public Optional<Agence> getOne(Agence agence) {
        try {
            String query = "SELECT * FROM agence WHERE code=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, agence.getCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                agence.setAdresse(resultSet.getString("adresse"));
                agence.setName(resultSet.getString("name"));
                agence.setPhoneNumber(resultSet.getString("phonenumber"));
            } else {
                return Optional.empty();
            }
            return Optional.of(agence);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Agence> getOneByAdress(Agence agence) {
        try {
            String query = "SELECT * FROM agence WHERE adresse=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, agence.getAdresse());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                agence.setCode(resultSet.getString("code"));
                agence.setName(resultSet.getString("name"));
                agence.setPhoneNumber(resultSet.getString("phonenumber"));
            } else {
                return Optional.empty();
            }
            return Optional.of(agence);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Agence> getAll() {
        List<Agence> agenceList = new ArrayList<>();
        try {
            String query = "SELECT * FROM agence";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Agence agence = new Agence();
                agence.setCode(resultSet.getString("code"));
                this.getOne(agence).ifPresent(agenceList::add);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return agenceList;
    }

    @Override
    public List<Agence> contact() {
        List<Agence> agenceList = new ArrayList<>();
        try {
            String query = "SELECT * FROM agence;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Agence agence = new Agence();
                agence.setPhoneNumber(resultSet.getString("phonenumber"));
                agence.setAdresse(resultSet.getString("adresse"));
                agenceList.add(agence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agenceList;
    }
}

