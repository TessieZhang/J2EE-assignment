/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Car;
import java.util.List;
import javax.ejb.Remote;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Zhaoying Zhang
 */
@Remote
public interface CustomerGUIInterface {
    
    public JButton getSmodelNo();
    
    public JButton getSmake();
    
    public JButton getSmodel();
    
    public JButton getSType();
    
    public JButton getView();

    public int getId();
    
    public void clearInput();
    
    public void clearinfoTable();
    
    public void displayAC(Car temp);

    public String getType1();

    public void displayACs(List<Car> temp);
    
    public String getMake1();
    
    public String getModel();
    
    //public void displayAll(List<Car> temp);
    
    public void displayCarDetails(List<Car> car);
    
    public void displayCarDetails(Car car);
    
    public String getSelectedCarMake();
    
    public String getSelectedCarModel();
    
    public void viewAC(Car tc);
    
    public JTable getInfo();
    
    public boolean isCarSelected();
    
    public void clearDetailTable();
   
    public void displayMessageInDialog(String message);
            
}
