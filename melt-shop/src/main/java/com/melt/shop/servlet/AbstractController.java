package com.melt.shop.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.melt.shop.service.OrderService;
import com.melt.shop.service.ProductService;
import com.melt.shop.service.impl.ServiceManager;

public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = -2031074947573473708L;

	private ProductService productService;
	private OrderService orderService;

	@Override
	public final void init() throws ServletException {
		productService = ServiceManager.getInstance(getServletContext()).getProductService();
		orderService = ServiceManager.getInstance(getServletContext()).getOrderService();
	}

	public final ProductService getProductService() {
		return productService;
	}

	public final OrderService getOrderService() {
		return orderService;
	}
}
