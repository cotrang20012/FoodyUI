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
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;

public class Database extends SQLiteOpenHelper {
    public static final List<Shop> SHOP_LIST = new ArrayList<>();
    public static final List<Food> FOOD_LIST = new ArrayList<>();
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
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
