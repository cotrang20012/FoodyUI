package hcmute.spkt.nguyenphucan19110321.uidesign.model;

public class Order {
    protected int id;
    protected String name;
    protected int number;
    protected int price;

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
    public Order(){

    }
    public Order(int id, String name, int number, int price) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
    }
}
