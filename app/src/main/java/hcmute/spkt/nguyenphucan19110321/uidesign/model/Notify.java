package hcmute.spkt.nguyenphucan19110321.uidesign.model;

import java.util.Date;

import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;

public class Notify {
    protected int id;
    protected int idUser;
    protected String title;
    protected String description;
    protected Date time;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public Notify(){}

    public Notify(int id,int idUser, String title,String description,Date time){
        this.id=id;
        this.idUser=idUser;
        this.description=description;
        this.time=time;
        this.title=title;
    }
    public Notify(int idUser, String title,String description,Date time){
        this.id=id;
        this.idUser=idUser;
        this.description=description;
        this.time=time;
        this.title=title;
    }

    public void InsertToDatabase(Database db){
        String[] params =new String[5];
        params[0] = null;
        params[1]=String.valueOf(this.idUser);
        params[2]=this.title;
        params[3]=this.description;
        params[4]=String.valueOf(this.time.getTime());
        db.ExecQuery("Insert into Notifies values(?,?,?,?,?)",params);
    }
}
