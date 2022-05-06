package hcmute.spkt.nguyenphucan19110321.uidesign.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.SaveShop;

public class Database extends SQLiteOpenHelper {
    public static final List<Order> ORDER_LIST = new ArrayList<>();



    public static final void MakeDataOrder(){
        Order order1 = new Order(1,1,"Gogi House - Quán Nướng Hàn Quốc - Saigon Centre",new Date(),53000);
        Order order2 = new Order(2,1,"Bánh Mì Tuấn Mập - Nguyễn Thị Nhỏ",new Date(),60000);
        Order order3 = new Order(3,1,"Pergola - Cafe Nhà Hàng Sân Vườn",new Date(),70000);
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
        db.rawQuery(query,params);
    }

    public long ExecQueryGetID (String tables, ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(tables,"",values);
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
        database.execSQL("DROP TABLE IF EXISTS Notifies");
        database.execSQL("DROP TABLE IF EXISTS Orders");
        database.execSQL("DROP TABLE IF EXISTS OrderDetails");

        database.execSQL("CREATE TABLE IF NOT EXISTS Orders(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " idUser INTEGER,nameShop VARCHAR(150), date DATE,totalNumber INTEGER," +
                "price INTEGER)");
        database.execSQL("CREATE TABLE IF NOT EXISTS OrderDetails(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " orderID INTEGER,foodID INTEGER, foodName VARCHAR(150),number INTEGER," +
                "price INTEGER)");
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
        database.execSQL("CREATE TABLE IF NOT EXISTS Notifies(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idUser INTEGER,title VARCHAR(100), description VARCHAR(250),time Long)");
        database.execSQL("insert into Users values(1,'Trần Duy','','tranduy','12345678','AG','Nam','0398110398','tranduy@gmail.com')");
        SaveShop saveShop = new SaveShop(1,1,1);
        database.execSQL("insert into Saveds values(1,1,1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
