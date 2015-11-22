package ua.park.gorky.db.dao.news;

import ua.park.gorky.core.entity.News;

import java.util.List;

/**
 * Created by Владислав on 18.11.2015.
 */
public interface INewsDAO {

    void addNews(News news);

    void deleteNewsById(int id);

    News getNewsById(int id);

    List<News> getAllNews();

    List<News> getNewsByTitleBody(String text);

}
