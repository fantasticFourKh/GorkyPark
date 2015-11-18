package ua.park.gorky.db.connection;

import org.springframework.stereotype.Service;

/**
 * @author Vladyslav
 */
@Service
public interface ConnectionPool<T> {
    void put(T connection);

    T get();

    void remove();
}
