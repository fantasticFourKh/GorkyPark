package ua.park.gorky.db.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.park.gorky.core.entity.exception.TranscationException;
import ua.park.gorky.db.connection.ConnectionPool;
import ua.park.gorky.db.connection.MySQLConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Vladyslav
 */
@Service
public class MySqlTransactionManager implements TransactionManager {
    @Autowired
    private ConnectionPool<Connection> connectionPool;

    @Override
    public <T> T doInTransaction(TransactionOperation<T> transactionOperation) {
        Connection connection = MySQLConnection.getWebInstance();
        connectionPool.put(connection);

        T result = transactionOperation.apply();

        try {
            connection.commit();
        } catch (SQLException e) {
            throw new TranscationException("Transaction not commited.", e);
        } finally {
            rollback(connection);
            connectionPool.remove();
        }
        return result;
    }

    private void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new TranscationException("Transaction not rollbacked.", e);
        }
    }
}
