package com.gmail.safordog.controller;

import com.gmail.safordog.model.Dish;
import com.gmail.safordog.model.TemplateResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "AddDishServlet", urlPatterns = "/new_dish")
public class AddDishServlet extends javax.servlet.http.HttpServlet {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("menu");

    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException {

        String name = req.getParameter("name");
        int price  = Integer.parseInt(req.getParameter("price"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        String discount = req.getParameter("discount");
        Dish dish = new Dish();
        dish.saveDish(factory, name, price, weight, discount);
        req.setAttribute("addedDishMessage", "New dish added!!!");
        req.getRequestDispatcher("template_resp.jsp").forward(req, resp);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException {

        TemplateResponse temp = new TemplateResponse();
        resp.getWriter().print(temp.getAddDish());
    }

}
