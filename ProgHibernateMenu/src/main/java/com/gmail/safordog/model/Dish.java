package com.gmail.safordog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Dish {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String dishName;
    private int price;
    private int weight;
    private String discount;

    public Dish() {
    }

    public Dish(String dishName, int price, int weight, String discount) {
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void saveDish(EntityManagerFactory factory, String name, int price, int weight, String discount) {

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Dish dish = new Dish();
        dish.setDishName(name);
        dish.setPrice(price);
        dish.setWeight(weight);
        dish.setDiscount(discount);
        em.persist(dish);
        em.getTransaction().commit();
        em.close();
    }

    public List<Dish> getMenu(EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM  com.gmail.safordog.model.Dish e");
        List<Dish> result = query.getResultList();
        em.getTransaction().commit();
        return result;
    }

    public List<Dish> getDishByParemeter(EntityManagerFactory factory, int from, int to) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM  com.gmail.safordog.model.Dish e WHERE e.price BETWEEN ?1 AND ?2");
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Dish> result = query.getResultList();
        em.getTransaction().commit();
        return result;
    }

    public List<Dish> getDiscountMenu(EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM  com.gmail.safordog.model.Dish e WHERE e.discount = :disc");
        query.setParameter("disc", "yes");
        List<Dish> result = query.getResultList();
        em.getTransaction().commit();
        return result;
    }
}

