package ua.park.gorky.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.NewsBean;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.service.api.INewsService;
import ua.park.gorky.db.dao.news.INewsDAO;
import ua.park.gorky.db.transaction.TransactionManager;
import ua.park.gorky.db.transaction.TransactionOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class NewsService implements INewsService {

    @Autowired
    private INewsDAO newsDAO;

    @Qualifier("mySqlTransactionManager")
    @Autowired
    private TransactionManager manager;

    @Override
    public void create(NewsBean bean) {
        manager.doInTransaction((TransactionOperation<Void>) () -> {
            News news = new News(bean);
            newsDAO.addNews(news);
            return null;
        });
    }

    @Override
    public void delete(int id) {
        manager.doInTransaction((TransactionOperation<Void>) () -> {
            newsDAO.deleteNewsById(id);
            return null;
        });
    }

    @Override
    public List<News> getAll() {
        return manager.doInTransaction(() -> newsDAO.getAllNews());
    }

    @Override
    public News get(int id) {
        return manager.doInTransaction(() -> newsDAO.getNewsById(id));
    }
}
