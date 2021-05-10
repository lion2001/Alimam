package model;

import Entity.IUser;
import Entity.Message;
import Entity.User;
import Entity.UserMessage;
import tools.ClientConServerThread;
import tools.ManageClientConServerThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import static Entity.MessageType.message_get_all;

public class ClientConServer {
    public  Socket s;
    public boolean sendLoginInfoToServer(Object o, Message msg){
        boolean b=false;
        try{
            s=new Socket("127.0.0.1",9999);
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());

            oos.writeObject(o);
            oos.writeObject(msg);

            Message ms=(Message)ois.readObject();

            if(ms.getMesType().equals("1")){
                UserMessage u=(UserMessage)ois.readObject();
                IUser.setIName(u.getIName());
                IUser.setIid(u.getIid());
                if(u.getICollection()!=null){
                    IUser.setICollection(u.getICollection());
                }
                if(u.getISellTable()!=null){
                    IUser.setISellTable(u.getISellTable());
                }
                if(u.getIAuction()!=null){
                    IUser.setIAuction(u.getIAuction());
                }
                IUser.setIPhoto(u.getIPhoto());
                if(u.getIChat()!=null){
                    IUser.setIChat(u.getIChat());
                    IUser.setIChatMsg();
                }
                if(u.getIChatObject()!=null){
                    IUser.setIChatObject(u.getIChatObject());
                }

                IUser.setIShowPro(u.getIShowPro());

                ClientConServerThread ccst=new ClientConServerThread(s);
                ccst.start();
                ManageClientConServerThread.addClientConServerThread(((User) o).getStuId(),ccst);
                b=true;
            }else{
                b=false;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }

}
