import model.Customer;

import java.sql.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main  {
    public static void main(String[] args) {

        Starter.main(args);

//        try {
//            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade","root","1234");
//            System.out.println(connection);
//
//           PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM Customer");
//           ResultSet rs=preparedStatement.executeQuery();
//           System.out.println(rs);
//
//            ArrayList<Customer> CustomerArrayList=new ArrayList<>();
//           while (rs.next()){
//               Customer cus=new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
//               CustomerArrayList.add(cus);
//           }
//           for(Customer customer:CustomerArrayList){
//               System.out.println(customer);
//           }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


    }
}