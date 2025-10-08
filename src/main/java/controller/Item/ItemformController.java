package controller.Item;

import controller.Customer.CustomerController;
import controller.Customer.CustomerService;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Item;

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

    @FXML
    void btnAddItemOnAction(ActionEvent event) {

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
    }

    public void btnGetDetailsOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }
}
