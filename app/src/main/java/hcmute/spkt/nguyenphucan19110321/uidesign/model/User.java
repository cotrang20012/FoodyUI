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
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
    public User(String email, String password){
        this.email=email;
        this.password=password;
    }
    public User(String email,String username, String password,String name){
        this.email =email;
        this.username=username;
        this.password=password;
        this.name=name;
        this.address = "";
        this.gender = "Nam";
        this.phone = "";
        this.avatar = "";
    }

    public User(int id, String name,String avatar,String username,String password,String address,String gender,String phone,String email){
        this.id=id;
        this.name=name;
        this.avatar=avatar;
        this.username=username;
        this.password=password;
        this.address=address;
        this.gender=gender;
        this.phone=phone;
        this.email=email;
    }

    public void InsertToDatabase(Database db) {
        String[] params = new String[8];
        params[0] = this.name;
        params[1] = this.avatar;
        params[2] = this.username;
        params[3] = this.password;
        params[4] = this.address;
        params[5] = this.gender;
        params[6] = this.phone;
        params[7] =this.email;
        db.ExecQuery("insert into Users values(null,?,?,?,?,?,?,?,?)", params);
    }

    public void UpdateProfile(Database db) {
        String[] params = new String[5];
        params[0] = this.name;
        params[1] = this.address;
        params[2] = this.gender;
        params[3] = this.phone;
        params[4] = String.valueOf(this.id);
        db.ExecQuery("Update Users set name=?,address=?,gender=?,phone=? where id=?", params);
    }


}
