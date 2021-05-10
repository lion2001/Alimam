package Dao;

import Entity.Message;
import tool.MySQLDriver;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    public static void main(String[] args) {
        Message message=new Message();
        message.setGetter("1143");
        message.setCon("jafkslafmj");
        CommentDao commentDao=new CommentDao();
        commentDao.insert(message);
    }
    public void insert(Message message){
        Connection connection= MySQLDriver.getConnection();
        String sql="INSERT INTO comment(proID,comment) VALUES(?,?)";
        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getGetter());
            preparedStatement.setString(2,message.getCon());
            preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);

        }
    }
    public List<String> selectAll(String id){
        Connection connection=MySQLDriver.getConnection();
        String sql = "SELECT * FROM comment WHERE `proID`=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<String> comments=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);

            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String comment=resultSet.getString("comment");
                comments.add(comment);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
        return comments;
    }

}
