package dbms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class MainLoginController implements Initializable {

    @FXML
    private JFXButton ForgotPassword;
    @FXML
    private JFXTextField UserName;

    @FXML
    private Pane BottomPane;

    @FXML
    private Pane TopPane;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private JFXPasswordField Password;

    @FXML
    private JFXButton LoginButton;

    @FXML
    void loginclicked(ActionEvent event) {
        try {
            int c = 0;
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
            String str = "select * from user";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery(str);
            rs.next();
            if (rs.getString(1).equals(UserName.getText()) && rs.getString(2).equalsIgnoreCase(Password.getText())) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminFXMLDocument.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                 Stage stage1 = (Stage) LoginButton.getScene().getWindow();

        stage1.close();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid User Name or Password");
            }
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
       
    }

    @FXML
    void ForgorPasswordAction(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Forgot Password");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
