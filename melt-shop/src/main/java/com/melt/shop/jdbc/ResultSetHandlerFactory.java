package com.melt.shop.jdbc;

import com.melt.shop.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ResultSetHandlerFactory {
    public final static ResultSetHandler<Product> PRODUCT_RESULT_SET_HANDLER = rs -> {
        Product p = new Product();
        p.setCategory(rs.getString("category"));
        p.setDescription(rs.getString("description"));
        p.setId(rs.getInt("id"));
        p.setImageLink(rs.getString("image_link"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getBigDecimal("price"));
        p.setProducer(rs.getString("producer"));
        return p;
    };
    public final static <T> ResultSetHandler<T> getSingleResultSetHandler(final ResultSetHandler<T> oneRowResultSetHandler) {
        return rs -> {
            if (rs.next()) {
                return oneRowResultSetHandler.handle(rs);
            } else {
                return null;
            }
        };
    }
    public final static <T> ResultSetHandler<List<T>> getListResultSetHandler(final ResultSetHandler<T> oneRowResultSetHandler) {
        return rs -> {
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                list.add(oneRowResultSetHandler.handle(rs));
            }
            return list;
        };
    }
}
