/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panther
 */
public class EmployeeController implements Initializable {
    
    @FXML
    private TableColumn<Emp_Table,String> EmpNameCol;

    @FXML
    private TableView<Emp_Table> EmpTable;
    
    @FXML
    private JFXButton Refreshbutton;

    @FXML
    private AnchorPane EmpMAinPane;

    @FXML
    private TableColumn<Emp_Table,String > EmpAddrCol;

    @FXML
    private JFXButton RemoveEmpButton;

    @FXML
    private Pane EmpPaneBottom;

    @FXML
    private TableColumn<Emp_Table, String> EmpIdCol;

    @FXML
    private Pane EmpPaneTop;
    
    @FXML
    private TableColumn<Emp_Table, String> AdhaarCol;

    @FXML
    private JFXButton AddEmpButton;

    @FXML
    private TableColumn<Emp_Table, String> EmpGenderCol;
    
    @FXML
    private TableColumn<Emp_Table, String> EmpContact;
    
    @FXML
    void RefreshAction(ActionEvent event) {
        fill();
    }
    
    @FXML
    void AddEmpAction(ActionEvent event) {
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Add New Employee");
            stage.setScene(new Scene(root1)); 
            stage.show();    
        } catch (IOException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void RemEmpAction(ActionEvent event) {
        int Index = EmpTable.getSelectionModel().getSelectedIndex();
        Emp_Table selected = EmpTable.getSelectionModel().getSelectedItem();
        String  p = selected.getEid();
        if(Index<0){
            JOptionPane.showMessageDialog(null, "No Employee Selected");
        }
        else{
            try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datas","root","shakhawat");
             String str="Delete from Employee where Emp_ID = '"+p+"'";
             PreparedStatement stmt=con.prepareStatement(str);
             stmt.executeUpdate(str);
             stmt.close();
             EmpTable.getItems().remove(selected);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
        }
    }
    void fill(){
        ObservableList<Emp_Table> data=FXCollections.observableArrayList();
        
        
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
        EmpNameCol.setCellValueFactory(new PropertyValueFactory<>("Ename"));
        EmpGenderCol.setCellValueFactory(new PropertyValueFactory<>("Egender"));
        EmpAddrCol.setCellValueFactory(new PropertyValueFactory<>("Eaddr"));
        EmpContact.setCellValueFactory(new PropertyValueFactory<>("Econtact"));
        AdhaarCol.setCellValueFactory(new PropertyValueFactory<>("Eadhaar"));
        
        EmpTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from Employee";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                data.add(new Emp_Table(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),String.valueOf(rs.getLong(5)),String.valueOf(rs.getLong(6)))); 
             }
             EmpTable.setItems(data);
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
        
        fill();
    }    
    
}
