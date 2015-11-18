package ua.park.gorky.db.extractor;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.entity.Attraction;
import ua.park.gorky.core.entity.exception.DataExtractionException;
import ua.park.gorky.db.constants.DbTables;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Vladyslav
 */
@Service
public class AttractionExtractor implements IEntityExtractor<Attraction> {
    @Override
    public Attraction extract(ResultSet resultSet) {
        Attraction attraction = new Attraction();
        try {
            attraction.setId(resultSet.getInt(DbTables.Attraction.ID));
            attraction.setTitle(resultSet.getString(DbTables.Attraction.TITLE));
            attraction.setDescription(resultSet.getString(DbTables.Attraction.DESC));
            attraction.setHeight(resultSet.getInt(DbTables.Attraction.HEIGHT));
            attraction.setImage(resultSet.getString(DbTables.Attraction.PICTURE));
            attraction.setAdultPrice(resultSet.getInt(DbTables.Attraction.ADULT_PRICE));
            attraction.setChildPrice(resultSet.getInt(DbTables.Attraction.CHILD_PRICE));
        } catch (SQLException e) {
            throw new DataExtractionException("Attraction not extracted from query result.", e);
        }
        return attraction;
    }
}
