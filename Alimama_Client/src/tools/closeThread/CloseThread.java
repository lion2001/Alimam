package tools.closeThread;

import Entity.IUser;
import Entity.Message;
import tools.ManageClientConServerThread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CloseThread {
    Socket socket;
    Message message;
    public CloseThread(Message message){
        this.message=message;
        socket= ManageClientConServerThread.getClientConServerThread(IUser.getIid()).getS();
    }
    public void run(){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            ManageClientConServerThread.getClientConServerThread(IUser.getIid()).setIsOpen(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
