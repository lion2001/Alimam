package model;

import Entity.Message;
import Entity.Product;
import Entity.User;
import com.sun.jdi.event.ThreadStartEvent;
import tools.returnPro.ReturnProduct;

import java.util.List;

import static Entity.MessageType.message_add_register;
import static Entity.MessageType.message_login;

public class ClientUser {
    public boolean checkUserLogin(User u){
        Message msg=new Message();
        msg.setMesType(message_login);
        return new ClientConServer().sendLoginInfoToServer((Object)u,msg);
    }
    public boolean checkUserRegister(User u){
        Message msg=new Message();
        msg.setMesType(message_add_register);
        return new ClientConServer().sendLoginInfoToServer((Object)u,msg);
    }
}
