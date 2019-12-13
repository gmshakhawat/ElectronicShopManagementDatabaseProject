/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panther
 */
public class BillsController implements Initializable {
    
    @FXML
    private TableView<Bills_table> BillsTable;

    @FXML
    private TableColumn<Bills_table, String> BillsContactCol;

    @FXML
    private TableColumn<Bills_table, String> BillsProductNameCol;

    @FXML
    private TableColumn<Bills_table, String> BillsCustomerAddrCol;

    @FXML
    private Pane BillsTopPane;
    
    @FXML
    private JFXButton RefreshButton;    

    @FXML
    private JFXTextField ProductIdTextField;
    
    @FXML
    private DatePicker BillsDate;

    @FXML
    private TableColumn<Bills_table, String> BillsProductIdCol;
    
    @FXML
    private TableColumn<Bills_table, String> EmpIdCol;

    @FXML
    private JFXButton DateButton;

    @FXML
    private JFXButton ProductIdButton;

    @FXML
    private Pane BillsBottomPane;

    @FXML
    private AnchorPane BillsMainPane;

    @FXML
    private TableColumn<Bills_table, String> BillsDateCol;

    @FXML
    private TableColumn<Bills_table, String> BillsCustomerNameCol;
    
    @FXML
    void RefreshAction(ActionEvent event) {
        ObservableList<Bills_table> data=FXCollections.observableArrayList();
        
        
        BillsProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Pid"));
        BillsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        BillsCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        BillsCustomerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Caddr"));
        BillsContactCol.setCellValueFactory(new PropertyValueFactory<>("Ccontact"));
        BillsDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
       
        BillsTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from sold_item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
   
             while(rs.next()){
                 String k = rs.getString(10);
                 String s=rs.getString(2);
                 String p=rs.getString(3);
                 s=s+"-"+p;
                 if(k==null)
                     k = "N.A.";
                data.add(new Bills_table(rs.getString(1),s,rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),k));  
             
             }
             
             BillsTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }
    
    @FXML
    void SearchByIdAction(ActionEvent event) {
        String d = String.valueOf(ProductIdTextField.getText());
        ObservableList<Bills_table> data=FXCollections.observableArrayList();
        
        
        BillsProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Pid"));
        BillsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        BillsCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        BillsCustomerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Caddr"));
        BillsContactCol.setCellValueFactory(new PropertyValueFactory<>("Ccontact"));
        BillsDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
        
        BillsTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from sold_item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                if(String.valueOf(rs.getString(1)).equals(d)){
                    String k = rs.getString(10);
                 if(k==null)
                     k = "N.A.";
                data.add(new Bills_table(rs.getString(1),rs.getString(2)+"-"+rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),k));  
             
                }
             }
             
             BillsTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }

    }
    
    @FXML
    void SearchByDateAction(ActionEvent event) {
        LocalDate l = BillsDate.getValue();
        String d = String.valueOf(l);
        ObservableList<Bills_table> data=FXCollections.observableArrayList();
        
        
        BillsProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Pid"));
        BillsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        BillsCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        BillsCustomerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Caddr"));
        BillsContactCol.setCellValueFactory(new PropertyValueFactory<>("Ccontact"));
        BillsDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
      
        BillsTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from sold_item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                if(String.valueOf(rs.getString(8)).equals(d)){
                    String k = rs.getString(10);
                 if(k==null)
                     k = "N.A.";
                data.add(new Bills_table(rs.getString(1),rs.getString(2)+"-"+rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),k));  
             
                }
             }
             
             BillsTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Bills_table> data=FXCollections.observableArrayList();
        
        
        BillsProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Pid"));
        BillsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        BillsCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        BillsCustomerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Caddr"));
        BillsContactCol.setCellValueFactory(new PropertyValueFactory<>("Ccontact"));
        BillsDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
       
        BillsTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from sold_item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                 String k = rs.getString(10);
                 if(k==null)
                     k = "N.A.";
                data.add(new Bills_table(rs.getString(1),rs.getString(2)+"-"+rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),k));  
             }
             
             BillsTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }    
    
}
