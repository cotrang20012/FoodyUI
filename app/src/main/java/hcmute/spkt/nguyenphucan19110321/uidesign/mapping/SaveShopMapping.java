package hcmute.spkt.nguyenphucan19110321.uidesign.mapping;

public class SaveShopMapping {
    private int id;
    private int idShop;
    private int idUser;
    private String nameShop;
    private String image;
    private String address;
    private String type;
    private double rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public SaveShopMapping(int id,int idShop,int idUser,String nameShop,String image,String address,String type,double rate){
        this.id=id;
        this.idShop=idShop;
        this.idUser=idUser;
        this.nameShop = nameShop;
        this.image = image;
        this.address = address;
        this.type = type;
        this.rate=rate;
    }
}
