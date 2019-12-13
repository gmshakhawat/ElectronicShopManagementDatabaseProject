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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Pranav
 */
public class AddCategoryFXMLDocumentController implements Initializable {

    @FXML
    private JFXButton CategoryButton;

    @FXML
    private JFXTextField CategoryText;

    @FXML
    private Label CategoryLabel;

    @FXML
    private Pane Pane1;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private ImageView Pane1Image;

    @FXML
    private Pane Pane2;

    @FXML
    void ButtonHandle(ActionEvent event) {
        if (CategoryText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Field Cannot be Empty");
        } else {
            try {

                String str1;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                str1 = "insert into category values(?)";
                PreparedStatement stmt = con.prepareStatement(str1);
                stmt.setString(1, CategoryText.getText());
                stmt.executeUpdate();
                String str2="create table "+CategoryText.getText()+"(Company varchar(40) NOT NULL,ProductName varchar(100) NOT NULL,Quantity int(3) NOT NULL,Pricepp int(7) NOT NULL,dealerid varchar(5),PRIMARY KEY(Company,ProductName),FOREIGN KEY (dealerid) REFERENCES dealer(Dealer_ID) ) ";
                PreparedStatement stmt1=con.prepareStatement(str2);
                stmt1.executeUpdate();
                JOptionPane.showMessageDialog(null, "Category Added");
                con.close();
                Stage stage = (Stage) CategoryButton.getScene().getWindow();
                
                stage.close();
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
