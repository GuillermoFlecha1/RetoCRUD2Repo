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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andoni Garcia.
 */
@Entity
@Table(name="Plataforma", schema="CRUD_DATABASE")
@XmlRootElement
public class PlataformaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPlataforma;
    private Boolean lectorDisco;
    private String ram;
    private String almacenamiento;
    private String logo;
    @Temporal (TemporalType.DATE)
    private Date anioLanzamiento;
    private String nomPlataforma;
    private String nomEmpresa;
    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(name="pertenece", schema="CRUD_DATABASE", joinColumns = @JoinColumn(name="plataformas_idPlataforma", referencedColumnName="idPlataforma"),
            inverseJoinColumns = @JoinColumn(name="videojuegos_idVideojuego", referencedColumnName="idVideojuego"))
    private Set<VideojuegoEntity> videojuegos;

    public Set<VideojuegoEntity> getVideojuego() {
        return videojuegos;
    }

    public void setVideojuego(Set<VideojuegoEntity> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public Set<VideojuegoEntity> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(Set<VideojuegoEntity> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public Boolean getLectorDisco() {
        return lectorDisco;
    }

    public void setLectorDisco(Boolean lectorDisco) {
        this.lectorDisco = lectorDisco;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(Date anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getNomPlataforma() {
        return nomPlataforma;
    }

    public void setNomPlataforma(String nomPlataforma) {
        this.nomPlataforma = nomPlataforma;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlataforma != null ? idPlataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlataformaEntity)) {
            return false;
        }
        PlataformaEntity other = (PlataformaEntity) object;
        if ((this.idPlataforma == null && other.idPlataforma != null) || (this.idPlataforma != null && !this.idPlataforma.equals(other.idPlataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videojuegos.crud.entities.PlataformaEntity[ id=" + idPlataforma + " ]";
    }
    
}
