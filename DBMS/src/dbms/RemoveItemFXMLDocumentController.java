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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;

public class RemoveItemFXMLDocumentController implements Initializable {

    @FXML
    private TableColumn<Product1, Integer> TableQuantity;

    @FXML
    private TableColumn<Product1, String> TablePname;

    @FXML
    private Label SelectCategoryField;

    @FXML
    private TableView<Product1> productTable;

    @FXML
    private TableColumn<Product1, Integer> TablePrice;

    @FXML
    private TableColumn<Product1, String> TableDId;

    @FXML
    private JFXButton RemoveButton;

    @FXML
    private JFXButton search;

    @FXML
    private JFXButton refresh;
    
    @FXML
    private TableColumn<Product1, String> TableCname;

    @FXML
    private Pane Pane1;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private JFXComboBox<String> SelectProductCombo;

    @FXML
    private TableColumn<Product1, Integer> TableSno;

    @FXML
    private ImageView Pane1Image;

    @FXML
    private Pane Pane2;

    List<String> list = new ArrayList<String>();

    void fill1() {

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
            SelectProductCombo.getItems().clear();
            SelectProductCombo.setItems(obList);

            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    

    @FXML
    void button1(ActionEvent event) {
        String str1 = SelectProductCombo.getSelectionModel().getSelectedItem();
        ObservableList<Product1> data = FXCollections.observableArrayList();
        TableSno.setCellValueFactory(new PropertyValueFactory<>("rcoun"));
            TableCname.setCellValueFactory(new PropertyValueFactory<>("rcname"));
            TablePname.setCellValueFactory(new PropertyValueFactory<>("rname"));
            TableQuantity.setCellValueFactory(new PropertyValueFactory<>("rquantity"));
            TablePrice.setCellValueFactory(new PropertyValueFactory<>("rpricepp"));
            TableDId.setCellValueFactory(new PropertyValueFactory<>("rdealerid"));    
        if ((JFXButton) event.getSource() == search) {

            
            //productTable.setItems(data);
            try {
                int c = 0;

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                String str = "select * from " + str1 + "";
                PreparedStatement stmt = con.prepareStatement(str);
                ResultSet rs = stmt.executeQuery();
                System.out.println("h");
                while (rs.next()) {
                    data.add(new Product1(++c, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
                    //System.out.println(rs.getString(1));
                }

                productTable.setItems(data);
                //tableCategory.getColumns().addAll(col1,col2,col3);
                stmt.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        }
        if ((JFXButton) event.getSource() == RemoveButton) {
            int selectedIndex = productTable.getSelectionModel().getSelectedIndex();
            Product1 selected = productTable.getSelectionModel().getSelectedItem();
            QuantiyFXMLController.p=selected.getRquantity();
            QuantiyFXMLController.q=str1;
            QuantiyFXMLController.r=selected.getRcname();
            QuantiyFXMLController.s=selected.getRname();
            
            if (selectedIndex < 0) {
                JOptionPane.showMessageDialog(null, "No row Selected");
            } else {
                    try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuantiyFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

            }
        }
        if((JFXButton)event.getSource()==refresh){
            try {
                int c = 0;

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                String str = "select * from " + str1 + "";
                PreparedStatement stmt = con.prepareStatement(str);
                ResultSet rs = stmt.executeQuery();
                System.out.println("h");
                while (rs.next()) {
                    data.add(new Product1(++c, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
                    //System.out.println(rs.getString(1));
                }

                productTable.setItems(data);
                //tableCategory.getColumns().addAll(col1,col2,col3);
                stmt.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        fill1();
    }

}
