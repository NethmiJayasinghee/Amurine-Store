package controller.Customer;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public  class CustomerFormController implements Initializable {

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colSalary;

    @FXML
    private TableView tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

   CustomerController customerController= new CustomerController();
    @FXML
    void btnAddCustomerOnAction(ActionEvent event) throws SQLException {
        Connection connection=DBConnection.getInstance().getConnection();
        Customer customer=new Customer(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );


        if (customerController.addCustomer(customer)) {
            new Alert(Alert.AlertType.INFORMATION, "Customer Added Successfully!").show();
        } else  {
            new Alert(Alert.AlertType.ERROR, "Failed to Added Customer!").show();
        }

    }
    CustomerService customerService=new CustomerController();
    @FXML
    void btnReloadOnAction(ActionEvent event) throws SQLException {
        List<Customer> all=customerService.getAll();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tblCustomer.setItems(FXCollections.observableArrayList(all));



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBConnection.customerList.add(new Customer("C001","Danuka","panadura",85000.00));

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Customer customer=new Customer(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );
        if (customerController.updateCustomer(customer)) {
            new Alert(Alert.AlertType.INFORMATION, "Customer Updated Successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Update Customer!").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (customerController.deleteCustomer(txtId.getText())) {
            new Alert(Alert.AlertType.INFORMATION, "Customer Deleted Successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Delete Customer!").show();
        }
    }

    public void btnGetDetailsonAction(ActionEvent actionEvent) {
        Customer customer = customerController.getCustomer(txtId.getText());
        if (customer != null) {
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtSalary.setText(String.valueOf(customer.getSalary()));
        } else {
            new Alert(Alert.AlertType.WARNING, "Customer Not Found!").show();
        }
    }

}
