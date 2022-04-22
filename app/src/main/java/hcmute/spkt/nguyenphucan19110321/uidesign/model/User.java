package hcmute.spkt.nguyenphucan19110321.uidesign.model;

import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String avatar;
    private String username;
    private String password;
    private String address;
    private String gender;
    private String phone;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public User(String username, String password){
        this.username=username;
        this.password=password;
    }

    public User(int id, String name,String avatar,String username,String password,String address,String gender,String phone){
        this.id=id;
        this.name=name;
        this.avatar=avatar;
        this.username=username;
        this.password=password;
        this.address=address;
        this.gender=gender;
        this.phone=phone;
    }

    public void InsertToDatabase(Database db) {
        String[] params = new String[8];
        params[0] = String.valueOf(this.id);
        params[1] = this.name;
        params[2] = this.avatar;
        params[3] = this.username;
        params[4] = this.password;
        params[5] = this.address;
        params[6] = this.gender;
        params[7] = this.phone;
        db.ExecQuery("insert into Users values(?,?,?,?,?,?,?,?)", params);
    }


}
