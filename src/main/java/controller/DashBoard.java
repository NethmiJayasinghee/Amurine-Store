package controller;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoard {
    public AnchorPane root;
    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        URL resource= this.getClass().getResource("view/CustomerForm.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        this.root.getChildren().clear();
        this.root.getChildren().add(load);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        URL resource= this.getClass().getResource("view/Item.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        this.root.getChildren().clear();
        this.root.getChildren().add(load);
    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        URL resource= this.getClass().getResource("view/CustomerForm.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        this.root.getChildren().clear();
        this.root.getChildren().add(load);
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {

    }

}
