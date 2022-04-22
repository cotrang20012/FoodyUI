package hcmute.spkt.nguyenphucan19110321.uidesign.model.DAO;

import android.database.Cursor;

import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.User;

public class UserDAO {
    private Database database;
    public UserDAO(Database database){
        this.database = database;
    }
    public User CheckLogin(User user){
        String[] params = new String[2];
        params[0]=user.getUsername();
        params[1]=user.getPassword();

        Cursor cursor = database.SelectData("select * from Users where username='"+user.getUsername()+
                "' and password='"+user.getPassword()+"'");
        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String avatar = cursor.getString(2);
            String username = cursor.getString(3);
            String password =cursor.getString(4);
            String address=cursor.getString(5);
            String type = cursor.getString(6);
            String phone =cursor.getString(7);
            return new User(id,name,avatar,username,password,address,type,phone);
        }
        return null;
    }
}
