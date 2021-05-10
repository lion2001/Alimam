package Entity;

import java.io.File;
import java.util.*;

public class IUser {
    private static String  Iid;
    private static String IName;
    private static List<Product> ICollection;
    private static List<Product> ISellTable;
    private static List<Product> IAuction;
    private static Map<String,Product> IAuctionSell=new HashMap<String,Product>();
    private static List<Product> IShowPro;
    private static File IPhoto;
    private static List<Message> IChat;
    private static List<User>IChatObject;
    private static Map<String, List<Message>> IChatMsg=new HashMap<String,List<Message>>();

    public static List<Product> getIShowPro() {
        return IShowPro;
    }

    public static void setIShowPro(List<Product> IShowPro) {
        IUser.IShowPro = IShowPro;
        if(IUser.IShowPro==null){
            IUser.IShowPro=new ArrayList<>();
        }
    }

    public static Map<String, Product> getIAuctionSell() {
        return IAuctionSell;
    }

    public static void setIAuctionSell() {
        Iterator<Product> iterator=IUser.getIAuction().iterator();
        System.out.println("start");
        while (iterator.hasNext()){
            Product product=iterator.next();
            if(product.getUpUser().equals(IUser.getIid())){
                if(IAuctionSell.containsKey(product.getProductID())) {
                    if (IAuctionSell.get(product.getProductID()).getState() < product.getState()) {
                        IAuctionSell.get(product.getProductID()).setState(product.getState());
                    }
                }else {
                    IAuctionSell.put(product.getProductID(), product);
                }
            }
        }

    }

    public static List<Product> getPro(List<Product>products){
        List<Product>products1=new ArrayList<>();
        int size=products.size();
        for(int i=0;i<size;i++){
            if(products.get(i).getIsAuction()==1){

            }else{
                products1.add(products.get(i));
            }
        }
        return products1;
    }
    public static List<Product> getAuction(List<Product>products){
        List<Product>products1=new ArrayList<>();
        int size=products.size();
        for(int i=0;i<size;i++){
            if(products.get(i).getIsAuction()==1) {
                products1.add(products.get(i));
            }
        }
        return products1;
    }
    public static Map<String,List<Message>> getIChatMsg() {
        return IChatMsg;
    }


    public static void setIChatMsg() {
        Iterator<Message> iterator=IUser.getIChat().iterator();
        while (iterator.hasNext()){
            String friend;
            Message message=iterator.next();
            if(message.getGetter().equals(Iid)){
                friend=message.getSender();
            }else {
                friend=message.getGetter();
            }
            if(!IChatMsg.containsKey(friend)){
                List<Message>messages=new ArrayList<>();
                IUser.IChatMsg.put(friend, messages);
                messages.add(message);
            }else{
                List<Message>m=IChatMsg.get(friend);
                m.add(message);
            }
        }


    }

    public static String getIName() {
        return IName;
    }

    public static void setIName(String iName) {
        IName = iName;
    }

    public static List<Product> getICollection() {
        return ICollection;
    }

    public static void setICollection(List<Product> ICollection) {
        IUser.ICollection = ICollection;
        if(ICollection==null){
            IUser.ICollection=new ArrayList<>();
        }
    }

    public static List<Product> getISellTable() {
        return ISellTable;
    }

    public static void setISellTable(List<Product> ISellTable) {
        IUser.ISellTable = ISellTable;
        if(ISellTable==null){
            ISellTable=new ArrayList<>();
        }
    }

    public static List<Product> getIAuction() {
        return IAuction;
    }

    public static void setIAuction(List<Product> IAuction) {
        IUser.IAuction = IAuction;
        if(IAuction==null){
            IAuction=new ArrayList<>();
        }
        IUser.setIAuctionSell();
    }

    public static void setIPhoto(File IPhoto) {
        IUser.IPhoto = IPhoto;
    }

    public static File getIPhoto() {
        return IPhoto;
    }

    public static List<Message> getIChat() {
        return IChat;
    }

    public static void setIChat(List<Message> IChat) {
        IUser.IChat = IChat;
        if(IChat==null){
            IUser.IChat=new ArrayList<>();
        }
    }

    public static List<User> getIChatObject() {
        return IChatObject;
    }

    public static void setIChatObject(List<User> IChatObject) {
        IUser.IChatObject = IChatObject;
        if(IChatObject==null){
            IUser.IChatObject=new ArrayList<>();
        }
    }

    public static String getIid() {
        return Iid;
    }

    public static void setIid(String iid) {
        Iid = iid;
    }
}
