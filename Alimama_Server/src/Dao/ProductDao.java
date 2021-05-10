package Dao;


import Entity.Message;
import Entity.Product;
import tool.MySQLDriver;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProductDao {

    public  int getTotalCount(int sortWay){
        int count=-1;
        String sql;
        if(sortWay==7){
            sql= "select count(1) from products where 购买方式=1 ";
        }//拍卖
        else if(sortWay==-1){
            sql = "select count(1) from products ";
        }else{
            sql="select count(1) from products where 购买方式=?";
        }
        Connection connection=MySQLDriver.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            if(sortWay<7&&sortWay>-1){
                preparedStatement.setInt(1,sortWay);
            }

            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                count=resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
        return count;
    }
    public List<Product> queryProductByPage(int sortWay,int isAuction) {
        List<Product> products=new ArrayList<>();
        Connection connection=MySQLDriver.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql;
        if(isAuction==1){
            if(sortWay==-1){
                sql = "select *from products where 购买方式=1 ";
            }else{
                sql="select *from products where 购买方式=1 AND 商品分类=?";
            }
        }else{
            if(sortWay==-1){
                sql = "select *from products where 购买方式=0 ";
            }else{
                sql="select *from products where 购买方式=0 AND 商品分类=? ";
            }
        }
        try{
            preparedStatement=connection.prepareStatement(sql);
            if(sortWay!=-1){
                preparedStatement.setInt(1,sortWay);
            }
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                if(resultSet.getInt("商品数量")>0){
                    Product product=new Product();
                    product.setProductID(resultSet.getString("商品序号"));
                    product.setPrice(resultSet.getDouble("价格"));
                    product.setName(resultSet.getString("商品名称"));
                    product.setContact(resultSet.getString("联系方式"));
                    product.setIntroduce(resultSet.getString("商品简介"));
                    product.setUpUser(resultSet.getString("上传用户"));
                    product.setBuyWay(resultSet.getString("购买途径"));
                    product.setIsAuction(resultSet.getInt("购买方式"));
                    String imagePath=resultSet.getString("图片");
                    product.setImage(new File(imagePath));
                    CommentDao commentDao=new CommentDao();
                    List<String>strings=commentDao.selectAll(product.getProductID());
                    product.setComments(strings);
                    products.add(product);
                }
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


    public static void main(String[] args) {
        ProductDao productDao=new ProductDao();
        List<Product>products=productDao.selectByIntroduce("书籍",0);
        System.out.println(products.size());
    }
    public List<Product> selectByIntroduce(String introduce,int IsAuction){
        Connection connection= MySQLDriver.getConnection();
        String sql="SELECT *FROM products WHERE 商品名称 LIKE '%"+introduce+"%'AND 购买方式="+IsAuction+"";
        System.out.println("byIntroduce");
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Product> products=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getInt("商品数量")>0){
                    Product product=new Product();
                    product.setProductID(resultSet.getString("商品序号"));
                    product.setPrice(resultSet.getDouble("价格"));
                    product.setName(resultSet.getString("商品名称"));
                    product.setContact(resultSet.getString("联系方式"));
                    product.setIntroduce(resultSet.getString("商品简介"));
                    product.setUpUser(resultSet.getString("上传用户"));
                    product.setBuyWay(resultSet.getString("购买途径"));
                    product.setIsAuction(resultSet.getInt("购买方式"));
                    String imagePath=resultSet.getString("图片");
                    product.setImage(new File(imagePath));
                    CommentDao commentDao=new CommentDao();
                    List<String>strings=commentDao.selectAll(product.getProductID());
                    product.setComments(strings);
                    products.add(product);
                }
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
    public void DeletePro(String id){
        Connection connection=MySQLDriver.getConnection();
        String sql="DELETE  FROM products WHERE 商品序号=?";
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
    public List<Product> selectAll(){
        Connection connection=MySQLDriver.getConnection();
        String sql="SELECT * FROM products ";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Product> products=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getInt("商品数量")>0){
                    Product product=new Product();
                    product.setProductID(resultSet.getString("商品序号"));
                    product.setPrice(resultSet.getDouble("价格"));
                    product.setName(resultSet.getString("商品名称"));
                    product.setContact(resultSet.getString("联系方式"));
                    product.setIntroduce(resultSet.getString("商品简介"));
                    product.setUpUser(resultSet.getString("上传用户"));
                    product.setBuyWay(resultSet.getString("购买途径"));
                    product.setIsAuction(resultSet.getInt("购买方式"));
                    String imagePath=resultSet.getString("图片");
                    product.setImage(new File(imagePath));
                    CommentDao commentDao=new CommentDao();
                    List<String>strings=commentDao.selectAll(product.getProductID());
                    product.setComments(strings);
                    products.add(product);
                }

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







    //    public void SellAuction

    public void insertPro(Product product){
        Connection connection= MySQLDriver.getConnection();

        String sql="INSERT INTO products(商品名称,价格,联系方式,购买方式,购买途径,商品简介,商品分类,上传用户,上传时间,图片,商品数量) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        String sql1="INSERT INTO auctionstate(买家ID,卖家ID,商品名称,商品ID,商品价格,状态) VALUES(?,?,?,?,?,?)";
        String sql2="SELECT max(商品序号) FROM products";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getContact());
            preparedStatement.setInt(4,product.getIsAuction());
            preparedStatement.setString(5,product.getBuyWay());
            preparedStatement.setString(6,product.getIntroduce());
            preparedStatement.setInt(7,product.getSort());
            preparedStatement.setString(8,product.getUpUser());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String time = df.format(new Date());
            preparedStatement.setString(9,time);
            preparedStatement.setString(10,product.getImagePath());
            preparedStatement.setInt(11,product.getNumber());
            preparedStatement.execute();
            if(product.getIsAuction()==1){
                preparedStatement=connection.prepareStatement(sql2);
                resultSet=preparedStatement.executeQuery();
                if(resultSet.next()){
                    product.setProductID(resultSet.getString(1));
                }
                preparedStatement=connection.prepareStatement(sql1);
                preparedStatement.setString(1,product.getUpUser());
                preparedStatement.setString(2,product.getUpUser());
                preparedStatement.setString(3,product.getName());
                preparedStatement.setString(4,product.getProductID());
                preparedStatement.setDouble(5,product.getPrice());
                preparedStatement.setInt(6,-1);
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
    }



    public Product selectByPro(String ProId){
        Connection connection=MySQLDriver.getConnection();
        String sql="SELECT * FROM products WHERE 商品序号=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Product product=new Product();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,ProId);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){

                product.setProductID(resultSet.getString("商品序号"));
                product.setPrice(resultSet.getDouble("价格"));
                product.setName(resultSet.getString("商品名称"));
                product.setContact(resultSet.getString("联系方式"));
                product.setIntroduce(resultSet.getString("商品简介"));
                product.setUpUser(resultSet.getString("上传用户"));
                product.setBuyWay(resultSet.getString("购买途径"));
                product.setIsAuction(resultSet.getInt("购买方式"));
                String imagePath=resultSet.getString("图片");
                product.setImage(new File(imagePath));
                CommentDao commentDao=new CommentDao();
                List<String>strings=commentDao.selectAll(product.getProductID());
                product.setComments(strings);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLDriver.close(resultSet);
            MySQLDriver.close(preparedStatement);
            MySQLDriver.close(connection);
        }
        return product;
    }


}
