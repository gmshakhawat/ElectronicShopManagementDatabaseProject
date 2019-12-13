/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panther
 */
public class AddDealerController implements Initializable {
    
    @FXML
    private Pane AddDealerBottomPane;

    @FXML
    private JFXComboBox<String> DealerGenderDrop;
    
    @FXML
    private JFXTextField DealerTinNo;

    @FXML
    private Pane AddDealerTopPane;
    
    @FXML
    private JFXButton SubmitButton;

    @FXML
    private AnchorPane AddDealerMainPane;

    @FXML
    private JFXTextArea DealerAddr;

    @FXML
    private JFXTextField DealerMobNo;

    @FXML
    private JFXTextField DealerName;

    @FXML
    private Label DealerGender;
    
    public int check(String s) {
        int c = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9') {
                c = 1;
            } else {
                c = 0;
                break;
            }
        }
        return c;
    }

    
    @FXML
    void SubmitAction(ActionEvent event) {
        int c1 = check(DealerMobNo.getText());
        int c2  = check(DealerTinNo.getText());
        int length  = DealerMobNo.getText().length();
        int length1 = DealerTinNo.getText().length();
        if (c1 == 0 || c2 == 0 || length < 10 || length > 10 || length1 < 11 || length1 > 11 || DealerName.getText().equals("") || DealerAddr.getText().equals("") || String.valueOf(DealerGenderDrop.getValue()).equals("")) {
            JOptionPane.showMessageDialog(null, "Either Fields are empty or Numbers are Invalid");

        } 
        else {
            long p = Long.parseLong(DealerMobNo.getText());
            long q = Long.parseLong(DealerTinNo.getText());
            int tt = 0;
            try {
                String count;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                String str="select Tin_No from dealer";
                PreparedStatement stmt5=con.prepareStatement(str);
                ResultSet rs=stmt5.executeQuery(str);
                while(rs.next()){
                    if(Long.parseLong(rs.getString(1))==q)
                        tt=1;
                }
                if(tt==0){
                    String str1 = "Select * FROM dealer ORDER BY Dealer_ID DESC LIMIT 1";
                    PreparedStatement stmt1=con.prepareStatement(str1);
                    ResultSet res = stmt1.executeQuery(str1);
                    res.next();
                    count = res.getString(1);
                    String c = count.charAt(1)+""+count.charAt(2)+""+count.charAt(3);
                    int o = Integer.parseInt(c);
                    String k = "D"+String.valueOf(o+1);
                    String str2 = "insert into dealer " + " values(?,?,?,?,?,?)";
                    PreparedStatement stmt = con.prepareStatement(str2);
                    stmt.setString(1, k);
                    stmt.setString(2, DealerName.getText());
                    stmt.setString(3, String.valueOf(DealerGenderDrop.getValue()));
                    stmt.setString(4, DealerAddr.getText());
                    stmt.setLong(5,p);
                    stmt.setLong(6,q);
                    stmt.executeUpdate();
                    con.close();
                    JOptionPane.showMessageDialog(null, "Dealer Added");
                    DealerName.setText("");
                    DealerAddr.setText("");
                    DealerMobNo.setText("");
                    DealerTinNo.setText("");
                    DealerGenderDrop.getSelectionModel().clearSelection();
                    Stage stage = (Stage)SubmitButton.getScene().getWindow();
                    stage.close();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Dealer Tin No Already Exist");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options = FXCollections.observableArrayList("Male","Female");
        DealerGenderDrop.setItems(options);
    }    
    
}
