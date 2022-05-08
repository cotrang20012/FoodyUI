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

import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.SaveShop;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;

public class Database extends SQLiteOpenHelper {
    public static final List<Order> ORDER_LIST = new ArrayList<>();


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
                " idUser INTEGER,nameShop VARCHAR(150), date LONG,totalNumber INTEGER," +
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
        database.execSQL("insert into Saveds values(1,1,1)");

        database.execSQL("insert into Shops values(null,'Gogi House - Quán Nướng Hàn Quốc - Saigon Centre'," +
                "'Vài ngày là lại tới gogi một lần nè, món ăn thì khỏi bàn luônnnn, nhân viên thì nhiệt tình, anh chị quản lý dễ thương xĩu luôn'," +
                "'https://images.foody.vn/res/g25/248319/prof/s640x400/foody-upload-api-foody-mobile-1-200408093229.jpg'," +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg'," +
                        "'94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM', 'Shop Online', 9.4)");

        database.execSQL("insert into Shops values(null, 'Thành Mập - Chân Gà Rút Xương Ngâm Sả Tắc - Bạch Đằng - Shop Online'," +
                "'Đồ ăn ngon xĩu luônnnn =))))))))','https://images.foody.vn/res/g100/990502/prof/s640x400/foody-upload-api-foody-mobile-foody-upload-api-foo-191216172331.jpg'," +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg'," +
                "'94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM', 'Shop Online', 9.4)");

        database.execSQL("insert into Shops values(null,'Bánh Mì Tuấn Mập - Nguyễn Thị Nhỏ'," +
                " 'Ship toàn Thủ Đức', 'https://images.foody.vn/res/g4/32218/prof/s640x400/foody-mobile-banh-mi-tuan-map-tp-hcm.jpg', " +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg'," +
                        "'94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM', 'Shop Online', 9.4)");
        database.execSQL("insert into Shops values(null,'Pergola - Cafe Nhà Hàng Sân Vườn'," +
                "'Đồ ăn vừa miệng , trang trí bắt mắt. Món này cùng với món cá là mình thích nhất , bánh creps " +
                "nhân khoai môn không ngon lắm các món còn lại thì ok. Nhà hàng bên trong hẻm hơi khó tìm một chút , đợt chung ...', " +
                "'https://images.foody.vn/res/g1/342/prof/s640x400/foody-mobile-pergola-jpg-490-635683258471725878.jpg', " +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg', " +
                        "'94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM', 'Shop Online', 9.4)");

        database.execSQL("insert into Shops values(null,'Tân Hương Nam Quán - Mì Sụa Bạc Liêu & Bánh Canh', " +
                "'Không hiểu quán nghĩ gì mà giao phần sườn cho khách như vậy luôn, cây sườn nó còn dài hơn hộp," +
                " nếu ko biết suy nghĩ cho khách thì ít nhất phải chặt ra cho giống hình minh hoạ chứ ạ? Hên là ăn ở nhà, còn ...', " +
                "'https://images.foody.vn/res/g17/161419/prof/s640x400/foody-upload-api-foody-mobile-foody-tan-huong-nam--190104172143.jpg', " +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg', " +
                        "'94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM', 'Shop Online', 9.4)");

        database.execSQL("insert into Shops values(null, 'Chilli Thai - Lý Tự Trọng', " +
                "'Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa'," +
                "'https://images.foody.vn/res/g102/1012534/prof/s640x400/file_restaurant_photo_sufy_16340-d0277df5-211012232712.jpg', " +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg', " +
                "'94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM', 'Shop Online', 9.4)");
        Shop s7 = new Shop(7, "Lẩu & Nướng Khánh Hoàng",
                "Quán có cách tính tiền rất buồn cười :)))",
                "https://images.foody.vn/res/g5/46860/prof/s640x400/foody-mobile-lau-de-khanh-hoang-vinh-vien-tp-hcm-140102114559.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);

        Shop s8 = new Shop(8, "Phở 247",
                "Moi lan order la hon 10 phan the nay day,do nha quan so dong ma lai la rat ghien an pho",
                "https://images.foody.vn/res/g2/11414/prof/s640x400/foody-mobile-ue1xq7j3-jpg-176-636195529268772963.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);
        database.execSQL("insert into Shops values(null,?,?,?,?,?,?,?)", s7.ToParams());
        database.execSQL("insert into Shops values(null,?,?,?,?,?,?,?)", s8.ToParams());

        Food f1 = new Food(1, "Combo Cơm Trộn Hàn Quốc Sốt Gogi",
                "Cơm trộn hàn quốc sốt Gogi (400g),Chén canh rong biển (120ml)," +
                        "Kim chi cải thảo (50g),Panchan rong biển (50g). Giá đã bao gồm 10% VAT.",
                "https://images.foody.vn/res/g100/997226/s120x120/7a9ab620-d30b-485b-8919-f746d16b-9051af10-200910160958.jpeg",
                106000, 1);
        Food f2 = new Food(2, "Combo Cơm Ba Chỉ Bò Mỹ",
                "Salad cá ngừ Deli (73g),Ba chỉ bò mỹ sốt mật ong (100g),Cơm trắng (180g),Chén canh rong biển (120ml),Kim chi cải thảo (50g),Panchan rong biển (50g)",
                "https://images.foody.vn/res/g100/997226/s120x120/f30ae839-662d-4eaf-907b-91ec620d-4c5708f6-200910160859.jpeg",
                106000, 1);
        Food f3 = new Food(3, "Combo Cơm Trộn Hàn Quốc",
                "Cơm trộn hàn quốc (400g),Chén canh rong biển (120ml),Kim chi cải thảo (50g),Panchan rong biển (50g).",
                "https://images.foody.vn/res/g100/997226/s120x120/1cb1fa3d-820f-40a3-81d7-2e8e839f-db3179ef-200910161153.jpeg",
                106000, 1);

        Food f4 = new Food(4, "Chân gà rút xương ngâm sả tắc - Hộp lớn", "Hộp 500gr chân gà rút xương, kèm nước chấm siêu ngon",
                "https://images.foody.vn/res/g78/771236/s120x120/ad9be13a-628b-4cbf-b498-6a13028cf516.jpg",
                210000, 2);
        Food f5 = new Food(5, "Chân gà rút xương ngâm sả tắc - Hộp nhỏ", "Hộp 250gr chân gà rút xương, kèm nước chấm siêu ngon",
                "https://images.foody.vn/res/g78/771236/s120x120/ad9be13a-628b-4cbf-b498-6a13028cf516.jpg",
                110000, 2);
        Food f6 = new Food(5, "Chân gà ngâm sả tắc - Hộp lớn",
                "Hộp 500gr chân gà, kèm nước chấm siêu ngon.",
                "https://images.foody.vn/res/g78/771236/s120x120/b426425e-dcf9-468f-90ea-672d0d20b470.jpg",
                130000, 2);
        Food f7 = new Food(5, "Chân gà ngâm sả tắc - Hộp nhỏ",
                "Hộp 500gr chân gà, kèm nước chấm siêu ngon.",
                "https://images.foody.vn/res/g78/771236/s120x120/b426425e-dcf9-468f-90ea-672d0d20b470.jpg",
                65000, 2);
        Food f8 = new Food(5, "COMBO 2 hộp chân gà ( có xương + rút xương ) ngâm",
                "2 hộp nhỏ",
                "https://images.foody.vn/res/g78/771236/s120x120/d2f5110d-1c6f-4075-a5f0-d9cd3c05ec51.jpg",
                165000, 2);

        //Shop 3
        Food f9 = new Food(5, "Bánh mì đặc biệt",
                "Bánh mì đặc biệt",
                "https://images.foody.vn/res/g8/72633/s120x120/2018912141138-hryh.jpg",
                25000, 3);
        Food f10 = new Food(5, "Bánh mì chả bò",
                "Bánh mì chả bò",
                "https://images.foody.vn/res/g8/72633/s120x120/2018122214036-ba%cc%81nh-mi%cc%80-cha%cc%89-bo%cc%80.jpg",
                20000, 3);
        Food f11 = new Food(5, "Xôi mặn",
                "Xôi mặn",
                "https://images.foody.vn/res/g8/72633/s120x120/20181031105419-xoi-man.jpg",
                15000, 3);
        Food f12 = new Food(5, "Bánh mì heo quay",
                "Bánh mì heo quay",
                "https://images.foody.vn/res/g8/72633/s120x120/201891214121-banh-mi-heo-quay.jpg",
                20000, 3);
        Food f13 = new Food(5, "Bánh mì chả lụa",
                "Bánh mì chả lụa",
                "https://images.foody.vn/res/g8/72633/s120x120/201812221434-ba%cc%81nh-mi%cc%80-cha%cc%89-lu%cc%a3a.jpg",
                20000, 3);

        Food f14 = new Food(5, "Cafe đen đá",
                "Cafe đen đá",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                38000, 4);
        Food f15 = new Food(5, "Cafe sửa đá",
                "Cafe sửa đá",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        Food f16 = new Food(5, "Cappuccino",
                "Cappuccino",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        Food f17 = new Food(5, "Machiato",
                "Machiato",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        Food f18 = new Food(5, "Espresso",
                "Espresso",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        Food f19 = new Food(5, "Flan coffee",
                "Cafe, caramel, bột sữa, kem, bánh flan",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 4);
        Food f20 = new Food(5, "Coconut coffee",
                "Cafe, kem sữa, cơm dừa, vani, kem",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                65000, 4);
        Food f21 = new Food(5, "Frappuccino",
                "Caramel/ socola, sữa tươi, kemo",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                75000, 4);
        //Shop 5
        Food f22 = new Food(5, "Bánh canh thập cẩm",
                "Bánh canh thập cẩm",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        Food f23 = new Food(5, "Bún bò cay Bạc Liêu",
                "Bò cay đặc biệt",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        Food f24 = new Food(5, "Bánh canh chả ngũ vị (5 loại chả)",
                "Bánh canh đặc biệt",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        Food f25 = new Food(5, "Hủ tiếu hải sản",
                "Hủ tiếu đặc biệt",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        Food f26 = new Food(5, "Hủ tiếu chả ngũ vị hoàng kim (Khô)",
                "Hủ tiếu đặc biệt",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        Food f27 = new Food(5, "Trà tắc",
                "Đồ uống",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                15000, 5);
        Food f28 = new Food(5, "Trà dâu",
                "Đồ uống",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                25000, 5);
        //Shop 6
        Food f29 = new Food(5, "Gỏi cá trê truyền thống Thái",
                "Giá đã bao gồm 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129115414-img_8581.jpg",
                120000, 6);
        Food f30 = new Food(5, "Gỏi miến hải sản",
                "Giá đã bao gồm 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129115628-img_8788.jpg",
                165000, 6);
        Food f31 = new Food(5, "Gỏi đu đủ tôm khô trứng muối",
                "Giá đã bao gồm 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129115434-img_8595.jpg",
                100000, 6);
        Food f32 = new Food(5, "Salad trứng lòng đào với thịt bằm thính",
                "Giá đã bao gồm 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/201812911556-img_8661.jpg",
                95000, 6);
        Food f33 = new Food(5, "Nọng heo nướng mật ong",
                "Giá đã bao gồm 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/1ebb853e-3578-475d-8d27-1c8504ba9da4.jpg",
                190000, 6);
        Food f34 = new Food(5, "Mực nướng với sauce me & đậu phộng",
                "Giá đã bao gồm 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/71fc0481-9b18-4b2a-a6dc-434f7bf3-654c5230-211109134633.jpeg",
                323000, 6);
        Food f35 = new Food(5, "Cá chẽm nguyên con chiên giòn sốt Chilli Thái",
                "Giá đã bao gồm 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129113319-img_9108.jpg",
                250000, 6);

        //Shop 7
        Food f36 = new Food(5, "Tuỷ bò sốt Hong Kong",
                "Giá đã bao gồm 10% VAT",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                120000, 7);
        Food f37 = new Food(5, "Combo thịt nai vú dê nướng",
                "Rau muống, đậu bắp đi kèm",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                150000, 7);
        Food f38= new Food(5, "Lẩu Giò Heo Chao Đỏ",
                "Rau mì hủ tíu đi kèm",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                200000, 7);
        Food f39 = new Food(5, "Lẩu Đầu Cá",
                "Rau mì hủ tíu đi kèm",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                200000, 7);
        Food f40 = new Food(5, "Sườn dê nướng",
                "Sườn dê nướng",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                210000, 7);
        Food f41 = new Food(5, "Vú dê nướng",
                "Rau muống đậu bắp đi kèm",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                135000, 7);

        //Shop 8
        Food f42 = new Food(5, "Hủ Tiếu Bò Viên",
                "Hủ Tiếu Bò Viên",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                40000, 8);
        Food f43 = new Food(5, "Bún bò Huế đặc biệt ",
                "Bún bò Huế đặc biệt ",
                "https://images.foody.vn/res/g108/1073753/s120x120/67ecbdb9-1107-40f7-a574-44ac9406-77bcaf25-210415122104.jpeg",
                55000, 8);
        Food f44 = new Food(5, "Bún bò Huế tái nạm",
                "Bún bò Huế tái nạm",
                "https://images.foody.vn/res/g108/1073753/s120x120/67ecbdb9-1107-40f7-a574-44ac9406-77bcaf25-210415122104.jpeg",
                45000, 8);
        Food f45 = new Food(5, "Bún bò Huế thường",
                "Bún bò Huế thường",
                "https://images.foody.vn/res/g108/1073753/s120x120/67ecbdb9-1107-40f7-a574-44ac9406-77bcaf25-210415122104.jpeg",
                40000, 8);
        Food f46 = new Food(5, "Trà Tắc Xí Muội",
                "Trà Tắc Xí Muội",
                "https://images.foody.vn/res/g108/1073753/s120x120/2b5670be-dcb9-455c-b2bf-7461b046-78efab04-210415122446.jpeg",
                20000, 8);
        Food f47 = new Food(5, "Trà Tắc ",
                "Trà Tắc ",
                "https://images.foody.vn/res/g108/1073753/s120x120/2b5670be-dcb9-455c-b2bf-7461b046-78efab04-210415122446.jpeg",
                15000, 8);

        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f1.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f2.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f3.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f4.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f5.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f6.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f7.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f8.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f9.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f10.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f11.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f12.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f13.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f14.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f15.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f16.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f17.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f18.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f19.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f20.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f21.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f22.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f23.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f24.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f25.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f26.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f27.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f28.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f29.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f30.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f31.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f32.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f33.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f34.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f35.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f36.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f37.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f38.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f39.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f40.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f41.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f42.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f43.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f44.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f45.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f46.toParams());
        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f47.toParams());

    }


    public void test(){

        Food f7 = new Food(7, "Test 7", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 3);
        Food f8 = new Food(8, "Test 8", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 4);
        Food f9 = new Food(9, "Test 9", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 4);

        Food f10 = new Food(10, "Test 10", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 5);
        Food f11 = new Food(11, "Test 5", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 6);
        Food f12 = new Food(12, "Test 6", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 6);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
