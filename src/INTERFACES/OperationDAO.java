package INTERFACES;

import DTO.Account;
import DTO.Operation;
import DTO.SimpleOperation;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public interface OperationDAO {
    Optional<SimpleOperation> insert(SimpleOperation operation) throws SQLException;

    Optional<SimpleOperation> getOne(int operationNumber) throws SQLException;

    boolean delete(int t) throws SQLException;
}
