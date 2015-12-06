package ua.park.gorky.core.bean;

import ua.park.gorky.core.validator.annotation.NotNull;
import ua.park.gorky.core.validator.annotation.StringNotEmpty;

/**
 * @author Vladyslav_Yemelianov
 */
public class NewsBean implements ViewBean {

    @NotNull
    @StringNotEmpty
    private String title;

    @NotNull
    @StringNotEmpty
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewsBean{");
        sb.append("title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
