package com.melt.shop.entity;

import java.util.StringJoiner;

public class Category extends AbstractEntity<Integer> {
    private static final  long serialVersionUID = -43623442353453L;

    private String name;
    private String url;
    private Integer productCount;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Category.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("url='" + url + "'")
                .add("productCount=" + productCount)
                .add("id=" + id)
                .toString();
    }
}
