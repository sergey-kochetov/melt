package com.melt.shop.entity;

import java.util.StringJoiner;

public class Account extends AbstractEntity<Integer> {
    private static final  long serialVersionUID = -34623442353453L;

    private String name;
    private String email;

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("id=" + id)
                .toString();
    }
}

