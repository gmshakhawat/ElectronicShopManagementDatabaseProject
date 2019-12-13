package dbms;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class QuantiyFXMLController  implements Initializable{

     static int p;
     static String q;
     static String r;
     static String s;
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private JFXComboBox<Integer> Quantitycombo;

    @FXML
    private Label Quantitylabel;

    @FXML
    private JFXButton removebutton;

    @FXML
    void removehandle(ActionEvent event) {
        int c=Quantitycombo.getSelectionModel().getSelectedItem();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
            String strr="Select * from "+q+" where Company = '"+r+"' and ProductName = '"+s+"'";
            PreparedStatement stmt1=con.prepareStatement(strr);
            ResultSet rs1=stmt1.executeQuery();
            rs1.next();
            int p=rs1.getInt(3);
            if(c==p){
                String str="delete from "+q+" where Company = '"+r+"' and ProductName = '"+s+"'";
                PreparedStatement stmt=con.prepareStatement(str);
                stmt.executeUpdate();
            }
            else{
                p=p-c;
                String str="update "+q+" set Quantity = "+p+" where Company = '"+r+"' and ProductName = '"+s+"' ";
                PreparedStatement stmt=con.prepareStatement(str);
                stmt.executeUpdate();
            }
            Stage stage=(Stage) removebutton.getScene().getWindow();
            stage.close();
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
    
        }
    }
    List<Integer> list = new ArrayList<Integer>();
    void fill(){
        for(int i=0;i<=p;i++){
            list.add(i);
        }
        ObservableList obList = FXCollections.observableList(list);
            Quantitycombo.getItems().clear();
            Quantitycombo.setItems(obList);
        
    }
    @Override
    
    
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        fill();
        System.out.println(p+" "+q+" "+r+" "+s);
    }

}
