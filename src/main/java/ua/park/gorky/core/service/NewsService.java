package ua.park.gorky.core.service;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.NewsBean;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.service.api.INewsService;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class NewsService implements INewsService {
    @Override
    public void create(NewsBean bean) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<News> getAll() {
        return null;
    }

    @Override
    public News get(int id) {
        return null;
    }
}
