package dbms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class itemaddController implements Initializable {

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;

    @FXML
    private Label l6;

    @FXML
    private JFXTextField f1;

    @FXML
    private JFXTextField f11;
    
    @FXML
    private JFXTextField f2;

    @FXML
    private JFXTextField f3;

    @FXML
    private JFXTextField f4;

    @FXML
    private JFXButton b1;

    @FXML
    private JFXComboBox<String> cb2;
    
     @FXML
    private DatePicker datepick;
     
    @FXML
    private JFXComboBox<String> cb1;

    @FXML
    private Pane Pane1;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private ImageView Pane1Image;

    @FXML
    private Pane Pane2;

    void fill1() {
        List<String> list = new ArrayList<String>();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
            String str = "select * from category";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(rs.getString(1));

            }
            ObservableList obList = FXCollections.observableList(list);
            cb1.getItems().clear();
            cb1.setItems(obList);

            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    void fill2() {
        List<String> list1 = new ArrayList<String>();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
            String str = "select Dealer_Id from dealer";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list1.add(rs.getString(1));

            }
            ObservableList obList = FXCollections.observableList(list1);
            cb2.getItems().clear();
            cb2.setItems(obList);

            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public int check(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
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
    void handlebutton(ActionEvent event) {
        int c1 = check(f3.getText());
        int c2 = check(f4.getText());
        //System.out.println(c1 +" "+ c2);
        if (c1 == 0 ||c2 == 0 || f3.getText().equals("") || f4.getText().equals("") || f1.getText().equals("") || f2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter numeric value or Fields are empty ");

        } 
        else {
            int p = Integer.parseInt(f3.getText());
            int q = Integer.parseInt(f4.getText());
            try {
                String str = cb1.getSelectionModel().getSelectedItem();
                String str1 = cb2.getSelectionModel().getSelectedItem();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                String strr="select * from "+str+" where Company = '"+f1.getText()+"' and ProductName = '"+f2.getText()+"'";
                PreparedStatement stmt2=con.prepareStatement(strr);
                ResultSet rs=stmt2.executeQuery();
                if(rs.next()){
                    int w=rs.getInt(3);
                    w=w+p;
                    String strr1="update "+str+" set Quantity = "+w+" where Company = '"+f1.getText()+"' and ProductName = '"+f2.getText()+"'";
                    PreparedStatement stmt3=con.prepareStatement(strr1);
                    stmt3.executeUpdate();
                }
                else{
                String str2 = "insert into " + str + " values(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(str2);
                stmt.setString(1, f1.getText());
                stmt.setString(2, f2.getText());
                stmt.setInt(3, p);
                stmt.setInt(4, q);
                stmt.setString(5, str1);
                stmt.executeUpdate();
                }
                String str3 = "insert into purchased_item values(?,?,?,?,?,?,?)";
                PreparedStatement stmt1 = con.prepareStatement(str3);
                String s34=datepick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int p1=Integer.parseInt(f3.getText());
                int p2=Integer.parseInt(f4.getText());
                stmt1.setString(1, f11.getText());
                stmt1.setString(2, f1.getText());
                stmt1.setString(3, f2.getText());
                stmt1.setInt(4, p1);
                stmt1.setInt(5, p2);
                stmt1.setString(6, cb2.getSelectionModel().getSelectedItem());
                stmt1.setString(7, s34);
                stmt1.executeUpdate();
                
                con.close();
                JOptionPane.showMessageDialog(null, "Item Added");
                f1.setText("");
                f2.setText("");
                f3.setText("");
                f4.setText("");
                billid();
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
void billid(){
     try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
            String str = "select * from purchased_item";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String str2="SELECT Bill_Id FROM purchased_item ORDER BY Bill_Id DESC LIMIT 1";
                PreparedStatement stmt1=con.prepareStatement(str2);
                ResultSet rs1=stmt1.executeQuery();
                rs1.next();
                String p=rs1.getString(1);
                String s="";
                for(int i=1;i<p.length();i++){
                    s=s+""+p.charAt(i);
                }
                int b=Integer.parseInt(s);
                b++;
                s='B'+""+b;
                f11.setText(s);
            }
            else{
                f11.setText("B1000");
            }
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //hrow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        fill1();
        fill2();
        billid();
    }

}
