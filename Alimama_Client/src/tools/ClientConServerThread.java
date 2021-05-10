package tools;

import Entity.*;
import com.client.page.MyFrame2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static Entity.MessageType.*;

public class ClientConServerThread extends Thread {
    private Socket s;
    private static final long serialVersionUID = 2106453362582730870L;

    public Socket getS(){
        return s;
    }

    private static boolean isOpen=true;
    public void setIsOpen(boolean i){
        isOpen=i;
    }
    public ClientConServerThread(Socket s){
        this.s=s;
    }
    public void run(){
        while(isOpen){
            try {
                ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
                Message m=(Message)ois.readObject();
                if (m.getMesType().equals(message_add_chat_object)) {
                     User user=(User)ois.readObject();
                     IUser.getIChatObject().add(user);
                     List<Message>messages=new ArrayList<>();
                     IUser.getIChatMsg().put(user.getStuId(),messages);
                     MyFrame2 myFrame2=NowChatObject.getMyFrame2();
                     myFrame2.Pane_toChat(user);
                }else if(m.getMesType().equals(message_been_add_chat_object)){
                    User user=(User)ois.readObject();
                    IUser.getIChatObject().add(user);
                    List<Message>messages=new ArrayList<>();
                    IUser.getIChatMsg().put(user.getStuId(),messages);
                }else if (m.getMesType().equals(message_comm_mes)){
                    IUser.getIChatMsg().get(m.getSender()).add(m);
                    IUser.getIChat().add(m);
                    MyFrame2 myFrame2=NowChatObject.getMyFrame2();
                    myFrame2.showIn(m);
                }else if (m.getMesType().equals(message_return_product)){
                    List<Product>products=(List<Product>)ois.readObject();
                    IUser.setIShowPro(products);
                    MyFrame2 myFrame2=NowChatObject.getMyFrame2();
                    myFrame2.showProduct(products,m.getProduct().getIsAuction());
                }else if(m.getMesType().equals(message_final_auction)){
                    MyFrame2 myFrame2=NowChatObject.getMyFrame2();
                    myFrame2.showSellMessage(m);
                }else if(m.getMesType().equals(message_add_deal)){
                    MyFrame2 myFrame2=NowChatObject.getMyFrame2();
                    myFrame2.showSellMessage(m);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
