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

@WebServlet(name = "AllMenuServlet", urlPatterns = "/all_menu")
public class AllMenuServlet extends HttpServlet {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("menu");

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dish dish = new Dish();
        String menu = "";
        for (Dish temp : dish.getMenu(factory)) {
            menu +=  "- " + temp.getDishName() + " price: " + temp.getPrice() + "$ weight: " + temp.getWeight()
                    + "gr discount: " + temp.getDiscount() + "<br>";
        }
        req.setAttribute("menuMessage", menu);
        req.getRequestDispatcher("template_resp.jsp").forward(req, resp);
    }
}
