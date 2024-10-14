/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.eclipse.jakarta.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.eclipse.jakarta.model.entity.ProductoElectronico;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Stateless
public class ProductoElectronicoRepository {
   @PersistenceContext
    private EntityManager em;

    public ProductoElectronico crear(ProductoElectronico producto) {
        em.persist(producto);
        return producto;
    }

    public List<ProductoElectronico> obtenerTodos() {
        return em.createQuery("SELECT p FROM ProductoElectronico p", ProductoElectronico.class).getResultList();
    }

    public Optional<ProductoElectronico> obtenerPorId(Long id) {
        return Optional.ofNullable(em.find(ProductoElectronico.class, id));
    }

    public void eliminar(Long id) {
        ProductoElectronico producto = obtenerPorId(id)
            .orElseThrow(() -> new IllegalArgumentException("ID no válido: " + id));
        em.remove(producto);
    }

    public ProductoElectronico actualizar(ProductoElectronico producto) {
        return em.merge(producto);
    }
}
