/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.crud.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo Flecha, Asier del Campo y Andoni Garcia.
 */
@Entity
@Table(name="Administrador", schema="CRUD_DATABASE")
@XmlRootElement
public class AdministradorEntity extends UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
