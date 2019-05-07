package com.melt.shop.entity;

import java.util.StringJoiner;

public class OrderItem extends AbstractEntity<Long> {
    private static final  long serialVersionUID = 764623442353453L;

    private Long idOrder;
    private Product product;
    private int count;

    public OrderItem() {
    }

    public OrderItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderItem.class.getSimpleName() + "[", "]")
                .add("idOrder=" + idOrder)
                .add("product=" + product)
                .add("count=" + count)
                .add("id=" + id)
                .toString();
    }
}
