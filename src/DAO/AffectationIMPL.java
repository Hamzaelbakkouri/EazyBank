package DAO;

import DATABASE.DB;
import DTO.Affectation;
import INTERFACES.AffectationDAO;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class AffectationIMPL implements AffectationDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<Affectation> insert(Affectation affectation) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO affectation (mission_code, startDate,endDate, emloye_registrationNumber) VALUES ( ? , ? , ? , ? )");
            ps.setString(1, affectation.getMission());
            ps.setDate(2, Date.valueOf(affectation.getStartDate()));
            ps.setDate(3, Date.valueOf(affectation.getEndate()));
            ps.setString(4, affectation.getEmployee().getRegistrationNumber());
            if (ps.executeUpdate() > 0) {
                return Optional.of(affectation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Map<String, String>> getEmployeeAffectations(String num) {
        List<Map<String, String>> affects = new ArrayList<>();
        try {
            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM affectation WHERE emloye_registrationNumber = ?");
            ps.setString(1, num);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Map<String, String> affect = new HashMap<>();
                affect.put("startDate", String.valueOf(resultSet.getDate("startDate").toLocalDate()));
                affect.put("endDate", String.valueOf(resultSet.getDate("endDate").toLocalDate()));
                affect.put("missionCode", resultSet.getString("mission_code"));
                affect.put("employee", resultSet.getString("emloye_registrationNumber"));
                affects.add(affect);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affects;
    }

    @Override
    public Optional<Map<String, Integer>> Statistiques() {
        Map<String, Integer> stringIntegerHashMaps = new HashMap<String, Integer>();
        try {
            String query = "SELECT mission.*, COUNT(affectation.*) FROM mission JOIN affectation ON mission.code = affectation.mission_code GROUP BY mission.code;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                stringIntegerHashMaps.put(resultSet.getString("name"), resultSet.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(stringIntegerHashMaps);
    }

}
