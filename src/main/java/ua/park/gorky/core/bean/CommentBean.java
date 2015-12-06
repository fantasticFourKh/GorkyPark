package ua.park.gorky.core.bean;

import ua.park.gorky.core.constants.CoreConsts;
import ua.park.gorky.core.validator.annotation.MatchPattern;
import ua.park.gorky.core.validator.annotation.NotNull;
import ua.park.gorky.core.validator.annotation.StringLength;
import ua.park.gorky.core.validator.annotation.StringNotEmpty;

/**
 * @author Vladyslav_Yemelianov
 */
public class CommentBean implements ViewBean {

    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.NUMBERS, message = "Not integer value found.")
    private String articleId;

    @NotNull
    @StringNotEmpty
    @StringLength(length = 130, message = "Comment can't be longer then 130 symbols.")
    private String body;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommentBean{");
        sb.append("articleId='").append(articleId).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
