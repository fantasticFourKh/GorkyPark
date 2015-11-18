package ua.park.gorky.db.transaction;

import org.springframework.stereotype.Service;

/**
 * @author Vladyslav
 */
@Service
public interface TransactionManager {
    <T> T doInTransaction (TransactionOperation<T> transactionOperation);
}
