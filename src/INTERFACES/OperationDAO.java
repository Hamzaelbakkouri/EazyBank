package INTERFACES;

import DTO.Operation;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public interface OperationDAO {
    Optional<Operation> insert(Operation operation) throws SQLException;
    Optional<Operation> getOne(int operationNumber) throws SQLException;
    boolean delete(int t) throws SQLException;
}
