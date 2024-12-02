/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.model.Product;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import com.model.Product;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductBean implements Serializable {
    @PersistenceContext
    private EntityManager em;

    public List<Product> getProducts() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
}