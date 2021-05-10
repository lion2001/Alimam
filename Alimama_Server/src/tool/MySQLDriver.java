package tool;

import java.sql.*;

public class MySQLDriver {
    public static Connection getConnection() {
        //准备Connection对象
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbname = "shopsystem";
            String name = "root";
            String password = "zxcvbnm7890";
            //建立连接，装配Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(Connection connection){
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}