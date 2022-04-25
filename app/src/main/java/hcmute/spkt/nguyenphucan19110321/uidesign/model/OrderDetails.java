package hcmute.spkt.nguyenphucan19110321.uidesign.model;

import android.os.Parcelable;

import java.io.Serializable;

public class OrderDetails implements Serializable {
    protected int id;
    protected int orderID;
    protected int foodID;
    protected String foodName;
    protected int number;
    protected int price;

    public OrderDetails() {

    }

    public OrderDetails(int id, int orderID, int foodID, String foodName, int number, int price) {
        this.id = id;
        this.orderID = orderID;
        this.foodID = foodID;
        this.foodName = foodName;
        this.number = number;
        this.price = price;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
