package dbms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import dbms.Category1;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class CategoryFXMLController implements Initializable {

    @FXML
    private TableView<Category1> tableCategory;

    @FXML
    private TableColumn<Category1, String> col2;

    @FXML
    private TableColumn<Category1, String> col3;

    @FXML
    private JFXButton remove;

    @FXML
    private JFXButton refresh;
    @FXML
    private JFXButton addCategory;

    @FXML
    private TableColumn<Category1, String> col1;

    @FXML
    public void ButtonHandleAction(ActionEvent event) {
        if ((JFXButton) event.getSource() == addCategory) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCategoryFXMLDocument.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if ((JFXButton) event.getSource() == remove) {
            int selectedIndex = tableCategory.getSelectionModel().getSelectedIndex();
            Category1 selected = tableCategory.getSelectionModel().getSelectedItem();
            if (selectedIndex < 0) {
                JOptionPane.showMessageDialog(null, "No row Selected");
            } else {
                try {
                    String str2;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
                    String str = "select * from " + selected.getRname() + " ";
                    System.out.println(selected.getRname());
                    PreparedStatement stmt = con.prepareStatement(str);
                    ResultSet rs = stmt.executeQuery();
                    System.out.println("hello");
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Selected Category is not empty");
                    } else {
                        if (selectedIndex >= 0) {
                        tableCategory.getItems().remove(selectedIndex);
                        String str1 = "delete from category where category = '" + selected.getRname() + "'";
                        str2 = "drop table " + selected.getRname() + " ";
                        PreparedStatement stmt1 = con.prepareStatement(str1);
                        PreparedStatement stmt2 = con.prepareStatement(str2);
                        stmt1.executeUpdate();
                        stmt2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Category Removed");
                        
                        }
                    }
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        } else if ((JFXButton) event.getSource() == refresh) {
            fill();
        }

    }

    public void fill() {
        ObservableList<Category1> data = FXCollections.observableArrayList();

        col1.setCellValueFactory(new PropertyValueFactory<>("rcoun"));
        col2.setCellValueFactory(new PropertyValueFactory<>("rname"));
        col3.setCellValueFactory(new PropertyValueFactory<>("rquantity"));
        // System.out.println("hello");

        tableCategory.setItems(data);

        try {
            int c = 0,sum;
            String str1;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=india123");
            String str = "select * from category";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();
            System.out.println("h");
            while (rs.next()) {
                sum=0;
                str1="select SUM(Quantity) from "+rs.getString(1)+"";
                stmt=con.prepareStatement(str1);
                ResultSet rs1=stmt.executeQuery();
                if(rs1.next()){
                    sum=rs1.getInt(1);
                }
                System.out.println(sum);
                data.add(new Category1(++c, rs.getString(1), sum));
                //System.out.println(rs.getString(1));
            }

            tableCategory.setItems(data);
            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fill();
    }

}
