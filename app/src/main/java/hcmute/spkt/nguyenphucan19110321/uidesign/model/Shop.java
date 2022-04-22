package hcmute.spkt.nguyenphucan19110321.uidesign.model;

import android.database.Cursor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;

public class Shop implements Serializable {
    protected int id;
    protected String name;
    protected String description;
    protected String image;
    protected String imageSearch;
    protected String address;
    protected String type;
    protected double rate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageSearch() {
        return imageSearch;
    }

    public void setImageSearch(String imageSearch) {
        this.imageSearch = imageSearch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Shop() {
    }

    public Shop(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Shop(int id, String name, String description, String image, String imageSearch, String address, String type, double rate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.imageSearch = imageSearch;
        this.address = address;
        this.type = type;
        this.rate = rate;
    }

    public void InsertToDatabase(Database db){
        String[] params = new String[8] ;
        params[0]=String.valueOf(this.id);
        params[1]=this.name;
        params[2]=this.description;
        params[3]=this.image;
        params[4]=this.imageSearch;
        params[5]=this.address;
        params[6]=this.type;
        params[7]=String.valueOf(this.rate);
        db.ExecQuery("insert into Shops values(?,?,?,?,?,?,?,?)",params);
    }

    public List<Food> GetFoodInShop(Database db){
        Cursor cursor = db.SelectData("select * from Foods where idShop="+String.valueOf(this.id));
        List<Food> foodList = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String des = cursor.getString(2);
            String image = cursor.getString(3);
            int price = cursor.getInt(4);
            int idShop = cursor.getInt(5);
            foodList.add(new Food(id, name,des,image,price,idShop));
        }
        return foodList;
    }

}
