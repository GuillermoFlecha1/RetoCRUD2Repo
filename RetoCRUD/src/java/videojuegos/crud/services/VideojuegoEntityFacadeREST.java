/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.crud.services;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
import videojuegos.crud.entities.VideojuegoEntity;

/**
 *
 * @author 2dam
 */
@Stateless
@Path("videojuegos.crud.entities.videojuegoentity")
public class VideojuegoEntityFacadeREST extends AbstractFacade<VideojuegoEntity> {

    private static final Logger LOGGER = Logger.getLogger("videojuegos.crud.services");
    @PersistenceContext(unitName = "CRUDWebG5PU")
    private EntityManager em;

    public VideojuegoEntityFacadeREST() {
        super(VideojuegoEntity.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(VideojuegoEntity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, VideojuegoEntity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public VideojuegoEntity find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VideojuegoEntity> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VideojuegoEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    @GET
    @Path("titulo/{titulo}")
    @Produces({"application/xml"})
    public List<VideojuegoEntity> ConsultaVideojuegoTitulo(@PathParam("titulo") String titulo) {
        List<VideojuegoEntity> videojuegos = null;
        try {
            LOGGER.log(Level.INFO, "VIdeojuegosRESTful service: buscando videjuegos por titulo {0}.", titulo);
            videojuegos = em.createNamedQuery("ConsultaTitulo")
                    .setParameter("titulo", titulo)
                    .getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "VideojuegosRESTful service: Excepcion leyendo videojuegos por titulo, {0}",
                    e.getMessage());
            throw new InternalServerErrorException(e);
        }
        return videojuegos;
    }

    @GET
    @Path("fechaLanzamiento/{fechaInicio}/{fechaFin}")
    @Produces({"application/xml"})
    public List<VideojuegoEntity> ConsultaVideojuegoEntreFechas(@PathParam("fechaInicio") String fechaInicio, @PathParam("fechaFin") String fechaFin) {
        List<VideojuegoEntity> videojuegos = null;
        String format = "dd-MM-yyyy";
        Query query;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);

            Date inicio = dateFormat.parse(fechaInicio);
            Date fin = dateFormat.parse(fechaFin);

            LOGGER.log(Level.INFO,
                    "VideojuegosRESTful service: buscando videojuegos entre fechas {0} y {1}.",
                    new Object[]{inicio, fin});

            LOGGER.log(Level.INFO, "VIdeojuegosRESTful service: buscando videjuegos por fecha de Inicio {0}" + fechaInicio + " y fecha fin {0}." + fechaFin);
            query = em.createNamedQuery("ConsultaEntreFechas");
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            videojuegos = query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "VideojuegosRESTful service: Excepcion leyendo videojuegos por fecha, {0}",
                    e.getMessage());
            throw new InternalServerErrorException(e);
        }
        return videojuegos;
    }
    
    @GET
    @Path("fechaInicio/{fechaInicio}")
    @Produces({"application/xml"})
    public List<VideojuegoEntity> ConsultaVideojuegoFechaInicio(@PathParam("fechaInicio") String fechaInicio) {
        List<VideojuegoEntity> videojuegos = null;
        String format = "dd-MM-yyyy";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            Date inicio = dateFormat.parse(fechaInicio);
            LOGGER.log(Level.INFO, "VIdeojuegosRESTful service: buscando videjuegos por fechaInicio {0}.", inicio);
            videojuegos = em.createNamedQuery("ConsultaFechaInicio")
                    .setParameter("fechaInicio", inicio)
                    .getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "VideojuegosRESTful service: Excepcion leyendo videojuegos por fechaInicio, {0}",
                    e.getMessage());
            throw new InternalServerErrorException(e);
        }
        return videojuegos;
    }
    
    @GET
    @Path("fechaFin/{fechaFin}")
    @Produces({"application/xml"})
    public List<VideojuegoEntity> ConsultaVideojuegoFechaFin(@PathParam("fechaFin") String fechaFin) {
        List<VideojuegoEntity> videojuegos = null;        
        String format = "dd-MM-yyyy";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            Date fin = dateFormat.parse(fechaFin);
            LOGGER.log(Level.INFO, "VIdeojuegosRESTful service: buscando videojuegos por fechaFin {0}.", fechaFin);
            videojuegos = em.createNamedQuery("ConsultaFechaFin")
                    .setParameter("fechaInicio", fin)
                    .getResultList();
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE,
                    "VideojuegosRESTful service: Excepcion leyendo videojuegos por fechaFin, {0}",
                    e.getMessage());
            throw new InternalServerErrorException(e);
        }
        return videojuegos;
    }    
}
