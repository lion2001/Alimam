package model;

import Dao.*;
import Entity.Message;
import Entity.Product;
import Entity.User;
import Entity.UserMessage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Entity.MessageType.*;

public class SerConClientThread extends Thread{
    Socket s;
    public static String path="D:\\学习资料\\图片存放\\";

    public SerConClientThread(Socket s){this.s=s;}
    public void run(){
        CollectionDao collectionDao=new CollectionDao();
        DealDao dealDao=new DealDao();
        ProductDao productDao=new ProductDao();
        CommunicateDao communicateDao=new CommunicateDao();
        UserDao userDao=new UserDao();
        ChatDao chatDao=new ChatDao();
        AuctionDao auctionDao=new AuctionDao();
        boolean onLine=true;
        while(onLine){
            try {
                ObjectInputStream ois=new ObjectInputStream(s.getInputStream());

                Message msg=(Message)ois.readObject();
                if(msg.getMesType().equals(message_up_photo)){
                    Product product=msg.getProduct();
                    String srcFile=product.getImagePath();
                    int index=srcFile.lastIndexOf("\\");
                    int index1=srcFile.lastIndexOf(".");
                    String ext,dest,destFile;
                    ext=srcFile.substring(index1+1);
                    dest = srcFile.substring(index + 1);
                    destFile = path+dest;
                    OutputStream out=new FileOutputStream(destFile);
                    BufferedImage img= ImageIO.read(product.getImage());
                    ImageIO.write(img,ext,out);
                    userDao.upPhoto(destFile,msg.getSender());
                }else if(msg.getMesType().equals(message_get_all)){
                    String id=msg.getSender();
                    UserMessage userMessage=new UserMessage();
                    userMessage.setIName(id);
                    User user;
                    user=userDao.selectByStuid(id);
                    userMessage.setIName(user.getName());
                    userMessage.setIPhoto(user.getPhoto());
                    List<User> users=communicateDao.selectByBuyer(msg);
                    List<Message>messages=chatDao.selectAll(msg);
                    userMessage.setIChat(messages);
                    userMessage.setIChatObject(users);
                    List<Product> ISellTable=dealDao.selectByStuid(msg);
                    List<Product> IAuction=auctionDao.selectAuctionById(msg);
                    List<Product> ICollection=collectionDao.selectAll(msg);
                    List<Product> IShowPro=productDao.selectAll();
                    userMessage.setIShowPro(IShowPro);
                    userMessage.setICollection(ICollection);
                    userMessage.setISellTable(ISellTable);
                    userMessage.setIAuction(IAuction);
                    Message message=new Message();
                    message.setUserMessage(userMessage);
                    message.setMesType(message_get_all);
                    ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
                    oos.writeObject(message);
                }else if(msg.getMesType().equals(message_comm_mes)){
                    chatDao.insert(msg);
                    SerConClientThread sc=ManageClientThread.getClientThread(msg.getGetter());
                    if(sc!=null){
                        ObjectOutputStream oos=new ObjectOutputStream(sc.s.getOutputStream());
                        oos.writeObject(msg);
                    }
                }else if(msg.getMesType().equals(message_up_product)){
                    System.out.println("UP");
                    String ext,dest,destFile;
                    Product product=msg.getProduct();

                    String srcFile=product.getImagePath();
                    int index=srcFile.lastIndexOf("\\");
                    int index1=srcFile.lastIndexOf(".");
                    ext=srcFile.substring(index1+1);
                    dest = srcFile.substring(index + 1);
                    destFile = path+dest;
                    OutputStream out=new FileOutputStream(destFile);
                    BufferedImage img=ImageIO.read(product.getImage());
                    ImageIO.write(img,ext,out);
                    product.setImagePath(destFile);
                    productDao.insertPro(product);
                }else if(msg.getMesType().equals(message_return_product)){
                    List<Product>products=new ArrayList<>();
                    Product product=msg.getProduct();
                    if(product.getIntroduce()!=null){
                        products=productDao.selectByIntroduce(product.getIntroduce(),product.getIsAuction());
                    }else if(product.getProductID()!=null){
                        products.add(productDao.selectByPro(product.getProductID()));
                    }else {
                        if(product.getIsAuction()==1){
                            products=productDao.queryProductByPage(product.getSort(),1);
                        }else{
                            products=productDao.queryProductByPage(product.getSort(),0);

                        }
                    }
                    ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
                    oos.writeObject(msg);
                    oos.writeObject(products);
                }else if(msg.getMesType().equals(message_add_chat_object)){
                    communicateDao.IsInsert(msg);
                    SerConClientThread sc=ManageClientThread.getClientThread(msg.getGetter());
                    ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
                    oos.writeObject(msg);
                    oos.writeObject(userDao.selectByStuid(msg.getGetter()));
                    if(sc!=null){
                        oos=new ObjectOutputStream(sc.s.getOutputStream());
                        msg.setMesType(message_been_add_chat_object);
                        oos.writeObject(msg);
                        oos.writeObject(userDao.selectByStuid(msg.getSender()));
                    }
                }else if(msg.getMesType().equals(message_add_collection)){
                    collectionDao.insert(msg);
                }else if(msg.getMesType().equals(message_add_deal)){
                    Product product=msg.getProduct();
                    if(product.getIsAuction()==1){
                        auctionDao.insertAuction(msg.getSender(),product);
                    }else {
                        dealDao.insert(msg);
                        SerConClientThread sc=ManageClientThread.getClientThread(msg.getGetter());
                        if(sc!=null){
                            ObjectOutputStream oos=new ObjectOutputStream(sc.s.getOutputStream());
                            oos.writeObject(msg);
                        }
                    }
                }else if(msg.getMesType().equals(message_final_auction)){
                    String id=auctionDao.finishAuction(msg);
                    SerConClientThread sc=ManageClientThread.getClientThread(msg.getGetter());
                    if(sc!=null){
                        Message message=new Message();
                        message.setProduct(msg.getProduct());
                        message.setMesType(message_final_auction);
                        ObjectOutputStream oos=new ObjectOutputStream(sc.s.getOutputStream());
                        oos.writeObject(message);
                    }
                }else if(msg.getMesType().equals(message_close)){
                    ManageClientThread.hm.remove(msg.getSender());
                    System.out.println(ManageClientThread.hm.size());
                    onLine=false;
                }else if(msg.getMesType().equals(message_add_comment)){
                    CommentDao commentDao=new CommentDao();
                    commentDao.insert(msg);
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
