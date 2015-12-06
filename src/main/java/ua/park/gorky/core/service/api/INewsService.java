package ua.park.gorky.core.service.api;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.NewsBean;
import ua.park.gorky.core.entity.News;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public interface INewsService {
    void create(NewsBean bean);

    void delete(int id);

    List<News> getAll();

    News get(int id);
}
