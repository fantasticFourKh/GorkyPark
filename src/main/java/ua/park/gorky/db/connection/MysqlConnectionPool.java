package ua.park.gorky.db.connection;

import org.springframework.stereotype.Service;

import java.sql.Connection;

/**
 * @author Vladyslav
 */
@Service
public class MysqlConnectionPool implements IConnectionPool<Connection> {
    private final ThreadLocal<Connection> pool = new ThreadLocal<>();

    @Override
    public void put(Connection connection) {
        pool.set(connection);
    }

    @Override
    public Connection get() {
        return pool.get();
    }

    @Override
    public void remove() {
        pool.remove();
    }

}
