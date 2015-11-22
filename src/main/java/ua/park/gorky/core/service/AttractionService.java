package ua.park.gorky.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.park.gorky.core.entity.Attraction;
import ua.park.gorky.core.service.api.IAttractionService;
import ua.park.gorky.db.dao.attraction.IAttractionDAO;
import ua.park.gorky.db.transaction.TransactionManager;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public class AttractionService implements IAttractionService {

    @Qualifier("mySqlTransactionManager")
    @Autowired
    private TransactionManager manager;

    @Autowired
    private IAttractionDAO attractionDAO;

    @Override
    public List<Attraction> getAll() {
        return manager.doInTransaction(attractionDAO::getAttractions);
    }
}
