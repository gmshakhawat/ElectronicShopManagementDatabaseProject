/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
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
public class PurchasesController implements Initializable {

    
    @FXML
    private JFXTextField PurchaseProductIdTextField;

    @FXML
    private Pane purchasesBottomPane;

    @FXML
    private JFXButton PurchaseDateButton;
    
    @FXML
    private TableColumn<Purchase_Table, String> CompanyCol;
    
    @FXML
    private TableColumn<Purchase_Table, String> QuantityCol;

    @FXML
    private TableColumn<Purchase_Table, String> PriceCol;

    @FXML
    private TableColumn<Purchase_Table, String> PurchaseProductNameCol;

    @FXML
    private JFXButton DealersButton;

    @FXML
    private Pane purchasesTopPane;
    
    @FXML
    private JFXButton RefreshButton;

    @FXML
    private TableColumn<Purchase_Table, String> PurchaseProductIdCol;

    @FXML
    private JFXButton PurchaseProductIdButton;

    @FXML
    private TableColumn<Purchase_Table, String> PurchaseDealerNameCol;

    @FXML
    private DatePicker PurchaseDate;

    @FXML
    private TableColumn<Purchase_Table, String> PurchaseDateCol;

    @FXML
    private AnchorPane PurchasesMainPane;

    @FXML
    private TableView<Purchase_Table> PurchaseTable;
    
    @FXML
    void RefreshAction(ActionEvent event) {
        ObservableList<Purchase_Table> data=FXCollections.observableArrayList();
        
        
        PurchaseProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Bid"));
        CompanyCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        PurchaseProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PurchaseDealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("PricePerPiece"));
        PurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        PurchaseTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from Purchased_Item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                 String k = rs.getString(6);
                 if(k==null)
                     k = "N.A.";
                data.add(new Purchase_Table(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getString(4)),String.valueOf(rs.getLong(5)),k,rs.getString(7)));
             }
             PurchaseTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

    @FXML
    void SearchByDateAction(ActionEvent event) {
        String d = String.valueOf(PurchaseDate.getValue());
        ObservableList<Purchase_Table> data=FXCollections.observableArrayList();
        
        
        PurchaseProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Bid"));
        CompanyCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        PurchaseProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PurchaseDealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("PricePerPiece"));
        PurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        PurchaseTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from Purchased_Item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                 if(rs.getString(7).equals(d)){
                     String k = rs.getString(6);
                 if(k==null)
                     k = "N.A.";
                data.add(new Purchase_Table(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getString(4)),String.valueOf(rs.getLong(5)),k,rs.getString(7)));
             
                 }
            }
             
             PurchaseTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

    @FXML
    void SearchByPidAction(ActionEvent event) {
        String d = String.valueOf(PurchaseProductIdTextField.getText());
        ObservableList<Purchase_Table> data=FXCollections.observableArrayList();
        
        
        PurchaseProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Bid"));
        CompanyCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        PurchaseProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PurchaseDealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("PricePerPiece"));
        PurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        PurchaseTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from Purchased_Item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                 if(rs.getString(1).equals(d)){
                     String k = rs.getString(6);
                 if(k==null)
                     k = "N.A.";
                data.add(new Purchase_Table(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getString(4)),String.valueOf(rs.getLong(5)),k,rs.getString(7)));
             
                 }
             }
             
             PurchaseTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

    @FXML
    void DealersAction(ActionEvent event) {
        try {
            
            Stage stage1 = (Stage)PurchasesMainPane.getScene().getWindow();
            stage1.hide();
            
            
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("Dealer.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Dealers");
            stage.setScene(new Scene(root1)); 
            stage.show();    
        } catch (IOException ex) {
            Logger.getLogger(PurchasesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Purchase_Table> data=FXCollections.observableArrayList();
        
        
        PurchaseProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Bid"));
        CompanyCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        PurchaseProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PurchaseDealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("PricePerPiece"));
        PurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        PurchaseTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from Purchased_Item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){String k = rs.getString(6);
                 if(k==null)
                     k = "N.A.";
                data.add(new Purchase_Table(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getString(4)),String.valueOf(rs.getLong(5)),k,rs.getString(7)));
             }
             PurchaseTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }    
    
}
