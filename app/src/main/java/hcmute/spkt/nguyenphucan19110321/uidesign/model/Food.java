package hcmute.spkt.nguyenphucan19110321.uidesign.model;

public class Food {
    protected String id;
    protected String name;
    protected String description;
    protected String image;
    protected int price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Food(String id, String name, String des, String img, int price){
        this.id = id;
        this.name = name;
        this.description = des;
        this.image=img;
        this.price = price;
    }
}
