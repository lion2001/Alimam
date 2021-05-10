package Dao;

import Entity.Message;
import Entity.Product;
import tool.MySQLDriver;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectionDao {
    public void insert(Message message){
        //sender--userId
        //con-----proid
        //type----message_add_collection
        Connection connection= MySQLDriver.getConnection();

        String sql = "INSERT INTO collect (`userID`,`proID`) VALUES (?,?)";

        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getSender());
            preparedStatement.setString(2,message.getCon());
            preparedStatement.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);

        }
    }
    public List<Product> selectAll(Message message){
        //sender--userId
        //con-----proid
        //type----message_add_collection
        Connection connection=MySQLDriver.getConnection();
        String sql = "SELECT proID FROM collect WHERE userID = ?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Product> products=new ArrayList<>();
        ProductDao productDao=new ProductDao();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getSender());
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product;
                String id=resultSet.getString("proID");
                product=productDao.selectByPro(id);
                products.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
        return products;
    }

}
