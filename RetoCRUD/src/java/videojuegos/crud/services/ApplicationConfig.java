/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.crud.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Guillermo Flecha
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(videojuegos.crud.services.AdministradorEntityFacadeREST.class);
        resources.add(videojuegos.crud.services.ClienteEntityFacadeREST.class);
        resources.add(videojuegos.crud.services.CompraEntityFacadeREST.class);
        resources.add(videojuegos.crud.services.DesarrolladoraEntityFacadeREST.class);
        resources.add(videojuegos.crud.services.PlataformaEntityFacadeREST.class);
        resources.add(videojuegos.crud.services.TiendaEntityFacadeREST.class);
        resources.add(videojuegos.crud.services.UsuarioEntityFacadeREST.class);
        resources.add(videojuegos.crud.services.VideojuegoEntityFacadeREST.class);
    }
    
}
