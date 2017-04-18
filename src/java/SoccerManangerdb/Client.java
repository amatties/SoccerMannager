/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoccerManangerdb;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient")
    , @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name")
    , @NamedQuery(name = "Client.findByAddress", query = "SELECT c FROM Client c WHERE c.address = :address")
    , @NamedQuery(name = "Client.findByCpf", query = "SELECT c FROM Client c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Client.findByLogin", query = "SELECT c FROM Client c WHERE c.login = :login")
    , @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password")
    , @NamedQuery(name = "Client.findByPrivilage", query = "SELECT c FROM Client c WHERE c.privilage = :privilage")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private Integer idClient;
    @Size(max = 150)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 13)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 45)
    @Column(name = "login")
    private String login;
    @Size(max = 10)
    @Column(name = "password")
    private String password;
    @Column(name = "privilage")
    private Character privilage;
    @JoinColumn(name = "id_account", referencedColumnName = "id_account")
    @ManyToOne
    private Account idAccount;
    @OneToMany(mappedBy = "idClient")
    private Collection<Rental> rentalCollection;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getPrivilage() {
        return privilage;
    }

    public void setPrivilage(Character privilage) {
        this.privilage = privilage;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
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
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SoccerManangerdb.Client[ idClient=" + idClient + " ]";
    }
    
}
