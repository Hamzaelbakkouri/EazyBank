package INTERFACES;



import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> getOne(String t) throws SQLException;

    Optional<T> insert(T t) throws SQLException;

    Optional<T> update(T t) throws SQLException;

    boolean delete(String t) throws SQLException;

    Map<String, Optional<T>> getAll() throws SQLException;

}
