package ua.park.gorky.core.service.api;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.AttractionBean;
import ua.park.gorky.core.entity.Attraction;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public interface IAttractionService {

    void create(AttractionBean bean);

    List<Attraction> getAll();

    Attraction getById(int id);
}
