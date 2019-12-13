/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import com.jfoenix.controls.JFXComboBox;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Suyog Surana
 */
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

public class WarrantyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton add;

    @FXML
    private JFXTextField bill_id;

    @FXML
    private TableColumn<Warranty, String> col_date;

    @FXML
    private JFXButton search;

    @FXML
    private TableColumn<Warranty, String> col_prdct;

    @FXML
    private TableColumn<Warranty, String> col_billid;

    @FXML
    private TableColumn<Warranty, String> col_warranty;

    @FXML
    private Label label_prdct;

    @FXML
    private Label label_name;

    @FXML
    private Label label_date;

    @FXML
    private TableColumn<Warranty, String> col_owner;

    @FXML
    private JFXComboBox<String> drop_down;

    @FXML
    private TableView<Warranty> table;
    
    @FXML
    private JFXButton refresh;

    List<String> str = new ArrayList<String>();

    void fill() {
        str.add("Received");
        str.add("Sent");
        str.add("Return");
        ObservableList oblist = FXCollections.observableList(str);
        drop_down.getItems().clear();
        drop_down.setItems(oblist);
    }

    @FXML
    void OnMouseClick(ActionEvent event) throws ClassNotFoundException, SQLException {
        if ((JFXButton) event.getSource() == search) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                //String s1 = "select * from sold_item where bill_id " + "=" + "'" + bill_id.getText() + "'";
                String s1 = "select prdct_name,owner_name,date from warranty where bill_id = '" + bill_id.getText() + "'";
                // System.out.println(s1);
                java.sql.PreparedStatement stmt = con.prepareStatement(s1);
                //stmt.setString(1,bill_id.getText());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    label_prdct.setText(rs.getString("prdct_name"));
                    label_name.setText(rs.getString("owner_name"));
                    label_date.setText(rs.getString("date"));
                } else {
                    String s2 = "select * from sold_item where billid = '" + bill_id.getText() + "'";
                    // System.out.println(s1);
                    java.sql.PreparedStatement stmt1 = con.prepareStatement(s2);
                    ResultSet rs1 = stmt1.executeQuery();
                    if (rs1.next()) {
                        label_prdct.setText(rs1.getString(3));
                        label_name.setText(rs1.getString(5));
                        label_date.setText(rs1.getString(8));
                    } else {
                        JOptionPane.showMessageDialog(null, "Bill ID does not exist");
                        label_prdct.setText("");
                        label_name.setText("");
                        label_date.setText("");
                    }
                }
                con.close();
                add.setDisable(false);

            } catch (Exception e) {

            }

        }
        
        
        
    }
    @FXML
    void OnMouseClickRefresh(){
        //fill1();
    }
    @FXML
    void OnMouseClickAdd(ActionEvent event) throws ClassNotFoundException, SQLException {
        if ((JFXButton) event.getSource() == add) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                //String s1 = "select * from sold_item where bill_id " + "=" + "'" + bill_id.getText() + "'";
                String s1 = "select * from warranty where bill_id = '" + bill_id.getText() + "'";
                // System.out.println(s1);
                java.sql.PreparedStatement stmt = con.prepareStatement(s1);
                //stmt.setString(1,bill_id.getText());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String strr="update warranty set warranty = '"+drop_down.getSelectionModel().getSelectedItem()+"' where bill_id = '"+bill_id.getText()+"'" ;
                    PreparedStatement stmt1=con.prepareStatement(strr);
                    stmt1.executeUpdate();
                } 
                else {
                    String s2 = "insert into warranty values(?,?,?,?,?)";
                    // System.out.println(s1);
                    java.sql.PreparedStatement stmt1 = con.prepareStatement(s2);
                    stmt1.setString(1, bill_id.getText());
                    stmt1.setString(2, label_prdct.getText());
                    stmt1.setString(3, label_name.getText());
                    stmt1.setString(4, label_date.getText());
                    stmt1.setString(5, drop_down.getSelectionModel().getSelectedItem());
                    stmt1.executeUpdate();
                }
                con.close();
                add.setDisable(false);
                fill1();

            } catch (Exception e) {

            }
            
        }
    }

    void fill1() {
        ObservableList<Warranty> data = FXCollections.observableArrayList();
        col_billid.setCellValueFactory(new PropertyValueFactory<>("rid"));
        col_prdct.setCellValueFactory(new PropertyValueFactory<>("rproduct"));
        col_owner.setCellValueFactory(new PropertyValueFactory<>("rname"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("rdate"));
        col_warranty.setCellValueFactory(new PropertyValueFactory<>("rwarranty"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
            String str="select * from warranty";
            PreparedStatement stmt =con.prepareStatement(str);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                data.add(new Warranty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5)));
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
        fill1();
    }

}
