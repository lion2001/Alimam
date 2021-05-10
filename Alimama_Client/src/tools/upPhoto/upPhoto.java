package tools.upPhoto;

import Entity.IUser;
import Entity.Message;
import Entity.Product;
import tools.ManageClientConServerThread;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static Entity.MessageType.message_up_photo;

public class upPhoto extends Thread{
    Socket socket;
    private String imagePath;
    private File image;
    public upPhoto(String imagePath,File image){
        this.image=image;
        this.imagePath=imagePath;
        socket= ManageClientConServerThread.getClientConServerThread(IUser.getIid()).getS();
    }
    public void run(){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            Product product=new Product();
            product.setImage(image);
            product.setImagePath(imagePath);
            Message message=new Message();
            message.setMesType(message_up_photo);
            message.setProduct(product);
            message.setSender(IUser.getIid());

            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
