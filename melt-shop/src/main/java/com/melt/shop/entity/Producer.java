package com.melt.shop.entity;

import java.util.StringJoiner;

public class Producer extends AbstractEntity<Integer> {
    private static final  long serialVersionUID = -4363442353453L;

    private String name;
    private int productCount;

    public Producer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Producer.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("productCount=" + productCount)
                .add("id=" + id)
                .toString();
    }
}
