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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo Flecha.
 */
@NamedQueries({
    @NamedQuery(
            name="findNombreEmpresa", query="SELECT d FROM DesarrolladoraEntity d WHERE d.nomEmpresa = :nomEmpresa"
    )
})
@Entity
@Table(name="Desarrolladora", schema="CRUD_DATABASE")
@XmlRootElement
public class DesarrolladoraEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String cif;
    private String siglas, nomEmpresa, logo;
    private Integer telefonoDesarrolladora, numEmpleados;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @OneToMany(mappedBy="desarrolladora", fetch = FetchType.EAGER)
    private Set<VideojuegoEntity> videojuegos;

    public Set<VideojuegoEntity> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(Set<VideojuegoEntity> videojuegos) {
        this.videojuegos = videojuegos;
    }
    
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public Integer getTelefonoDesarrolladora() {
        return telefonoDesarrolladora;
    }

    public void setTelefonoDesarrolladora(Integer telefonoDesarrolladora) {
        this.telefonoDesarrolladora = telefonoDesarrolladora;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(Integer numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
        if (!(object instanceof DesarrolladoraEntity)) {
            return false;
        }
        DesarrolladoraEntity other = (DesarrolladoraEntity) object;
        if ((this.cif == null && other.cif != null) || (this.cif != null && !this.cif.equals(other.cif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videojuegos.crud.entities.Desarrolladora[ cif=" + cif + " ]";
    }
    
}
