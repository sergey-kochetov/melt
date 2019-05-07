package com.melt.shop.entity;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class Product extends AbstractEntity<Integer> {
    private static final  long serialVersionUID = -4365442353453L;

    private String name;
    private String description;
    private String imageLink;
    private BigDecimal price;
    private String category;
    private String producer;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("imageLink='" + imageLink + "'")
                .add("price=" + price)
                .add("category='" + category + "'")
                .add("producer='" + producer + "'")
                .add("id=" + id)
                .toString();
    }
}
