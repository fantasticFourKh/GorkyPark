package ua.park.gorky.core.service.api;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.entity.Attraction;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public interface IAttractionService {

    List<Attraction> getAll();

    Attraction getById(int id);
}
