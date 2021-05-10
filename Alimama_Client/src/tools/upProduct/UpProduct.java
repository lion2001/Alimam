package tools.upProduct;

import Entity.IUser;
import Entity.Message;
import Entity.Product;
import tools.ManageClientConServerThread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static Entity.MessageType.message_up_product;

public class UpProduct extends Thread{
    Message message;
    Product product;
    public UpProduct(Product product){
        this.product=product;
    }
    public void run(){
        System.out.println("UP");
     message=new Message();
     message.setSender(IUser.getIid());
     product.setUpUser(IUser.getIid());
     message.setProduct(product);
     message.setMesType(message_up_product);
        try {
            ObjectOutputStream oos=new ObjectOutputStream(ManageClientConServerThread.getClientConServerThread(IUser.getIid()).getS().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
