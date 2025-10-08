package controller.Item;

import db.DBConnection;
import javafx.collections.FXCollections;
import model.Customer;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemController implements ItemService {

    @Override
    public  boolean addItem(Item item) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement psTm=connection.prepareStatement("INSERT INTO  Item VALUES(?,?,?,?) ");

            psTm.setObject(1,item.getCode());
            psTm.setObject(2,item.getDes());
            psTm.setObject(3,item.getUnitPrice());
            psTm.setDouble(4,item.getQtyOnHand());
            return psTm.executeUpdate()>0;




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateItem(Item item) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement prstm=connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");


            prstm.setObject(1,item.getDes());
            prstm.setObject(2,item.getUnitPrice());
            prstm.setObject(3,item.getQtyOnHand());
            prstm.setObject(4,item.getCode());

            return  prstm.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteItem(String code) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement psTm=connection.prepareStatement("DELETE FROM Item WHERE code=?");

            psTm.setObject(1,code);

            return psTm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item getItem(String code) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Item WHERE code=?");

            preparedStatement.setObject(1,code);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Item(
                        rs.getString("code"),
                        rs.getString("description"),
                        rs.getDouble("unitPrice"),
                        rs.getInt("qtyOnHand")
                );
            }

            return  null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> getDetails() {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT * FROM Item");

            List<Item> itemList=new ArrayList<>();

            while (rs.next()){
                itemList.add(new Item(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4)

                ));
            }
            return itemList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
