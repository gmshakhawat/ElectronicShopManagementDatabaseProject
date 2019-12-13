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
public class AddEmployeeController implements Initializable {
    
    
    @FXML
    private Pane AddEmpTopPane;
    
    @FXML
    private JFXButton SubmitButton;

    @FXML
    private Pane AddEmpBottomPane;

    @FXML
    private JFXTextField EmpMobNo;

    @FXML
    private JFXComboBox<String> EmpGenderDrop;

    @FXML
    private AnchorPane AddEmpMainPane;

    @FXML
    private JFXTextField EmpName;
    
    @FXML
    private JFXTextField EmpAdhaarNo;

    @FXML
    private JFXTextArea EmpAddr;

    @FXML
    private Label EmpGender;
    
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
        int c1 = check(EmpMobNo.getText());
        int c2 = check(EmpAdhaarNo.getText());
        int length  = EmpMobNo.getText().length();
        int length1 = EmpAdhaarNo.getText().length();
        if (c1 == 0 || length < 10 || length > 10 || c2 == 0 || length1 < 12 || length1 > 12 || EmpName.getText().equals("") || EmpAddr.getText().equals("") || String.valueOf(EmpGenderDrop.getValue()).equals("")) {
            JOptionPane.showMessageDialog(null, "Either Fields are empty or Number is Invalid");

        } 
        else {
            int t = 0;
            long p = Long.parseLong(EmpMobNo.getText());
            long q = Long.parseLong(EmpAdhaarNo.getText());
            System.out.println(q);
            try {
                String count;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                String str="select Tin_No from Dealer";
                PreparedStatement stmt5=con.prepareStatement(str);
                ResultSet rs=stmt5.executeQuery(str);
                while(rs.next()){
                    if(Long.parseLong(rs.getString(1))==q)
                        t=1;
                }
                if(t==0){
                    String str1 = "Select * FROM Employee ORDER BY Emp_ID DESC LIMIT 1";
                    PreparedStatement stmt1=con.prepareStatement(str1);
                    ResultSet res = stmt1.executeQuery(str1);
                    res.next();
                    count = res.getString(1);
                    String c = count.charAt(1)+""+count.charAt(2)+""+count.charAt(3);
                    int o = Integer.parseInt(c);
                    String k = "E"+String.valueOf(o+1);
                    String str2 = "insert into Employee " + " values(?,?,?,?,?,?)";
                    PreparedStatement stmt = con.prepareStatement(str2);
                    stmt.setString(1, k);
                    stmt.setString(2, EmpName.getText());
                    stmt.setString(3, String.valueOf(EmpGenderDrop.getValue()));
                    stmt.setString(4, EmpAddr.getText());
                    stmt.setLong(5, p);
                    stmt.setLong(6, q);
                    stmt.executeUpdate();
                    con.close();
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    EmpName.setText("");
                    EmpAddr.setText("");
                    EmpMobNo.setText("");
                    EmpAdhaarNo.setText("");
                    EmpGenderDrop.getSelectionModel().clearSelection();
                    Stage stage = (Stage)SubmitButton.getScene().getWindow();
                    stage.close();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Employee Adhaar No. Already Exist");
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
        EmpGenderDrop.setItems(options);
    }    
    
}
