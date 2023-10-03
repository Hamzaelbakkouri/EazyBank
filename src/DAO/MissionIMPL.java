package DAO;

import DATABASE.DB;
import DTO.Mission;
import INTERFACES.MissionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MissionIMPL implements MissionDAO {
    Connection connection = DB.getConnection();

    @Override
    public Optional<Mission> insert(Mission mission) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO mission (code, name, description) VALUES (?, ?, ?)");
        statement.setString(1, mission.getCode());
        statement.setString(2, mission.getName());
        statement.setString(3, mission.getDescription());
        if (statement.executeUpdate() > 0) {
            return Optional.of(mission);
        }
        return Optional.empty();

    }

    @Override
    public int delete(String code) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from mission where code = ?");
        statement.setString(1, code);
        return statement.executeUpdate();
    }

    @Override
    public List<Map<String, String>> getAll() throws SQLException {
        Map<String, String> mission = new HashMap<>();
        List<Map<String, String>> missions = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from mission");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            mission.put("code", resultSet.getString("code"));
            mission.put("name", resultSet.getString("name"));
            mission.put("description", resultSet.getString("description"));
            missions.add(mission);
        }
        return missions;
    }
}
