package ua.park.gorky.core.bean;


import ua.park.gorky.core.constants.CoreConsts;
import ua.park.gorky.core.validator.annotation.MatchPattern;
import ua.park.gorky.core.validator.annotation.NotNull;
import ua.park.gorky.core.validator.annotation.StringNotEmpty;

/**
 * @author Vladyslav
 */
public class AttractionBean implements ViewBean {
    private static final String ERR_MSG = "Should be positive number";

    @NotNull
    @StringNotEmpty
    private String title;
    @NotNull
    @StringNotEmpty
    private String description;
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.NUMBERS, message = ERR_MSG)
    private String height;
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.NUMBERS, message = ERR_MSG)
    private String adultPrice;
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.NUMBERS, message = ERR_MSG)
    private String childPrice;

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(String adultPrice) {
        this.adultPrice = adultPrice;
    }

    public String getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(String childPrice) {
        this.childPrice = childPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AttractionBean{");
        sb.append("title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", height='").append(height).append('\'');
        sb.append(", adultPrice='").append(adultPrice).append('\'');
        sb.append(", childPrice='").append(childPrice).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
