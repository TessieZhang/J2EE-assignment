/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author zhangzhaoying
 */
@Entity
@NamedQueries({@NamedQuery(name = VINRecord.GET_ALL_QUERY_NAME, query = "SELECT v FROM VINRecord v")})
public class VINRecord implements Serializable {
    public static final String GET_ALL_QUERY_NAME = "VINRecord.getAll";

    public VINRecord() {
        this.modelNo = new Car();
    }

    public VINRecord(String VIN, Car modelNo) {
        this.VIN = VIN;
    }
    
    private String VIN;

    /**
     * Get the value of VIN
     *
     * @return the value of VIN
     */
    @Id
    @Column(name = "Vin")
    public String getVIN() {
        return VIN;
    }

    /**
     * Set the value of VIN
     *
     * @param VIN new value of VIN
     */
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    private Car modelNo;

    /**
     * Get the value of modelNo
     *
     * @return the value of modelNo
     */
    @ManyToOne
    @JoinColumn(name = "modelNo")
    public Car getModelNo() {
        return modelNo;
    }

    /**
     * Set the value of modelNo
     *
     * @param modelNo new value of modelNo
     */
    public void setModelNo(Car modelNo) {
        this.modelNo = modelNo;
    }


}
