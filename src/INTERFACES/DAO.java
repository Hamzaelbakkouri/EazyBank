package INTERFACES;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> getOne(String t) throws SQLException;

    Optional<T> insert(T t) throws SQLException;

    Optional<T> update(T t) throws SQLException;

    boolean delete(String t) throws SQLException;

    List<Optional<T>> getAll() throws SQLException;

}

