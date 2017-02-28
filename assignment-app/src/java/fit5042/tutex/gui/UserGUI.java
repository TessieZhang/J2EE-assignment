/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhangzhaoying
 */
public class UserGUI extends JFrame implements SalemanGUIInterface{
    private static final String[] TABLE_COLUMNS = {"User ID","Last name","First name","Email","Password","Type","Address","Phone number"};
    
     // Buttons
    private final JButton view;
    private final JButton add;
    private final JButton update;
    private final JButton delete;
    
    //Labels
    private final JLabel userId;
    private final JLabel lastName;
    private final JLabel firstName;
    private final JLabel email;
    private final JLabel password;
    private final JLabel type;
    private final JLabel address;
    private final JLabel phoneNumber;
    
    private final JTextField userIdTextField;
    private final JTextField lastNameTextField;
    private final JTextField firstNameTextField;
    private final JTextField emailTextField;
    private final JTextField passwordTextField;
    private final JTextField typeTextField;
    private final JTextField addressTextField;
    private final JTextField phoneNumberTextField;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    
    private final JTable infoTable;
    
    public UserGUI(ActionListener actionListener, ListSelectionListener listSelectionListener)
    {
        this.view = new JButton("view");
        this.add = new JButton("add");
        this.update = new JButton("Search by ModelNo");
        this.delete = new JButton("Search by Type");
        
        // create container
        Container container = this.getContentPane();
        
        this.userId = new JLabel("User id : ");
        this.lastName = new JLabel("Last name : ");
        this.firstName = new JLabel("First name : ");
        this.email = new JLabel("Email : ");
        this.password = new JLabel("Password : ");
        this.type = new JLabel("Type : ");
        this.address = new JLabel("Address : ");
        this.phoneNumber = new JLabel("Phone Number : ");
        
        this.userIdTextField = new JTextField();
        this.lastNameTextField = new JTextField();
        this.firstNameTextField = new JTextField();
        this.emailTextField = new JTextField();
        this.passwordTextField = new JTextField();
        this.typeTextField = new JTextField();
        this.addressTextField = new JTextField();
        this.phoneNumberTextField = new JTextField();
        
        // create the table
        this.infoTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.infoTable.getSelectionModel().addListSelectionListener(listSelectionListener); 
        
        //create the panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();
        
        //set the layout
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(8,2));
        this.buttonPanel.setLayout(new GridLayout(1,4));
        
        //add listener
        this.view.addActionListener(actionListener);
        this.add.addActionListener(actionListener);
        this.update.addActionListener(actionListener);
        this.delete.addActionListener(actionListener);
        
        this.inputPanel.add(userId);
        this.inputPanel.add(userIdTextField);
        this.inputPanel.add(lastName);
        this.inputPanel.add(lastNameTextField);
        this.inputPanel.add(firstName);
        this.inputPanel.add(firstNameTextField);
        this.inputPanel.add(email);
        this.inputPanel.add(emailTextField);
        this.inputPanel.add(password);
        this.inputPanel.add(passwordTextField);
        this.inputPanel.add(type);
        this.inputPanel.add(typeTextField);
        this.inputPanel.add(address);
        this.inputPanel.add(addressTextField);
        this.inputPanel.add(phoneNumber);
        this.inputPanel.add(phoneNumberTextField);
        
        this.buttonPanel.add(view);
        this.buttonPanel.add(add);
        this.buttonPanel.add(update);
        this.buttonPanel.add(delete);
        
        container.add(inputPanel,BorderLayout.NORTH);
        container.add(buttonPanel,BorderLayout.CENTER);
        container.add(new JScrollPane(this.infoTable), BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 680);       
        this.setVisible(true);
        
    }

}
