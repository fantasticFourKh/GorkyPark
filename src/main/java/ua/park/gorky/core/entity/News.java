package ua.park.gorky.core.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Timestamp;

/**
 * Created by ��������� on 17 ��� 2015 �..
 */
public class News extends Entity {

    private User user;
    private String title;
    private String body;
    private String newsPicture;
    private Timestamp postDate;

    private int commentCount;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getNewsPicture() {
        return newsPicture;
    }

    public void setNewsPicture(String newsPicture) {
        this.newsPicture = newsPicture;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id=", getId())
                .append("user=", user)
                .append("title=", title)
                .append("body=", body)
                .append("news_picture=", newsPicture)
                .append("post_date=", postDate)
                .build();
    }
}
