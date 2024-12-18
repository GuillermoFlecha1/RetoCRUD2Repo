/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.crud.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asier del Campo, Guillermo Flecha y Andoni Garcia.
 */
@NamedQueries({
    @NamedQuery(
            name="ConsultaPrecio",
            query="SELECT v FROM Videojuego WHERE v.precio BETWEEN precioBajo AND precioAlto"
    ),
    @NamedQuery(
            name="ConsultaPegi",
            query="SELECT v FROM Videojuego WHERE v.pegi =: pegi"
    )
})
@Entity
@Table(name="Videojuego", schema="CRUD_DATABASE")
@XmlRootElement
public class VideojuegoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVideojuego;
    private String titulo, descripcion, foto;
    private Integer precio, pegi;
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;
    @Temporal (TemporalType.DATE)
    private Date fechaLanzamineto;
    @ManyToMany(mappedBy="videojuegos")
    private Set<PlataformaEntity> plataformas;
    @ManyToOne
    @JoinColumn(name="videojuegos")
    private DesarrolladoraEntity desarrolladora;
    @ManyToMany(mappedBy="videojuegos")
    private Set<TiendaEntity> tiendas;

    public Set<TiendaEntity> getTiendas() {
        return tiendas;
    }

    public void setTiendas(Set<TiendaEntity> tiendas) {
        this.tiendas = tiendas;
    }

    public Long getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Long idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getPegi() {
        return pegi;
    }

    public void setPegi(Integer pegi) {
        this.pegi = pegi;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public Date getFechaLanzamineto() {
        return fechaLanzamineto;
    }

    public void setFechaLanzamineto(Date fechaLanzamineto) {
        this.fechaLanzamineto = fechaLanzamineto;
    }

    @XmlTransient
    public Set<PlataformaEntity> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(Set<PlataformaEntity> plataformas) {
        this.plataformas = plataformas;
    }

    public DesarrolladoraEntity getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(DesarrolladoraEntity desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVideojuego != null ? idVideojuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VideojuegoEntity)) {
            return false;
        }
        VideojuegoEntity other = (VideojuegoEntity) object;
        if ((this.idVideojuego == null && other.idVideojuego != null) || (this.idVideojuego != null && !this.idVideojuego.equals(other.idVideojuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videojuegos.crud.entities.VideojuegosEntity[ id=" + idVideojuego + " ]";
    }
    
}
