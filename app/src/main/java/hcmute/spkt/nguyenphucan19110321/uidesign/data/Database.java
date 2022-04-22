package hcmute.spkt.nguyenphucan19110321.uidesign.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.SaveShop;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.User;

public class Database extends SQLiteOpenHelper {
    public static final List<Order> ORDER_LIST = new ArrayList<>();



    public static final void MakeDataOrder(){
        Order order1 = new Order(1,"Chân gà xé",2,53000);
        Order order2 = new Order(2,"Chân gà nướng",3,60000);
        Order order3 = new Order(3,"Chân gà xé",1,70000);
        ORDER_LIST.add(order1);
        ORDER_LIST.add(order3);
        ORDER_LIST.add(order2);
    }

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void ExecQuery(String query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }
    public void ExecQuery(String query,String[] params) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query,params);
    }

    public Cursor SelectData(String query) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor SelectData(String query,String[] params) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(query,params);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("DROP TABLE IF EXISTS Users");
        database.execSQL("DROP TABLE IF EXISTS Foods");
        database.execSQL("DROP TABLE IF EXISTS Shops");
        database.execSQL("DROP TABLE IF EXISTS Saveds");
        database.execSQL("CREATE TABLE IF NOT EXISTS Users(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR(50),avatar VARCHAR(150), username VARCHAR(30),password VARCHAR(30)," +
                "address VARCHAR(150), gender VARCHAR(5), phone VARCHAR(14),email VARCHAR(44) )");
        database.execSQL("CREATE TABLE IF NOT EXISTS Foods(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR(50), description VARCHAR(30),image VARCHAR(150),price INTEGER," +
                "idShop INTEGER )");
        database.execSQL("CREATE TABLE IF NOT EXISTS Shops(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR(50), description VARCHAR(30),image VARCHAR(150),imagesearch VARCHAR(150)" +
                ",address VARCHAR(100),type VARCHAR(100),rate FLOAT(16))");
        database.execSQL("CREATE TABLE IF NOT EXISTS Saveds(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idShop INTEGER, idUser INTEGER)");
        database.execSQL("insert into Users values(1,'Trần Duy','','tranduy','12345678','AG','Nam','0398110398','tranduy@gmail.com')");
        SaveShop saveShop = new SaveShop(1,1,1);
        database.execSQL("insert into Saveds values(1,1,1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
