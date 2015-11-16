package ua.park.gorky.db.dao.attraction;

import ua.park.gorky.core.entity.Attraction;

import java.util.List;

/**
 * @author Vladyslav
 */
public interface IAttractionDAO {

    void addAttraction(Attraction attraction);

    void deleteAttraction(Attraction attraction);

    List<Attraction> getAttractions();

    Attraction getAttractionById(int id);
}
