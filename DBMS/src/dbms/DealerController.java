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
public class DealerController implements Initializable {
    
    @FXML
    private TableColumn<Dealer_Table, String> DealerGenderCol;

    @FXML
    private Pane RemDealerTopPane;
    
    @FXML
    private TableColumn<Dealer_Table, String> TinCol;

    @FXML
    private JFXButton AddDealerButton;
    
    @FXML
    private TableView<Dealer_Table> DealerTable;

    @FXML
    private TableColumn<Dealer_Table, String> DealerNameCol;

    @FXML
    private JFXButton RemoveDealerButton;
    
    @FXML
    private JFXButton Refresh;

    @FXML
    private AnchorPane RemDealerMainPane;

    @FXML
    private TableColumn<Dealer_Table, String> DealerAddrCol;

    @FXML
    private TableColumn<Dealer_Table, String> DealerIdCol;

    @FXML
    private TableColumn<Dealer_Table, String> DealerContact;

    @FXML
    private Pane RemDealerBottomPane;
    
     @FXML
    void AddDealerAction(ActionEvent event) {
        try {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("AddDealer.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Add A New Dealer");
            stage.setScene(new Scene(root1)); 
            stage.show();    
        } catch (IOException ex) {
            Logger.getLogger(DealerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void RemDealerAction(ActionEvent event) {
        int Index = DealerTable.getSelectionModel().getSelectedIndex();
        Dealer_Table selected = DealerTable.getSelectionModel().getSelectedItem();
        String  p = selected.getDid();
        if(Index<0){
            JOptionPane.showMessageDialog(null, "No Dealer Selected");
        }
        else{
            try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="Delete from Dealer where Dealer_ID = '"+p+"'";
             PreparedStatement stmt=con.prepareStatement(str);
             stmt.executeUpdate(str);
             stmt.close();
             DealerTable.getItems().remove(selected);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
        }
    }
    @FXML
    void Refresh(ActionEvent event) {
         fill();
    }
    void fill(){
        ObservableList<Dealer_Table> data=FXCollections.observableArrayList();
        
        
        DealerIdCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        DealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Dname"));
        DealerGenderCol.setCellValueFactory(new PropertyValueFactory<>("Dgender"));
        DealerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Daddr"));
        DealerContact.setCellValueFactory(new PropertyValueFactory<>("Dcontact"));
        TinCol.setCellValueFactory(new PropertyValueFactory<>("Tin"));
        
        DealerTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from Dealer";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                data.add(new Dealer_Table(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),String.valueOf(rs.getLong(5)),String.valueOf(rs.getLong(6))));
             }
             DealerTable.setItems(data);
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
