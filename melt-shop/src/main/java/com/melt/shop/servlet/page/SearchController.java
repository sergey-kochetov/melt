package com.melt.shop.servlet.page;

import com.melt.shop.servlet.AbstractController;
import com.melt.shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchController extends AbstractController {
    private static final long serialVersionUID = -6344563457567676L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productCount", 24);
        RoutingUtils.forwardToPage("search-result.jsp", req, resp);
    }
}
