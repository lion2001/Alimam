package Dao;

import Entity.Message;
import Entity.User;
import tool.MySQLDriver;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunicateDao {

    public boolean IsInsert(Message message){//true为新加
        //message 类型 sender--我
        //             getter--卖家
        //             type --message_add_chat_object
        boolean success=false;
        Connection connection= MySQLDriver.getConnection();
        String sql="SELECT * FROM communications WHERE 买家ID=?AND 卖家ID=?";
        String sql1="INSERT INTO communications (`卖家ID`,`买家ID`) VALUES (?,?)";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getSender());
            preparedStatement.setString(2,message.getGetter());
            resultSet=preparedStatement.executeQuery();
            if(!resultSet.next()){
                preparedStatement=connection.prepareStatement(sql1);
                preparedStatement.setString(1,message.getSender());
                preparedStatement.setString(2,message.getGetter());
                preparedStatement.execute();
                success=true;
            }
            resultSet.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
            return success;
        }
    }
    public List<User> selectByBuyer(Message message){
        //message 类型 sender--我
        //             type --message_get_is_chat
        Connection connection= MySQLDriver.getConnection();
        String sql ="SELECT * FROM communications WHERE `买家ID`=?OR `卖家ID`=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<User> users=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getSender());
            preparedStatement.setString(2,message.getSender());

            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                UserDao userDao=new UserDao();
                User user;
                if(resultSet.getString("卖家ID").equals(message.getSender())){
                    user=userDao.selectByStuid(resultSet.getString("买家ID"));
                }else{
                    user=userDao.selectByStuid(resultSet.getString("卖家ID"));
                }
                users.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);

        }
          return users;
    }

    public static void main(String[] args) {
        CommunicateDao communicateDao=new CommunicateDao();
        Message message=new Message();
        message.setSender("1");
        message.setGetter("2");
        boolean s=true;
        s=communicateDao.IsInsert(message);
        if(s){
            System.out.println("hahaha");
        }

    }

}
