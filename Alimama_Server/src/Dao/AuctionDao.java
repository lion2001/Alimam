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

public class AuctionDao {
    public List<Product> selectAuction(){
        Connection connection= MySQLDriver.getConnection();
        String sql="SELECT * FROM auctionstate ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Product> products=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product=new Product();
                product.setProductID(resultSet.getString("商品ID"));
                product.setPrice(resultSet.getDouble("价格"));
                product.setName(resultSet.getString("商品名称"));
                product.setState(resultSet.getInt("状态"));
                products.add(product);
                System.out.println(product);
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
    public List<Product> selectAuctionById(Message message){
        Connection connection=MySQLDriver.getConnection();
        String sql="SELECT * FROM auctionstate WHERE 卖家ID=? OR 买家ID=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Product> products=new ArrayList<>();
        ProductDao productDao=new ProductDao();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getSender());
            preparedStatement.setString(2,message.getSender());
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product;
                product=productDao.selectByPro(resultSet.getString("商品ID"));
                product.setState(resultSet.getInt("状态"));
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
    public void updateAuction(String id, Product product){
        Connection connection=MySQLDriver.getConnection();
        String sql="UPDATE auctionstate  SET 商品价格=?, 状态=? WHERE 买家ID=?AND 商品ID=?";
        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setDouble(1,product.getPrice());
            preparedStatement.setInt(2,product.getState());
            preparedStatement.setString(3,id);
            preparedStatement.setString(4,product.getProductID());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }

    }
    public void upDateByPro(Product product, int msg){
        Connection connection=MySQLDriver.getConnection();
        String sql="UPDATE auctionstate  SET 状态=? WHERE 商品ID=?";
        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,msg);
            preparedStatement.setString(2,product.getProductID());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }

    }
    public String finishAuction(Message message){
        Connection connection=MySQLDriver.getConnection();
        String sql1="SELECT * FROM auctionstate WHERE 状态=0 AND 商品ID=?";
        String sql="UPDATE auctionstate  SET 状态=? WHERE 商品ID=? AND 状态=0";
        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setString(1,message.getProduct().getProductID());
            ResultSet resultSet=null;
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                message.getProduct().setBuyer(resultSet.getString("买家ID"));
                message.getProduct().setPrice(resultSet.getDouble("商品价格"));
            }
            resultSet.close();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,message.getProduct().getProductID());
            preparedStatement.executeUpdate();
            DealDao dealDao=new DealDao();
            dealDao.insert(message);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
        return message.getProduct().getBuyer();
    }
    public void insertAuction(String id, Product product){
        Connection connection= MySQLDriver.getConnection();

        String sql="INSERT INTO auctionstate(买家ID,卖家ID,商品名称,商品ID,商品价格,状态) VALUES(?,?,?,?,?,?)";
        String sql1="SELECT * FROM auctionstate WHERE 买家ID=?AND 商品ID=?";
        String sql2="UPDATE products  SET 价格=? WHERE 商品序号=?";
        String sql3="DELETE  FROM auctionstate WHERE 商品ID=?AND 状态=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,product.getProductID());
            resultSet=preparedStatement.executeQuery();
            AuctionDao AuctionDao=new AuctionDao();
            AuctionDao.upDateByPro(product,-1);
            if(resultSet.next()){//加过价
                AuctionDao.updateAuction(id,product);
            }else{
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,id);
                preparedStatement.setString(2,product.getUpUser());
                preparedStatement.setString(3,product.getName());
                preparedStatement.setString(4, product.getProductID());
                preparedStatement.setDouble(5,product.getPrice());
                preparedStatement.setInt(6,product.getState());
                preparedStatement.execute();
            }
            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.setDouble(1,product.getPrice());
            preparedStatement.setString(2, product.getProductID());
            preparedStatement.execute();

            preparedStatement=connection.prepareStatement(sql3);
            preparedStatement.setString(1,product.getProductID());
            preparedStatement.setInt(2,-1);
            preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
    }

}
