/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panther
 */
public class ForgotPasswordController implements Initializable {
    
    @FXML
    private Pane pane1;

    @FXML
    private JFXTextField Answer;

    @FXML
    private ComboBox<String> SelectQuestion;

    @FXML
    private AnchorPane mainPane;
    
    String[] Q = new String[3];

    @FXML
    private JFXButton SubmitB;
    
    @FXML
    private JFXPasswordField NewPass;

    @FXML
    private JFXButton SetPass;

    @FXML
    private JFXPasswordField NewPass1;
    
    @FXML
    void SetPassAction(ActionEvent event) {
        String a = NewPass.getText();
        String b = NewPass1.getText();
        if(a.length()<6){
            JOptionPane.showMessageDialog(null, "Password must contain at least 6 characters");
        }
        else if(a.equals(b)==false){
            JOptionPane.showMessageDialog(null, "Passwords do not match");
        }
        else{
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="update user set Password  = '"+a+"'";
             PreparedStatement stmt=con.prepareStatement(str);
             stmt.executeUpdate(str);
             stmt.close();
             JOptionPane.showMessageDialog(null, "Password Changed");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
        Stage stage = (Stage) SetPass.getScene().getWindow();
        stage.close();
        }
    }

    @FXML
    void SubmitAction(ActionEvent event) {
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from Security";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
                while(rs.next()){
                    if(String.valueOf(SelectQuestion.getValue()).equalsIgnoreCase(rs.getString(1)) && Answer.getText().equalsIgnoreCase(rs.getString(2)))
                        SetPass.setDisable(false);
             }
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
        int i = 0;
        try{
            int c=0; 
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
             String str="select * from Security";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
                while(rs.next()){
                    Q[i] = rs.getString(1);
                    i++;
             }
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
        ObservableList<String> options = FXCollections.observableArrayList(Q[0],Q[1],Q[2]);
        SelectQuestion.setItems(options);
    }    
    
}
