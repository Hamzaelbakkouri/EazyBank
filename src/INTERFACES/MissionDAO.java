package INTERFACES;

import DTO.Mission;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MissionDAO {
    Optional<Mission> insert(Mission mission) throws SQLException;

    int delete(String code) throws SQLException;

    List<Map<String, String>> getAll() throws SQLException;
}
