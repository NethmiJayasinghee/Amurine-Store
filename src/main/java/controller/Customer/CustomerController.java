package controller.Customer;

import db.DBConnection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerController implements CustomerService {

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement psTm=connection.prepareStatement("INSERT INTO  Customer VALUES(?,?,?,?) ");

            psTm.setObject(1,customer.getId());
            psTm.setObject(2,customer.getName());
            psTm.setObject(3,customer.getAddress());
            psTm.setDouble(4,customer.getSalary());
            return psTm.executeUpdate()>0;




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement prstm=connection.prepareStatement("UPDATE Customer SET name=?, address=?, salary=? WHERE id=?");


            prstm.setObject(1,customer.getName());
            prstm.setObject(2,customer.getAddress());
            prstm.setObject(3,customer.getSalary());
            prstm.setObject(4,customer.getId());

            return  prstm.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteCustomer(String id) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement psTm=connection.prepareStatement("DELETE FROM Customer WHERE id=?");

            psTm.setObject(1,id);

            return psTm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Customer getCustomer(String id) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
            
            preparedStatement.setObject(1,id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("salary")
                );
            }

            return  null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAll() {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM Customer");

            List<Customer> customerList=new ArrayList<>();

            while (resultSet.next()){
                customerList.add(new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)
                ));
            }
            return  customerList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
