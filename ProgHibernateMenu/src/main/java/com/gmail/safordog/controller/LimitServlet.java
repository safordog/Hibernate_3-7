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

@WebServlet(name = "LimitServlet", urlPatterns = "/limit")
public class LimitServlet extends HttpServlet {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("menu");

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dish dish = new Dish();
        String menu = "";
        int weightLimiter = 0;
        for (Dish temp : dish.getMenu(factory)) {
            weightLimiter += temp.getWeight();
            if (weightLimiter > 1000) {
                break;
            }
            menu +=  "- " + temp.getDishName() + " price: " + temp.getPrice() + "$ weight: " + temp.getWeight()
                    + "gr discount: " + temp.getDiscount() + "<br>";
        }
        req.setAttribute("limitMenuMessage", menu);
        req.getRequestDispatcher("template_resp.jsp").forward(req, resp);
    }
}
