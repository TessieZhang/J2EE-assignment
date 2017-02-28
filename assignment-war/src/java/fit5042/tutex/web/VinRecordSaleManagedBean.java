/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.web;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.entities.Car;
import fit5042.tutex.repository.entities.VINRecord;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author zhangzhaoying
 */
@ManagedBean
@Named(value = "carManagedBean")
@SessionScoped
public class VinRecordSaleManagedBean implements Serializable {

   @EJB
    private PropertyRepository propertyRepository;
    private VINRecord vins;
    public static String userName;
    private Car cars;
    private List<Car> displays;
    private String message;

    /**
     * Creates a new instance of VINSaleManagedBean
     */
    public VinRecordSaleManagedBean() {
        this.vins = new VINRecord();
        this.cars = new Car();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Car getCars() {
        return cars;
    }

    public void setCars(Car cars) {
        this.cars = cars;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Set the value of displays
     *
     * @param displays new value of displays
     */
    public void setDisplays(List<Car> displays) {
        this.displays = displays;
    }

    public List<Car> getDisplays() {
        return displays;
    }

    public VINRecord getVIN() {
        
        return vins;
    }

    public void setVIN(VINRecord vins) {
        this.vins = vins;
    }
    
    public List<VINRecord> displayAllVINs(){
        try{
            List<VINRecord> vinList  = propertyRepository.getAllCar();
            return vinList;
        }catch(Exception e){
            return null;
        }         
    }
    
    public void addVIN() {
        try{
            if (propertyRepository.validationVin(vins.getVIN()))
            {
                message = "";
                propertyRepository.addCar(vins);
            } else
                message = "VIN is invalid!!!!";
            
        } catch (Exception e) {}
    }
    
    public void addCar() throws Exception {
            propertyRepository.addCar(cars);
    }
    
    @PostConstruct
    public void init() 
    {
        userName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }
    
    public void viewCar(int modelNo) {
        try {
                cars = propertyRepository.searchByIdCar(modelNo);
        } catch (Exception ex) {
        }
    }
    
    public void viewVIN(String VIN) {
        try {
            vins = propertyRepository.searchById(VIN);
        } catch (Exception ex) {
            
        }
    }
    
    public void editCar() throws Exception 
    {
        propertyRepository.editCar(cars);
    }
    
    public void editVIN() throws Exception 
    {
        propertyRepository.editVIN(vins);
    }
    
    public void deleteVIN(String VIN) throws Exception 
    {
            propertyRepository.removeCar(VIN);
    }
    
    public void searchByMake()
    {
        setDisplays(propertyRepository.searchInfour(cars.getManufacturer(),"","",0));
    }
    
    public void searchByModel()
    {
        setDisplays(propertyRepository.searchInfour("",cars.getModelName(),"",0));
    }
    
    public void searchByNo()
    {
       setDisplays(propertyRepository.searchInfour("","","",cars.getModelNo()));
    }
    
    public void searchByType()
    {
       setDisplays(propertyRepository.searchInfour("","",cars.getCarType(),0));
    }

    public void search()
    {
        setDisplays(propertyRepository.SearchByAllItems(cars.getManufacturer(), cars.getModelName(), cars.getCarType(), cars.getModelNo()));
    }
    
}
