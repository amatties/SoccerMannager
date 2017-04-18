/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoccerManangerdb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "court")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Court.findAll", query = "SELECT c FROM Court c")
    , @NamedQuery(name = "Court.findByIdCourt", query = "SELECT c FROM Court c WHERE c.idCourt = :idCourt")
    , @NamedQuery(name = "Court.findByType", query = "SELECT c FROM Court c WHERE c.type = :type")
    , @NamedQuery(name = "Court.findByPrice", query = "SELECT c FROM Court c WHERE c.price = :price")
    , @NamedQuery(name = "Court.findByName", query = "SELECT c FROM Court c WHERE c.name = :name")})
public class Court implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_court")
    private Integer idCourt;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idCourt")
    private Collection<Rental> rentalCollection;

    public Court() {
    }

    public Court(Integer idCourt) {
        this.idCourt = idCourt;
    }

    public Integer getIdCourt() {
        return idCourt;
    }

    public void setIdCourt(Integer idCourt) {
        this.idCourt = idCourt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Rental> getRentalCollection() {
        return rentalCollection;
    }

    public void setRentalCollection(Collection<Rental> rentalCollection) {
        this.rentalCollection = rentalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCourt != null ? idCourt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Court)) {
            return false;
        }
        Court other = (Court) object;
        if ((this.idCourt == null && other.idCourt != null) || (this.idCourt != null && !this.idCourt.equals(other.idCourt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SoccerManangerdb.Court[ idCourt=" + idCourt + " ]";
    }
    
}
