package ua.park.gorky.db.extractor;

import java.sql.ResultSet;

/**
 * @author Vladyslav
 */
public interface IEntityExtractor<T> {
    T extract(ResultSet resultSet);
}
