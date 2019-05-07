package com.melt.shop.service;

import com.melt.shop.entity.Category;
import com.melt.shop.entity.Producer;
import com.melt.shop.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts(int page, int limit);

    List<Product> listProductsByCategory(String categoryUrl, int page, int limit);

    List<Category> listAllCategories();

    List<Producer> listAllProducers();

}
