package hcmute.spkt.nguyenphucan19110321.uidesign.model;

public class Shop {
    protected String id;
    protected String name;
    protected String description;
    protected String image;
    protected String imageSearch;
    protected String address;
    protected String type;
    protected double rate;


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

    public Shop(String id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Shop(String id, String name, String description, String image, String imageSearch, String address, String type, double rate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.imageSearch = imageSearch;
        this.address = address;
        this.type = type;
        this.rate = rate;
    }

}
