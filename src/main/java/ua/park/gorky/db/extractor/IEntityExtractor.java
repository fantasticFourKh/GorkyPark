package ua.park.gorky.db.extractor;

import org.springframework.stereotype.Service;

import java.sql.ResultSet;

/**
 * @author Vladyslav
 */
@Service
public interface IEntityExtractor<T> {
    T extract(ResultSet resultSet);
}
