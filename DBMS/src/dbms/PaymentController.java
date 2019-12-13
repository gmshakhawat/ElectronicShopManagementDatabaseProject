/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Suyog Surana
 */
public class PaymentController implements Initializable {

    @FXML
    private JFXButton search;

    @FXML
    private JFXTextField text_payment;

    @FXML
    private JFXTextField text_bill;

    @FXML
    private ComboBox<String> sort;
    
    @FXML
    private TableColumn<Payment,String> col_bill;

    @FXML
    private TableColumn<Payment,String> col_trid;

    @FXML
    private TableView<Payment> table;

    @FXML
    private TableColumn<Payment,String> col_paymode;
    
     @FXML
    private JFXButton searchID;
     
     
    
     @FXML
    void OnClick(ActionEvent event) throws ClassNotFoundException, SQLException{
         if ((JFXButton) event.getSource() == search) {
            try {
                ObservableList<Payment> data = FXCollections.observableArrayList();
                 col_bill.setCellValueFactory(new PropertyValueFactory<>("rid"));
                 col_paymode.setCellValueFactory(new PropertyValueFactory<>("rpay"));
                 //col_trid.setCellValueFactory(new PropertyValueFactory<>("rtrx"));
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                 String str = "select * from payment where payment_mode='" + text_payment.getText() + "'";
                 PreparedStatement stmt = con.prepareStatement(str);
                 ResultSet rs = stmt.executeQuery();
                 if(rs.next()){
                       data.add(new Payment(rs.getString(1),rs.getString(2)));
                 }
                  table.setItems(data);
            }
            catch (ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            //fill();
         }
    }
     @FXML
    void OnClickbill(ActionEvent event) {
        if ((JFXButton) event.getSource() == searchID) {
            try {
                ObservableList<Payment> data = FXCollections.observableArrayList();
                 col_bill.setCellValueFactory(new PropertyValueFactory<>("rid"));
                 col_paymode.setCellValueFactory(new PropertyValueFactory<>("rpay"));
                 //col_trid.setCellValueFactory(new PropertyValueFactory<>("rtrx"));
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                 String str = "select * from payment where bill_id='" + text_bill.getText() + "'";
                 PreparedStatement stmt = con.prepareStatement(str);
                 ResultSet rs = stmt.executeQuery();
                 if(rs.next()){
                       data.add(new Payment(rs.getString(1),rs.getString(2)));
                 }
                  table.setItems(data);
            }
            catch (ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            //fill();
         }

    }

   void fill(){
        ObservableList<Payment> data = FXCollections.observableArrayList();
        col_bill.setCellValueFactory(new PropertyValueFactory<>("rid"));
        col_paymode.setCellValueFactory(new PropertyValueFactory<>("rpay"));
        //col_trid.setCellValueFactory(new PropertyValueFactory<>("rtrx"));
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
            String str="select * from payment";
            PreparedStatement stmt =con.prepareStatement(str);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                data.add(new Payment(rs.getString(1),rs.getString(2)));
            }
            table.setItems(data);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        table.setItems(data);
        
    }
        
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fill();
    }    
    
}
