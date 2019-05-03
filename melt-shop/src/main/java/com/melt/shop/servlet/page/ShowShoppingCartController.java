package com.melt.shop.servlet.page;

import com.melt.shop.servlet.AbstractController;
import com.melt.shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shoping-cart")
public class ShowShoppingCartController extends AbstractController {
    private static final long serialVersionUID = -1234457567676L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoutingUtils.forwardToPage("shopping-cart.jsp", req, resp);
    }
}
