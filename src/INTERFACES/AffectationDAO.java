package INTERFACES;

import DTO.Affectation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AffectationDAO {
    Optional<Affectation> insert(Affectation affectation) throws SQLException;

    List<Map<String, String>> getEmployeeAffectations(String num) throws SQLException;

//     Statistiques() throws SQLException;
}