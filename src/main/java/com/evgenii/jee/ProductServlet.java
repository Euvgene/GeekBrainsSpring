package com.evgenii.jee;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
   private List<Product> list;
    public static final Logger LOGGER = LogManager.getLogger(ProductServlet.class);
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        LOGGER.log(Level.INFO, "init methode");
        list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(new Product(i, "product №" + i, (int)(Math.random()*10000)));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "get request");
        request.setAttribute("product", list);
        request.getRequestDispatcher("/product.jsp").forward(request, response);
    }
}

