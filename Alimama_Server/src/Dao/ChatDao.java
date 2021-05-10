package Dao;

import Entity.Message;
import Entity.User;
import tool.MySQLDriver;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDao {

    public List<Message> selectAll(Message message){
        Connection connection=MySQLDriver.getConnection();
        String id=message.getSender();
        String sql="SELECT * FROM `"+id+"`";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Message>messages=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Message message1=new Message();
                message1.setSender(resultSet.getString("卖家ID"));
                message1.setGetter(resultSet.getString("买家ID"));
                message1.setCon(resultSet.getString("消息记录"));
                messages.add(message1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
        return messages;
    }

    public static void main(String[] args) {
        Message message=new Message();
        message.setGetter("111111");
        message.setSender("000000");
        message.setCon("hahahh");
        ChatDao chatDao=new ChatDao();
        chatDao.insert(message);
    }
    public void insert(Message message){
        Connection connection=MySQLDriver.getConnection();
        String id1=message.getSender();
        String id2=message.getGetter();
        String con=message.getCon();
        String sql="INSERT INTO`"+id1+"`(卖家ID,买家ID,消息记录) VALUES(?,?,?)";
        String sql1="INSERT INTO`"+id2+"`(卖家ID,买家ID,消息记录) VALUES(?,?,?)";
        PreparedStatement preparedStatement=null;
        List<Message>messages=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id2);
            preparedStatement.setString(2,id1);
            preparedStatement.setString(3,con);
            preparedStatement.execute();
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setString(1,id2);
            preparedStatement.setString(2,id1);
            preparedStatement.setString(3,con);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
    }
}
