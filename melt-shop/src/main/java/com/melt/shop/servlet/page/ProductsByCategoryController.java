package com.melt.shop.servlet.page;

import com.melt.shop.servlet.AbstractController;
import com.melt.shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/*")
public class ProductsByCategoryController extends AbstractController {
    private static final long serialVersionUID = -634457567676L;
    private static final int SUBSTRING_INDEX = "/products".length();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryUrl = req.getRequestURI().substring(SUBSTRING_INDEX);
        RoutingUtils.forwardToPage("products.jsp", req, resp);
    }
}
