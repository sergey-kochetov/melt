package com.melt.shop.service;

import com.melt.shop.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts(int page, int limit);

}
