package Dao;

import Entity.Message;
import Entity.Product;
import tool.MySQLDriver;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DealDao {
    public List<Product> selectByStuid(Message message){
        Connection connection= MySQLDriver.getConnection();
        String sql = "SELECT *FROM deal WHERE `买家ID`=?OR`卖家ID`=?";

        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Product>products=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getSender());
            preparedStatement.setString(2,message.getSender());

            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product=new Product();
                product.setProductID(resultSet.getString("商品ID"));
                product.setName(resultSet.getString("商品名称"));
                product.setSellTime(resultSet.getString("成交时间"));
                product.setPrice(resultSet.getDouble("商品价格"));
                product.setUpUser(resultSet.getString("卖家ID"));
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
    public void insert(Message message){

        Connection connection= MySQLDriver.getConnection();

        String sql="INSERT INTO deal (`买家ID`,`卖家ID`,`商品名称`,`商品ID`,`商品价格`,`成交时间`) VALUES (?,?,?,?,?,?)";
        String sql2 = "SELECT *FROM products WHERE 商品序号=?";
        String sql1="UPDATE products  SET 商品数量=? WHERE 商品序号=?";
        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getSender());
            preparedStatement.setString(2,message.getProduct().getUpUser());
            preparedStatement.setString(3,message.getProduct().getName());
            preparedStatement.setString(4,message.getProduct().getProductID());
            preparedStatement.setDouble(5,message.getProduct().getPrice());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String time = df.format(new Date());
            preparedStatement.setString(6,time);
            preparedStatement.execute();
            ResultSet resultSet=null;
            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.setString(1,message.getProduct().getProductID());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                int num=resultSet.getInt("商品数量");
                preparedStatement=connection.prepareStatement(sql1);
                preparedStatement.setInt(1,num-1);
                preparedStatement.setString(2,message.getProduct().getProductID());
                preparedStatement.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);

        }
    }
}
