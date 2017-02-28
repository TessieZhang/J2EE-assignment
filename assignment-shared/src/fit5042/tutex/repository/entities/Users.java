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
@NamedQueries({@NamedQuery(name =Users.GET_ALL_QUERY_NAME, query = "SELECT u FROM Users u")})
public class Users implements Serializable {
    public static final String GET_ALL_QUERY_NAME = "Users.getAll";
    private int id;
    private Set<Sale> sales;

    public Users() {
    }

    public Users(int id, Set<Sale> sales, String lastName, String firstName, String email, String password, String userType, String address, int phoneNumber) {
        this.id = id;
        this.sales = sales;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

   
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    @Id
    @Column(name = "user_id")
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    private String userName;

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of lastName
     *
     * @param userName new value of lastName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    

    private String lastName;

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    private String userType;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    @Column(name = "type")
    public String getUserType() {
        return userType;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    private String address;

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    private int phoneNumber;

    /**
     * Get the value of phoneNumber
     *
     * @return the value of phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the value of phoneNumber
     *
     * @param phoneNumber new value of phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @OneToMany(mappedBy = "saleCusId")
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    
}
