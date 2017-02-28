/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.web;


import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.entities.Car;
import fit5042.tutex.repository.entities.Users;
import fit5042.tutex.repository.entities.VINRecord;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author zhangzhaoying
 * 
 */
@ManagedBean
@Named(value = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean implements Serializable {

    @EJB
    private PropertyRepository propertyRepository;
    
    int saleId = 0;
    private VINRecord vin;
    private Car tc;
    private String userName;
    private String payStatus;
    private List<Users> displaySalesman;
    private String message;
    private final SimpleDateFormat oFormat = new SimpleDateFormat("MM-dd-YYYY");

    public List<Users> getDisplaySalesman() {
        return displaySalesman;
    }

    public void setDisplaySalesman(List<Users> displaySalesman) {
        this.displaySalesman = displaySalesman;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * Creates a new instance of customerMB
     */
    public CustomerManagedBean() {
        this.vin = new VINRecord();
        this.tc = new Car();
    }
    
    public void setTc(Car temp)
    {
        tc = temp;
    }
    
    public Car getTc()
    {
        return tc;
    }
    
    public void setVin(VINRecord temp)
    {
        this.vin = temp;
    }
    
    public VINRecord getVin()
    {
        return vin;
    }
    
    public void buyCar(int carId,int salesmanId) throws Exception
    {
        Users user = this.propertyRepository.searchCus(VinRecordSaleManagedBean.userName);
        if (this.propertyRepository.validatePayStatus(user.getId())){
            message = "";
            saleId++;
            payStatus = "pending";
            this.propertyRepository.makeSale(oFormat.format(new Date()),this.propertyRepository.searchByIdCar(carId).getModelName(),user,salesmanId,payStatus);
        }
        else
            message = "You cannot buy another car";
    }
    
    public void showSalesman()
    {
        this.displaySalesman = this.propertyRepository.getAllSalesMan();
    }
    
}
