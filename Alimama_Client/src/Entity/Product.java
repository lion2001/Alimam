package Entity;



import java.io.File;
import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private String productID;//id
    private String name;
    private double price;
    private String Introduce;//简介
    private int isAuction;//是否为拍卖商品
    private String buyWay;//0为面谈，1为微信/支付宝。
    private String contact;//0为电话，1为微信，2为QQ。
    private String upUser;//上传者
    private String Buyer;//购买者
    private int sort;//种类
    private int state;//拍卖状态。0为wait，-1为fail，1为succeed
    private String SellTime;
    private String upTime;
    private File image;
    private String imagePath;
    private int number;//商品数量
    private List<String>comments;

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBuyer() {
        return Buyer;
    }

    public void setBuyer(String buyer) {
        Buyer = buyer;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public String getSellTime() {
        return SellTime;
    }

    public void setSellTime(String sellTime) {
        SellTime = sellTime;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public File getImage() {
        return image;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Product(){}

    public int getIsAuction() {
        return isAuction;
    }

    public void setIsAuction(int isAuction) {
        this.isAuction = isAuction;
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
    }

    public String getBuyWay() {
        return buyWay;
    }

    public void setBuyWay(String buyWay) {
        this.buyWay = buyWay;
    }

    public void setUpUser(String upUser) {
        this.upUser = upUser;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public String getUpUser() { return upUser; }



}