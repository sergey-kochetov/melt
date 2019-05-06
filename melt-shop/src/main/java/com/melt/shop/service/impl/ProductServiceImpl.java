package com.melt.shop.service.impl;

import com.melt.shop.entity.Product;
import com.melt.shop.exception.InternalServerErroeException;
import com.melt.shop.jdbc.JDBCUtils;
import com.melt.shop.jdbc.ResultSetHandler;
import com.melt.shop.jdbc.ResultSetHandlerFactory;
import com.melt.shop.service.ProductService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class ProductServiceImpl implements ProductService {

    private static final ResultSetHandler<List<Product>> productsResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);

    private DataSource dataSource;

    @Override
    public List<Product> listAllProducts(int page, int limit) {
        try(Connection c = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            return JDBCUtils.select(c, "select p.*, c.name as category, pr.name as producer from product p, producer pr, category c "
                    + "where c.id=p.id_category and pr.id=p.id_producer limit ? offset ?", productsResultSetHandler, limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErroeException("Can't execute sql query: " + e.getMessage(), e);
        }
    }
}
