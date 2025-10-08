package controller.Item;

import controller.Customer.CustomerController;
import controller.Customer.CustomerService;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Item;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemformController {

    @FXML
    private TableColumn colCode;

    @FXML
    private TableColumn colDes;

    @FXML
    private TableColumn colQty;

    @FXML
    private TableColumn colUnit;

    @FXML
    private TableView tblItem;

    @FXML
    private TextField txtCode;

    @FXML
    private TextArea txtDes;

    @FXML
    private TextField txtQTY;

    @FXML
    private TextField txtUnitPrice;

    ItemController itemController= new ItemController();
    @FXML
    void btnAddItemOnAction(ActionEvent event) throws SQLException {

        try {
            Connection connection=DBConnection.getInstance().getConnection();
            Item item=new Item(
                    txtCode.getText(),
                    txtDes.getText(),
                    Double.parseDouble(txtUnitPrice.getText()),
                    Integer.parseInt(txtQTY.getText())
            );
            if (itemController.addItem(item)) {
                new Alert(Alert.AlertType.INFORMATION, "Item Added Successfully!").show();
            } else  {
                new Alert(Alert.AlertType.ERROR, "Failed to Added Item!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnLoadOnAction(ActionEvent event) throws SQLException {
        ItemService itemService = new ItemController();

        List<Item> all = itemService.getDetails();

        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("des"));
        colUnit.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

        tblItem.setItems(FXCollections.observableArrayList(all));

    }


    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (itemController.deleteItem(txtCode.getText())) {
            new Alert(Alert.AlertType.INFORMATION, "Item Deleted Successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Delete Item!").show();
        }
    }

    public void btnGetDetailsOnAction(ActionEvent actionEvent) {
        Item item = itemController.getItem(txtCode.getText());
        if (item != null) {
            txtDes.setText(item.getDes());
            txtUnitPrice.setText(String.valueOf(item.getUnitPrice()));
            txtQTY.setText(String.valueOf(item.getQtyOnHand()));
        } else {
            new Alert(Alert.AlertType.WARNING, "Item Not Found!").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Item item=new Item(
                txtCode.getText(),
                txtDes.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQTY.getText())
        );
        if (itemController.updateItem(item)) {
            new Alert(Alert.AlertType.INFORMATION, "Item Updated Successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Update Item!").show();
        }
    }
}
