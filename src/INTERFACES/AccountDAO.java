package INTERFACES;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO<T> {
    T getOne(String t) throws SQLException;

    List<T> getALL() throws SQLException;

    T insert(T t) throws SQLException;

    T update(T t) throws SQLException;

    boolean delete(double t) throws SQLException;
}

