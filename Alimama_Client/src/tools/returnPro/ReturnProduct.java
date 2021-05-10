package tools.returnPro;

import Entity.IUser;
import Entity.Message;
import Entity.Product;
import tools.ManageClientConServerThread;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Callable;

public class ReturnProduct extends Thread {
    Socket socket;
    Message message;
    public ReturnProduct(Message message){
        this.message=message;
        socket= ManageClientConServerThread.getClientConServerThread(IUser.getIid()).getS();
    }
    public void run(){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
