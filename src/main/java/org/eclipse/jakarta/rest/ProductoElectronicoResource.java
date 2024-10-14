/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.eclipse.jakarta.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.model.ProductoElectronicoRepository;
import org.eclipse.jakarta.model.entity.ProductoElectronico;

import java.util.List;
import java.util.Optional;

@Path("productos")
public class ProductoElectronicoResource {
    @Inject
    private ProductoElectronicoRepository repositorio;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public ProductoElectronico obtenerPorId(@PathParam("id") Long id) {
        return repositorio.obtenerPorId(id)
            .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces("application/json")
    public List<ProductoElectronico> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ProductoElectronico crear(ProductoElectronico producto) {
        return repositorio.crear(producto);
    }

    @DELETE
    @Path("{id}")
    public void eliminar(@PathParam("id") Long id) {
        repositorio.eliminar(id);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public ProductoElectronico actualizar(ProductoElectronico producto) {
        return repositorio.actualizar(producto);
    }
}
