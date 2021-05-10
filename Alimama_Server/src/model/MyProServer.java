package model;

import Dao.*;
import Entity.Message;
import Entity.Product;
import Entity.User;
import Entity.UserMessage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import static Entity.MessageType.*;

public class MyProServer {
    public UserMessage get(Message msg){
        CollectionDao collectionDao=new CollectionDao();
        DealDao dealDao=new DealDao();
        ProductDao productDao=new ProductDao();
        CommunicateDao communicateDao=new CommunicateDao();
        UserDao userDao=new UserDao();
        ChatDao chatDao=new ChatDao();
        AuctionDao auctionDao=new AuctionDao();


        String id=msg.getSender();
        UserMessage userMessage=new UserMessage();
        userMessage.setIid(id);
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
        return userMessage;
    }
    public MyProServer(){

        System.out.println("服务器开启");
        try{
            ServerSocket ss=new ServerSocket(9999);
            while(true){
                Socket s=ss.accept();
                ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream  ois=new ObjectInputStream(s.getInputStream());
                UserDao userDao=new UserDao();

                User u=(User)ois.readObject();
                Message msg=(Message)ois.readObject();
                Message m=new Message();
                msg.setSender(u.getStuId());
                if(msg.getMesType().equals(message_login)){
                    User user=userDao.selectByStuid(u.getStuId());
                    if(u.getPassword().equals(user.getPassword())){
                        m.setMesType("1");
                        oos.writeObject(m);
                        oos.writeObject(get(msg));
                        SerConClientThread scct=new SerConClientThread(s);
                        ManageClientThread.addClientThread(user.getStuId(),scct);
                        scct.start();
                    }else {
                        m.setMesType("2");
                        oos.writeObject(m);
                        s.close();
                    }
                }else if(msg.getMesType().equals(message_add_register)){
                     boolean isSucceed=userDao.insert(u);
                     if(isSucceed){
                         m.setMesType("1");
                         oos.writeObject(m);
                         oos.writeObject(get(msg));
                         SerConClientThread scct=new SerConClientThread(s);
                         ManageClientThread.addClientThread(u.getStuId(),scct);
                         scct.start();
                     }else{
                         m.setMesType("2");
                         oos.writeObject(m);
                     }
                }
            }
        }catch (Exception e){

        }
    }
}
