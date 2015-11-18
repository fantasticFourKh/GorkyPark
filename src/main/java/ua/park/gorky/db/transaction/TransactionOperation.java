package ua.park.gorky.db.transaction;

/**
 * @author Vladyslav
 */
public interface TransactionOperation<T> {
    T apply();
}
