/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.crud.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import videojuegos.crud.entities.DesarrolladoraEntity;

/**
 *
 * @author Guillermo Flecha
 */
@Stateless
@Path("videojuegos.crud.entities.desarrolladoraentity")
public class DesarrolladoraEntityFacadeREST extends AbstractFacade<DesarrolladoraEntity> {

    @PersistenceContext(unitName = "CRUDWebG5PU")
    private EntityManager em;
    
    /**
     * Logger for the class.
     */
    private static final Logger LOGGER =
            Logger.getLogger("videojuegos.crud.services");

    public DesarrolladoraEntityFacadeREST() {
        super(DesarrolladoraEntity.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DesarrolladoraEntity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, DesarrolladoraEntity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DesarrolladoraEntity find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DesarrolladoraEntity> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DesarrolladoraEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    /**
     * RESTful GET method for reading all {@link User} objects that has a certain profile
     * through an XML representation.
     * @param profile The profile value for the object.
     * @return A List of User objects containing data.
     */
    @GET
    @Path("nomEmpresa/{nomEmpresa}")
    @Produces({"application/xml"})
    public List<DesarrolladoraEntity> findDesarrolladoraByName(@PathParam("nomEmpresa") String nomEmpresa) {
        List<DesarrolladoraEntity> desarrolladoras=null;
        try {
            LOGGER.log(Level.INFO,"DesarrolladoraRESTful service: find desarrolladoras by name {0}.",nomEmpresa);
            desarrolladoras=em.createNamedQuery("findNombreEmpresa")
                     .setParameter("nomEmpresa", nomEmpresa)
                     .getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "DesarrolladoraRESTful service: Exception reading desarrolladoras by name, {0}",
                    e.getMessage());
            throw new InternalServerErrorException(e);
        }
        return desarrolladoras;
    }
}
