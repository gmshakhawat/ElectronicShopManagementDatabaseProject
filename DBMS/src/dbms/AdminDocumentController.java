package dbms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Suyog Surana
 */
public class AdminDocumentController implements Initializable {
    
   @FXML
    private Label l1;

    @FXML
    private ImageView bi2;

    @FXML
    private ImageView bi1;

    @FXML
    private ImageView bi4;

    @FXML
    private ImageView bi3;

    @FXML
    private ImageView bi6;

    @FXML
    private Button b1;

    @FXML
    private ImageView bi5;

    @FXML
    private Button b2;

    @FXML
    private ImageView bi8;

    @FXML
    private Button b3;

    @FXML
    private ImageView bi7;

    @FXML
    private Button b4;

    @FXML
    private JFXButton logout;

    @FXML
    private Button b5;

    @FXML
    private ImageView bi9;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private ImageView li1;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    void buttonhandle1(ActionEvent event) {
           try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProductFXMLDocument.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandle2(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CategoryFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandle3(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ItemFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandle4(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandle5(ActionEvent event) {
           try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Bills1.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandle6(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Purchases.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandle7(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Bills.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandle8(ActionEvent event) {
         try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Warranty.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandle9(ActionEvent event) {
         try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Payment.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void buttonhandlelogout(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainLogin.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage stage=(Stage)logout.getScene().getWindow();
            stage.close();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
