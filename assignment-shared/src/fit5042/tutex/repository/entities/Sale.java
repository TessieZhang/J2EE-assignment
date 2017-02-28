/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import fit5042.tutex.repository.entities.Car;
import fit5042.tutex.repository.entities.Users;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author zhangzhaoying
 */
@Entity
@NamedQueries({@NamedQuery(name = Sale.GET_ALL_QUERY_NAME, query = "SELECT s FROM Sale s")})
public class Sale implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Sale.getAll";
    
    private int saleId;

    public Sale() {
    }

    public Sale(int saleId, Users saleCusId, String saleDate, String saleCar, int salePerson, String payStatus) {
        this.saleId = saleId;
        this.saleCusId = saleCusId;
        this.saleDate = saleDate;
        this.saleCar = saleCar;
        this.salePerson = salePerson;
        this.payStatus = payStatus;
        this.tags = tags;
    }

    /**
     * Get the value of saleId
     *
     * @return the value of saleId
     */
    @Id
    @Column(name = "saleId")
    public int getSaleId() {
        return saleId;
    }

    /**
     * Set the value of saleId
     *
     * @param saleId new value of saleId
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    private Users saleCusId;

    /**
     * Get the value of saleCusId
     *
     * @return the value of saleCusId
     */
    @ManyToOne
    @JoinColumn(name = "saleCusId")
    public Users getSaleCusId() {
        return saleCusId;
    }

    /**
     * Set the value of saleCusId
     *
     * @param saleCusId new value of saleCusId
     */
    public void setSaleCusId(Users saleCusId) {
        this.saleCusId = saleCusId;
    }

    private String saleDate;

    /**
     * Get the value of saleDate
     *
     * @return the value of saleDate
     */
    public String getSaleDate() {
        return saleDate;
    }

    /**
     * Set the value of saleDate
     *
     * @param saleDate new value of saleDate
     */
    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    private String saleCar;

    /**
     * Get the value of saleDetail
     *
     * @return the value of saleDetail
     */
    
    
    public String getSaleCar() {
        return saleCar;
    }

    /**
     * Set the value of saleDetail
     *
     * @param saleCar new value of saleDetail
     */
    public void setSaleCar(String saleCar) {
        this.saleCar = saleCar;
    }

    private int salePerson;

    /**
     * Get the value of salePerson
     *
     * @return the value of salePerson
     */
    
    public int getSalePerson() {
        return salePerson;
    }

    /**
     * Set the value of salePerson
     *
     * @param salePerson new value of salePerson
     */
    public void setSalePerson(int salePerson) {
        this.salePerson = salePerson;
    }
    
        private String payStatus;

    /**
     * Get the value of payStatus
     *
     * @return the value of payStatus
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * Set the value of payStatus
     *
     * @param payStatus new value of payStatus
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    
    private Set<String> tags;
    
    @ElementCollection
    @CollectionTable(name = "tag")
    @Column(name = "value")
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

}
