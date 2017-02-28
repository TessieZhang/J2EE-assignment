/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.web;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.entities.Users;
import fit5042.tutex.repository.entities.Sale;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author zhangzhaoying
 * 
 */
@ManagedBean
@Named(value = "salesmanBean")
@SessionScoped
public class salesmanBean implements Serializable {
    
    @EJB
    private PropertyRepository propertyRepository;

    private Users cus;
    private int cusId;
    private String cusLn;
    private String cusFn;
    private String mail;
    private String message;
    private List<Users> allcus;

    public Users getCus() {
        return cus;
    }

    public void setCus(Users cus) {
        this.cus = cus;
    }

    public List<Users> getAllcus() {
        return allcus;
    }

    public void setAllcus(List<Users> allcus) {
        this.allcus = allcus;
    }
    
    /**
     * Get the value of mail
     
     * @return the value of mail
     */

    public String getMail() {
        return mail;
    }

    /**
     * Set the value of mail
     *
     * @param mail new value of mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get the value of cusFn
     *
     * @return the value of cusFn
     */
    public String getCusFn() {
        return cusFn;
    }

    /**
     * Set the value of cusFn
     *
     * @param cusFn new value of cusFn
     */
    public void setCusFn(String cusFn) {
        this.cusFn = cusFn;
    }

    public salesmanBean() {
        this.cus = new Users();
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusLn() {
        return cusLn;
    }

    public void setCusLn(String cusLn) {
        this.cusLn = cusLn;
    }
    
    public void findOne()
    {
        cus = propertyRepository.searchCus(cusId,cusLn,cusFn,mail);
        if(cus != null)
            if(cus.getUserType().equals("customer"))
                message=(cus.getId()+" "+cus.getFirstName()+" "+cus.getLastName()+" "+cus.getEmail()+" "+cus.getUserType());
            else
                message="Sorry you do not have permission to check the salesman information";
        else
            message="Customer is not existed!";
    }   
    
    public List<Users> toCusList()
    {
        return propertyRepository.getAllCus();
    }
    
    public void deleteCus(int tempid)
    {
        propertyRepository.removeCus(tempid);
    }
    
    public void update()
    {
        propertyRepository.updateCus1(cus);
    }
    
    public void viewCus(int id)
    {
         cus = this.propertyRepository.searchCusId(id);
    }
    
    public List<Sale> displayAllOrder(){
        try{
            List<Sale> saleList  = propertyRepository.getAllOrder();
            return saleList;
        }catch(Exception e){
            return null;
        }         
    }
    
    public void updatePayStatus(int id) throws Exception{
        Sale sale = propertyRepository.searchById(id);
        sale.setPayStatus("complete");
        propertyRepository.updateOrder(sale);
    }
}
    

