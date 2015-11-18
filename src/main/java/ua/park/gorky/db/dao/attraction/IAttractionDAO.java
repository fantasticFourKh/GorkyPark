package ua.park.gorky.db.dao.attraction;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.entity.Attraction;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public interface IAttractionDAO {

    void addAttraction(Attraction attraction);

    void deleteAttraction(Attraction attraction);

    List<Attraction> getAttractions();

    Attraction getAttractionById(int id);
}
