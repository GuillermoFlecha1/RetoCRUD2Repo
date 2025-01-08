/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.crud.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo Flecha, Asier del Campo y Andoni Garcia.
 */
@Entity
@Table(name="Cliente", schema="CRUD_DATABASE")
@XmlRootElement
public class ClienteEntity extends UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String IBAN;

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
}
