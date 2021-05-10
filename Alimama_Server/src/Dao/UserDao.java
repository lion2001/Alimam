package Dao;

import Entity.Message;
import Entity.User;
import tool.MySQLDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void createTable(User user){
        Connection connection= MySQLDriver.getConnection();
        String sql="CREATE TABLE `"+user.getStuId()+"`(卖家ID varchar(6),买家ID varchar(6),消息记录 varchar(5000))";
        Statement statement=null;
        try{
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            MySQLDriver.close(connection);
        }
    }

    public static void main(String[] args) {
        CommunicateDao communicateDao=new CommunicateDao();
        Message message=new Message();
        message.setSender("123456");
        message.setGetter("123456");
        communicateDao.IsInsert(message);
    }
    public boolean insert(User user){
        boolean success=false;
        Connection connection= MySQLDriver.getConnection();

        String sql="INSERT INTO user(stuId,name,password,isadmin,photo) VALUES(?,?,?,?,?)";

        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getStuId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getIsAdmin());
            preparedStatement.setString(5,"D:\\学习资料\\图片存放\\wo.png");
            preparedStatement.execute();
            success=true;
            if(success){
                UserDao userDao=new UserDao();
                CommunicateDao communicateDao=new CommunicateDao();
                Message message=new Message();
                message.setSender(user.getStuId());
                message.setGetter(user.getStuId());
                communicateDao.IsInsert(message);
                userDao.createTable(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
            return success;
        }
    }
    public void DeleteUser(String id){
        Connection connection=MySQLDriver.getConnection();
        String sql="DELETE  FROM user WHERE stuId=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }

    }

    public List<User> selectAll(){
        Connection connection=MySQLDriver.getConnection();
        String sql="SELECT * FROM user ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<User> users=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                User user=new User();
                user.setStuId(resultSet.getString("stuId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isadmin"));
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
        return users;
    }

    public User selectByStuid(String  stuId){
        Connection connection=MySQLDriver.getConnection();
        String sql="SELECT * FROM user WHERE stuId=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        User user=new User();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,stuId);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setStuId(resultSet.getString("stuId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isadmin"));
                String imagePath=resultSet.getString("photo");
                File img=new File(imagePath);
                user.setPhoto(img);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
        return user;
    }
    public void upPhoto(String imagePath,String id){
        Connection connection=MySQLDriver.getConnection();
        String sql="SELECT * FROM user WHERE stuId=?";
        String sql1="UPDATE user SET photo =? WHERE stuId=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        User user=new User();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
               preparedStatement=connection.prepareStatement(sql1);
                preparedStatement.setString(1,imagePath);
                preparedStatement.setString(2,id);
                preparedStatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
    }

}