/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Car;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaoying Zhang
 */
public class CarSysGUI extends JFrame implements CustomerGUIInterface {
    
    private static final String[] TABLE_COLUMNS = {"Make","Model"};
    private static final String[] TABLE_COLUMNS2 = {"ModelNo","Make","Model","Type","Thumbnail","Description","PURL"};
    
    // Buttons
    private final JButton sMake;
    private final JButton sModel;
    private final JButton sModelNo;
    private final JButton sType;
    private final JButton sByAll;
    private final JButton viewbtn;
    
    //Labels
    private final JLabel lmake;
    private final JLabel lmodel;
    private final JLabel lmodelNo;
    private final JLabel ltype;
    private final JLabel lview;
    private final JLabel lview2;
    
    //textfield
    private final JTextField tfmake;
    private final JTextField tfmodel;
    private final JTextField tfmodelNo;
    private final JTextField tftype;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
   
    
    //Table
    private final JTable infoTable;
    private final JTable detailTable;
    
    public CarSysGUI(ActionListener actionListener, ListSelectionListener listSelectionListener)
    {
        // create buttons
        this.sMake = new JButton("Search By Make");
        this.sModel = new JButton("Search by Model");
        this.sModelNo = new JButton("Search by ModelNo");
        this.sType = new JButton("Search by Type");
        this.sByAll = new JButton("Seach by all");
        this.viewbtn = new JButton("View the details");
        
        // create container
        Container container = this.getContentPane();
        
        // create labels
        this.lmake = new JLabel("Make : ");
        this.lmodel = new JLabel("Model : ");
        this.lmodelNo = new JLabel("Model No : ");
        this.ltype = new JLabel("Type : ");
        this.lview = new JLabel("To view the details");
        this.lview2 = new JLabel("");
        
        //create textfield
        this.tfmake = new JTextField();
        this.tfmodel = new JTextField();
        this.tfmodelNo = new JTextField();
        this.tftype = new JTextField();
        
        // create the table
        this.infoTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.infoTable.getSelectionModel().addListSelectionListener(listSelectionListener);   
        
        
        this.detailTable = new JTable(new DefaultTableModel(TABLE_COLUMNS2, 0));
        
        //create the panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();
        
        //set the layout
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(5,3));
        this.buttonPanel.setLayout(new GridLayout(1,1));
        
        //add listener
        this.sMake.addActionListener(actionListener);
        this.sByAll.addActionListener(actionListener);
        this.sModel.addActionListener(actionListener);
        this.sModelNo.addActionListener(actionListener);
        this.sType.addActionListener(actionListener);
        this.viewbtn.addActionListener(actionListener);
        
        // add components
        this.inputPanel.add(lmake);
        this.inputPanel.add(tfmake);
        this.inputPanel.add(sMake);
        
        this.inputPanel.add(lmodel);
        this.inputPanel.add(tfmodel);
        this.inputPanel.add(sModel);
        
        this.inputPanel.add(lmodelNo);
        this.inputPanel.add(tfmodelNo);
        this.inputPanel.add(sModelNo);
        
        this.inputPanel.add(ltype);
        this.inputPanel.add(tftype);
        this.inputPanel.add(sType);
        
        this.inputPanel.add(lview);
        this.inputPanel.add(lview2);
        this.inputPanel.add(viewbtn);
        
        this.buttonPanel.add(new JScrollPane(this.infoTable));
        
        
        container.add(inputPanel,BorderLayout.NORTH);
        container.add(buttonPanel,BorderLayout.CENTER);
        container.add(new JScrollPane(this.detailTable), BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 680);       
        this.setVisible(true);
        
    }
    
    @Override
    public JButton getSmake()
    {
        return sMake;
    }
    
    @Override
    public JButton getSmodel()
    {
        return sModel;
    }
    
    @Override
    public JButton getSmodelNo()
    {
        return sModelNo;
    }
    
    @Override
    public JButton getSType()
    {
        return sType;
    }
    
    @Override
    public JButton getView()
    {
        return viewbtn;
    }
    
    @Override
    public int getId()
    {
        return Integer.parseInt(this.tfmodelNo.getText());
    }
    
    @Override
    public String getType1()
    {
        return this.tftype.getText();
    }
    
    @Override
    public String getMake1()
    {
        return this.tfmake.getText();
    }
    
    @Override
    public String getModel()
    {
        return this.tfmodel.getText();
    }
    
    @Override
    public void displayAC(Car temp)
    {
        this.clearinfoTable();
        this.clearInput();
        ((DefaultTableModel)this.infoTable.getModel()).addRow(new Object[]{temp.getManufacturer(),temp.getModelName()});
    }
    
    /*@Override
    public void displayAll(List<Car> temp)
    {
        this.clearinfoTable();
        this.clearInput();
        for(Car tc:temp)
        {
            ((DefaultTableModel)this.infoTable.getModel()).addRow(new Object[]{tc.getManufacturer(),tc.getModelName()});
        }
    }*/
    
     @Override
    public void displayCarDetails(List<Car> cars) { 
        
        this.clearinfoTable();
        this.clearInput();
        
        for (Car car : cars) {
            ((DefaultTableModel)this.infoTable.getModel()).addRow(new Object[]{car.getManufacturer(), 
                                                                               car.getModelName()});
        }
    }
    
    @Override
    public void displayCarDetails(Car car) {  
        this.clearinfoTable();
        this.clearInput();
        
        ((DefaultTableModel)this.infoTable.getModel()).addRow(new Object[]{car.getManufacturer(), 
                                                                               car.getModelName()}); 
    }
    @Override
    public void displayACs(List<Car> temp)
    {
        this.clearinfoTable();
        this.clearInput();
        for(Car tc:temp)
        {
            ((DefaultTableModel)this.infoTable.getModel()).addRow(new Object[]{tc.getManufacturer(),tc.getModelName()});
        }
    }
    
    @Override
    public void clearinfoTable() {   
        System.out.println("clean");
        int numberOfRow = this.infoTable.getModel().getRowCount();
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.infoTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }
    
    @Override
    public void clearDetailTable() {     
        int numberOfRow = this.detailTable.getModel().getRowCount();
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.detailTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }
    
    @Override
    public void clearInput() {
        
        this.tfmake.setText("");
        this.tfmodel.setText("");
        this.tfmodelNo.setText("");
        this.tftype.setText("");
    }
    
    @Override
    public String getSelectedCarMake(){
        int selectIndex = this.infoTable.getSelectedRow();
        String make1 = this.infoTable.getValueAt(selectIndex, 0).toString();
        return make1;
    }
    
    @Override
    public String getSelectedCarModel(){
        int selectIndex = this.infoTable.getSelectedRow();
        String model = this.infoTable.getValueAt(selectIndex, 1).toString();
        return model;
    }
    
    @Override
    public void viewAC(Car tc){
    //"ModelNo","Make","Model","Type","Thumbnail","Description","PURL"
     this.clearDetailTable();   
     ((DefaultTableModel)this.detailTable.getModel()).addRow(new Object[]{tc.getModelNo(),tc.getManufacturer(),tc.getModelName(),tc.getCarType(),tc.getThumbnail(),tc.getDescription(),tc.getPreUrl()});
            
    }   
    
    @Override
    public JTable getInfo()
    {
        return infoTable;
    }
    
    @Override 
    public boolean isCarSelected(){
        return (this.infoTable.getSelectedRow() >= 0);
    }
    
    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    
}
            
