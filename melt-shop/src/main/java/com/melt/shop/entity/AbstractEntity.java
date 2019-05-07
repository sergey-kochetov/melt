package com.melt.shop.entity;

import java.io.Serializable;
import java.util.StringJoiner;

public class AbstractEntity<T> implements Serializable {
    public static final  long serialVersionUID = 4363442353453L;

    T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity<?> that = (AbstractEntity<?>) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AbstractEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .toString();
    }
}
