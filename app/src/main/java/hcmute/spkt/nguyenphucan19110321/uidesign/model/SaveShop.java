package hcmute.spkt.nguyenphucan19110321.uidesign.model;

public class SaveShop {
    private int id;
    private int idShop;
    private int idUser;

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
    public SaveShop(){}
    public SaveShop(int id,int idShop,int idUser){
        this.id=id;
        this.idShop=idShop;
        this.idUser=idUser;
    }
}
