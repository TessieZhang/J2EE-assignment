/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex;

import fit5042.tutex.gui.CustomerGUIInterface;
import fit5042.tutex.gui.CarSysGUI;
import fit5042.tutex.repository.entities.Car;
import fit5042.tutex.repository.PropertyRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.ejb.EJB;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zhaoying Zhang
 */
public class CarSaleSystem implements ActionListener, ListSelectionListener {
    
    @EJB
    private static PropertyRepository propertyRepository;


    private String name;
    private CustomerGUIInterface gui;
    String make;
    String model;

    public CarSaleSystem(String name) throws Exception {
        this.name = name;
    }

    public void initView() {
        this.gui = new CarSysGUI(this, this);
        
        this.displayAllCar();
        //this.displayAllContactPeople();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       
        if (e.getSource() == gui.getSmake()) {
            this.searchByMake();
        } else if(e.getSource() == gui.getSmodel()){
            this.searchByModel();
        }else if(e.getSource() == gui.getSmodelNo()){
            this.searchByModelNo();
        }else if(e.getSource() == gui.getSType()){
            this.searchByType();
        }else if(e.getSource() == gui.getView()){
            this.view();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if ((event.getSource() == this.gui.getInfo().getSelectionModel())
            && (! event.getValueIsAdjusting()))
        {
            try
            {
                if (this.gui.isCarSelected()) {
                    make = this.gui.getSelectedCarMake();
                    model = this.gui.getSelectedCarModel();
                }               
            }
            catch (Exception e)
            {
                //gui.displayMessageInDialog(e.getMessage());
            }
        }
        
    }
    
    

    private void displayAllCar() {
        try {
            List<Car> cars = propertyRepository.getSearchCar();
            
            if (cars != null) {
                this.gui.displayCarDetails(cars);
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve cars: " + ex.getMessage());
        }
    }
    
    public void searchByModelNo() {
        try {
            int no;
            no = this.gui.getId();
            Car car = propertyRepository.searchByIdCar(no);
            if (car != null) {
                this.gui.displayCarDetails(car);
            } else {
                this.gui.displayMessageInDialog("No matched cars found");
                this.gui.clearDetailTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve cars: " + ex.getMessage());
        }
    }
    
    public void searchByType(){
        try {
            String type;
            type = this.gui.getType1();
            List<Car> car = propertyRepository.searchByType(type);
            
            if (car != null && !car.isEmpty()) {
                this.gui.displayCarDetails(car);
                
            } else {
                this.gui.displayMessageInDialog("No matched cars found");
                this.gui.clearDetailTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve cars: " + ex.getMessage());
        }
    }
    
    public void searchByMake(){
        try {
            String make;
            make = this.gui.getMake1();
            List<Car> car = propertyRepository.searchByMake(make);
            if (car != null && !car.isEmpty()) {
                this.gui.displayCarDetails(car);
            } else {
                this.gui.displayMessageInDialog("No matched cars found");
                this.gui.clearDetailTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve cars: " + ex.getMessage());
        }
    }
    
    public void searchByModel()
    {
        try {
            String model;
            model = this.gui.getModel();
            List<Car> car = propertyRepository.searchByModel(model);
            if (car != null && !car.isEmpty()) {
                this.gui.displayCarDetails(car);
            } else {
                this.gui.displayMessageInDialog("No matched cars found");
                this.gui.clearDetailTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve cars: " + ex.getMessage());
        }
    }
    
    public void view()
    {
        
        Car tc = propertyRepository.searchByMM(make, model);
        this.gui.viewAC(tc);
    }

    public static void main(String[] args) {
        try {
            final CarSaleSystem sale = new CarSaleSystem("Car Sale System");
            //JDK 1.7
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    sale.initView();
                }
            });
           
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }

}
