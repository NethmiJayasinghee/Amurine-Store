package db;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import model.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;


    public static  ObservableList<Customer> customerList = FXCollections.observableArrayList();
    public static  ObservableList<Item> itemList = FXCollections.observableArrayList();

    private DBConnection() throws SQLException {
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade ","root","1234");
    }

    public Connection getConnection()  {
        return connection;
    }
    public static DBConnection getInstance() throws SQLException {
        if(instance==null){
            return instance=new DBConnection();
        }
        return instance;
    }
}
