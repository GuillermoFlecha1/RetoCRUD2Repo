/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.crud.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo Flecha, Asier del Campo y Andoni Garcia.
 */
@Entity
@Table(name="Compra", schema="CRUD_DATABASE")
@XmlRootElement
public class CompraEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CompraId idCompra;
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @MapsId("usuarioId")
    @ManyToOne
    private UsuarioEntity usuario;
    @MapsId("tiendaId")
    @ManyToOne
    private TiendaEntity tienda;

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public TiendaEntity getTienda() {
        return tienda;
    }

    public void setTienda(TiendaEntity tienda) {
        this.tienda = tienda;
    }

    public CompraId getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(CompraId idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraEntity)) {
            return false;
        }
        CompraEntity other = (CompraEntity) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videojuegos.crud.entities.CompraEntity[ id=" + idCompra + " ]";
    }
    
}
