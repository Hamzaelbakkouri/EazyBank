package INTERFACES2;

import java.util.List;
import java.util.Optional;

public interface TypeDAO<T, V> {
    Optional<T> getOne(T t);

    Optional<T> insert(T t);

    Optional<T> update(T t);

    boolean delete(T t);

}
