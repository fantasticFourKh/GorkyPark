package ua.park.gorky.web.sorter;

import ua.park.gorky.core.entity.Comment;
import ua.park.gorky.core.entity.News;

import java.util.Comparator;


public class Sorter {

    // COMMENT count sorter
    public static final Comparator<News> SORT_BY_COMMENT = new Comparator<News>() {

        @Override
        public int compare(News o1, News o2) {
            return o1.getCommentCount() - o2.getCommentCount();
        }
    };

    public static final Comparator<News> SORT_BY_COMMENT_REVERSE = new Comparator<News>() {

        @Override
        public int compare(News o1, News o2) {
            return o2.getCommentCount() - o1.getCommentCount();
        }
    };

    // NEWS date sorter

    public static final Comparator<News> SORT_NEWS_BY_DATE = new Comparator<News>() {
        @Override
        public int compare(News o1, News o2) {
            return o2.getPostDate().compareTo(o1.getPostDate());
        }
    };

    public static final Comparator<News> SORT_NEWS_BY_DATE_REVERSE = new Comparator<News>() {
        @Override
        public int compare(News o1, News o2) {
            return o1.getPostDate().compareTo(o2.getPostDate());
        }
    };

    // COMMENT date sorter

    public static final Comparator<Comment> SORT_COMMENT_BY_DATE = new Comparator<Comment>() {
        @Override
        public int compare(Comment o1, Comment o2) {
            return (o2.getWroteDate().compareTo(o1.getWroteDate()));
        }
    };

    public static final Comparator<Comment> SORT_COMMENT_BY_DATE_REVERSE = new Comparator<Comment>() {
        @Override
        public int compare(Comment o1, Comment o2) {
            return (o2.getWroteDate().compareTo(o1.getWroteDate()));
        }
    };

}