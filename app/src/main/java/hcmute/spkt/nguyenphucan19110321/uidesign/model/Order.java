package hcmute.spkt.nguyenphucan19110321.uidesign.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    protected int id;
    protected int idUser;
    protected String nameShop;
    protected Date time;
    protected int totalNumber;
    protected int price;

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Order(){

    }
    public Order(int id,int idUser, String nameShop, Date time, int price, int totalNumber) {
        this.id = id;
        this.idUser=idUser;
        this.nameShop = nameShop;
        this.time = time;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    public Order(int id, int idUser, String nameShop, Date time, int price) {
        this.id = id;
        this.idUser = idUser;
        this.nameShop = nameShop;
        this.time = time;
        this.price = price;
    }
}
