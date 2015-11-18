package ua.park.gorky.core.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Timestamp;

/**
 * Created by ��������� on 17 ��� 2015 �..
 */
public class Comment extends Entity {

    private User user;
    private News news;
    private String body;
    private Timestamp wroteDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getWroteDate() {
        return wroteDate;
    }

    public void setWroteDate(Timestamp wroteDate) {
        this.wroteDate = wroteDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id=", getId())
                .append("user=", user)
                .append("news=", news)
                .append("body=", body)
                .append("wrote_date=", wroteDate)
                .build();
    }
}
