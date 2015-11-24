package ua.park.gorky.core.bean;

import ua.park.gorky.core.validation.ValidationConsts;
import ua.park.gorky.core.validation.ann.NotBlank;
import ua.park.gorky.core.validation.ann.RegExp;

/**
 * @author Vladyslav
 */
public class AttractionBean implements ViewBean {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    @RegExp(regex = ValidationConsts.NUMBER_REGEX)
    private String height;
    @NotBlank
    @RegExp(regex = ValidationConsts.NUMBER_REGEX)
    private String adultPrice;
    @NotBlank
    @RegExp(regex = ValidationConsts.NUMBER_REGEX)
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
}
