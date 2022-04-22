package hcmute.spkt.nguyenphucan19110321.uidesign.model;

import java.io.Serializable;

import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;

public class SaveShop implements Serializable {
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
    public SaveShop(int idShop,int idUser){
       
        this.idShop=idShop;
        this.idUser=idUser;
    }

    public void InsertToDatabase(Database db) {
        String[] params = new String[3];
        params[0] = String.valueOf(this.id);
        params[1] = String.valueOf(this.idShop);
        params[2] = String.valueOf(this.idUser);
        db.ExecQuery("insert into Saveds values(?,?,?)", params);
    }

}
