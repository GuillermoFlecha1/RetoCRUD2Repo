/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.crud.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guillermo Flecha, Asier del Campo, Daniel Quitana y Andoni Garcia.
 */
@Entity
@Table(name="Tienda", schema="CRUD_DATABASE")
@XmlRootElement
public class TiendaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String cif;
    private String nomTienda, web, direccion, logo;
    @Temporal (TemporalType.DATE)
    private Date fechaCreacion;
    private Integer telefonoTienda;
    @ManyToMany(fetch = FetchType.EAGER)   
    @JoinTable(name="contiene", schema="CRUD_DATABASE", joinColumns = @JoinColumn(name="tiendas_cif", referencedColumnName="cif"),
            inverseJoinColumns = @JoinColumn(name="videojuegos_idVideojuego", referencedColumnName="idVideojuego"))
    private Set<VideojuegoEntity> videojuegos;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="tienda")
    private Set<CompraEntity> compras;

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNomTienda() {
        return nomTienda;
    }

    public void setNomTienda(String nomTienda) {
        this.nomTienda = nomTienda;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getTelefonoTienda() {
        return telefonoTienda;
    }

    public void setTelefonoTienda(Integer telefonoTienda) {
        this.telefonoTienda = telefonoTienda;
    }

    @XmlTransient
    public Set<VideojuegoEntity> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(Set<VideojuegoEntity> videojuego) {
        this.videojuegos = videojuego;
    }

    @XmlTransient
    public Set<CompraEntity> getCompras() {
        return compras;
    }

    public void setCompras(Set<CompraEntity> compra) {
        this.compras = compra;
    }

    public String getId() {
        return cif;
    }

    public void setId(String cif) {
        this.cif = cif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cif != null ? cif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiendaEntity)) {
            return false;
        }
        TiendaEntity other = (TiendaEntity) object;
        if ((this.cif == null && other.cif != null) || (this.cif != null && !this.cif.equals(other.cif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videojuegos.crud.entities.TiendaEntity[ cif=" + cif + " ]";
    }
    
}
