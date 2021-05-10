package Entity;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class UserMessage implements Serializable {
    private  String  Iid;
    private  String IName;
    private  List<Product> ICollection;
    private  List<Product> ISellTable;
    private  List<Product> IAuction;
    private  File IPhoto;
    private  List<Message> IChat;
    private  List<User>IChatObject;
    private  HashMap<User, Message>IChatMsg;
    private  List<Product> IShowPro;

    public  List<Product> getIShowPro() {
        return IShowPro;
    }

    public  void setIShowPro(List<Product> IShowPro) {
        this.IShowPro = IShowPro;
    }


    public String getIid() {
        return Iid;
    }

    public void setIid(String iid) {
        Iid = iid;
    }

    public String getIName() {
        return IName;
    }

    public void setIName(String IName) {
        this.IName = IName;
    }

    public List<Product> getICollection() {
        return ICollection;
    }

    public void setICollection(List<Product> ICollection) {
        this.ICollection = ICollection;
    }

    public List<Product> getISellTable() {
        return ISellTable;
    }

    public void setISellTable(List<Product> ISellTable) {
        this.ISellTable = ISellTable;
    }

    public List<Product> getIAuction() {
        return IAuction;
    }

    public void setIAuction(List<Product> IAuction) {
        this.IAuction = IAuction;
    }


    public File getIPhoto() {
        return IPhoto;
    }

    public void setIPhoto(File IPhoto) {
        this.IPhoto = IPhoto;
    }

    public  List<Message> getIChat() {
        return IChat;
    }

    public  void setIChat(List<Message> IChat) {
        this.IChat = IChat;
    }

    public List<User> getIChatObject() {
        return IChatObject;
    }

    public  void setIChatObject(List<User> IChatObject) {
        this.IChatObject = IChatObject;
    }
}
