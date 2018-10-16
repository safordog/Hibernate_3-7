package com.gmail.safordog.controller;

import com.gmail.safordog.model.Dish;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DishPriceServlet", urlPatterns = "/by_price")
public class DishPriceServlet extends HttpServlet {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("menu");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int from = Integer.parseInt(req.getParameter("from"));
        int to = Integer.parseInt(req.getParameter("to"));
        Dish dish = new Dish();
        String menu = "";
        for (Dish temp : dish.getDishByParemeter(factory, from, to)) {
            menu +=  "- " + temp.getDishName() + " price: " + temp.getPrice() + "$ weight: " + temp.getWeight()
                    + "gr discount: " + temp.getDiscount() + "<br>";
        }
        req.setAttribute("menuByPriceMessage", menu);
        req.getRequestDispatcher("template_resp.jsp").forward(req, resp);
    }
}
