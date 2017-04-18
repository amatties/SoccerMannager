/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoccerManangerdb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "rental")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rental.findAll", query = "SELECT r FROM Rental r")
    , @NamedQuery(name = "Rental.findByIdRental", query = "SELECT r FROM Rental r WHERE r.idRental = :idRental")
    , @NamedQuery(name = "Rental.findByRentalDate", query = "SELECT r FROM Rental r WHERE r.rentalDate = :rentalDate")
    , @NamedQuery(name = "Rental.findByHour", query = "SELECT r FROM Rental r WHERE r.hour = :hour")
    , @NamedQuery(name = "Rental.findByFee", query = "SELECT r FROM Rental r WHERE r.fee = :fee")})
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rental")
    private Integer idRental;
    @Column(name = "rental_date")
    @Temporal(TemporalType.DATE)
    private Date rentalDate;
    @Column(name = "hour")
    @Temporal(TemporalType.TIME)
    private Date hour;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fee")
    private BigDecimal fee;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne
    private Client idClient;
    @JoinColumn(name = "id_court", referencedColumnName = "id_court")
    @ManyToOne
    private Court idCourt;

    public Rental() {
    }

    public Rental(Integer idRental) {
        this.idRental = idRental;
    }

    public Integer getIdRental() {
        return idRental;
    }

    public void setIdRental(Integer idRental) {
        this.idRental = idRental;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Court getIdCourt() {
        return idCourt;
    }

    public void setIdCourt(Court idCourt) {
        this.idCourt = idCourt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRental != null ? idRental.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rental)) {
            return false;
        }
        Rental other = (Rental) object;
        if ((this.idRental == null && other.idRental != null) || (this.idRental != null && !this.idRental.equals(other.idRental))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SoccerManangerdb.Rental[ idRental=" + idRental + " ]";
    }
    
}
