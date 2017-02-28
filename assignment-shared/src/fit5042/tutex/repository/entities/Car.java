/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author zhangzhaoying
 */
@Entity
@NamedQueries({@NamedQuery(name = Car.GET_ALL_QUERY_NAME, query = "SELECT c FROM Car c")})
public class Car implements Serializable {
    public static final String GET_ALL_QUERY_NAME = "Car.getAll";

    public Car() {
    }

    public Car(int modelNo, String modelName, String manufacturer, String carType, String thumbnail, String description, String preUrl, Set<VINRecord> VIN) {
        this.modelNo = modelNo;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.carType = carType;
        this.thumbnail = thumbnail;
        this.description = description;
        this.preUrl = preUrl;
        this.VIN = VIN;
    }

   
    
    private int modelNo;

    /**
     * Get the value of modelNo
     *
     * @return the value of modelNo
     */
    @Id
    @Column(name = "model_no")
    public int getModelNo() {
        return modelNo;
    }

    /**
     * Set the value of modelNo
     *
     * @param modelNo new value of modelNo
     */
    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }
    
    private String modelName;

    /**
     * Get the value of modelName
     *
     * @return the value of modelName
     */
    @Column(name = "model_name")
    public String getModelName() {
        return modelName;
    }

    /**
     * Set the value of modelName
     *
     * @param modelName new value of modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    private String manufacturer;

    /**
     * Get the value of manufacturer
     *
     * @return the value of manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Set the value of manufacturer
     *
     * @param manufacturer new value of manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private String carType;

    /**
     * Get the value of carType
     *
     * @return the value of carType
     */
    @Column(name = "car_type")
    public String getCarType() {
        return carType;
    }

    /**
     * Set the value of carType
     *
     * @param carType new value of carType
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    private String thumbnail;

    /**
     * Get the value of thumbnail
     *
     * @return the value of thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Set the value of thumbnail
     *
     * @param thumbnail new value of thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    private String description;

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }
 
    private String preUrl;

    /**
     * Get the value of preUrl
     *
     * @return the value of preUrl
     */
    public String getPreUrl() {
        return preUrl;
    }

    /**
     * Set the value of preUrl
     *
     * @param preUrl new value of preUrl
     */
    public void setPreUrl(String preUrl) {
        this.preUrl = preUrl;
    }
    
    private Set<VINRecord> VIN;
    @OneToMany(mappedBy = "modelNo")
    public Set<VINRecord> getVINRecord() {
        return VIN;
    }

    public void setVINRecord(Set<VINRecord> VIN) {
        this.VIN = VIN;
    }

}
