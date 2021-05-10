package tools.addFriend;

import Entity.IUser;
import Entity.Message;
import Entity.Product;
import tools.ManageClientConServerThread;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static Entity.MessageType.message_up_photo;

public class AddFriend extends Thread {
    Socket socket;
    Message message;
    public AddFriend(Message message){
        this.message=message;
        socket= ManageClientConServerThread.getClientConServerThread(IUser.getIid()).getS();
    }
    public void run(){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            System.out.println(message.getMesType());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
