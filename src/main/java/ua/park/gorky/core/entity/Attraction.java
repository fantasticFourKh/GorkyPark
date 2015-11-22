package ua.park.gorky.core.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Attraction extends Entity {

    private String title;
    private String description;
    private int height;
    private String image;
    private int adultPrice;
    private int childPrice;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public int getAdultPrice() {
        return adultPrice;
    }

    public int getChildPrice() {
        return childPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAdultPrice(int adultPrice) {
        this.adultPrice = adultPrice;
    }

    public void setChildPrice(int childPrice) {
        this.childPrice = childPrice;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id=", getId())
                .append("title=", title)
                .append("description=", description)
                .append("minimum height=", height)
                .append("image=", image)
                .append("price for adults=", adultPrice)
                .append("price for children=", childPrice)
                .build();
    }


}
