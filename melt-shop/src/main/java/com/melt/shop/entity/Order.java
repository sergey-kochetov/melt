package com.melt.shop.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.StringJoiner;

public class Order extends AbstractEntity<Long> {
    private static final  long serialVersionUID = -14623442353453L;

    private Integer idAccount;
    private List<OrderItem> items;
    private Timestamp created;

    public Order() {
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public BigDecimal getTotalCost() {
        BigDecimal cost = BigDecimal.ZERO;
        if (items != null) {
            for (OrderItem item : items) {
                cost = cost.add(item.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(item.getCount())));
            }
        }
        return cost;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("idAccount=" + idAccount)
                .add("items=" + items)
                .add("created=" + created)
                .add("id=" + id)
                .toString();
    }
}
