package tools.addComment;

import Entity.IUser;
import Entity.Message;
import tools.ManageClientConServerThread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddComment extends Thread {
    Socket socket;
    Message message;
    public AddComment(Message message){
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

