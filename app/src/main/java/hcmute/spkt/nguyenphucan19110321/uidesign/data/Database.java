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
        database.execSQL("insert into Users values(1,'Tr???n Duy','','tranduy','12345678','AG','Nam','0398110398','tranduy@gmail.com')");
        database.execSQL("insert into Saveds values(1,1,1)");

        database.execSQL("insert into Shops values(null,'Gogi House - Qu??n N?????ng H??n Qu???c - Saigon Centre'," +
                "'V??i ng??y l?? l???i t???i gogi m???t l???n n??, m??n ??n th?? kh???i b??n lu??nnnn, nh??n vi??n th?? nhi???t t??nh, anh ch??? qu???n l?? d??? th????ng x??u lu??n'," +
                "'https://images.foody.vn/res/g25/248319/prof/s640x400/foody-upload-api-foody-mobile-1-200408093229.jpg'," +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg'," +
                        "'94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM', 'Shop Online', 9.4)");

        database.execSQL("insert into Shops values(null, 'Th??nh M???p - Ch??n G?? R??t X????ng Ng??m S??? T???c - B???ch ?????ng - Shop Online'," +
                "'????? ??n ngon x??u lu??nnnn =))))))))','https://images.foody.vn/res/g100/990502/prof/s640x400/foody-upload-api-foody-mobile-foody-upload-api-foo-191216172331.jpg'," +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg'," +
                "'94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM', 'Shop Online', 9.4)");

        database.execSQL("insert into Shops values(null,'B??nh M?? Tu???n M???p - Nguy???n Th??? Nh???'," +
                " 'Ship to??n Th??? ?????c', 'https://images.foody.vn/res/g4/32218/prof/s640x400/foody-mobile-banh-mi-tuan-map-tp-hcm.jpg', " +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg'," +
                        "'94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM', 'Shop Online', 9.4)");
        database.execSQL("insert into Shops values(null,'Pergola - Cafe Nh?? H??ng S??n V?????n'," +
                "'????? ??n v???a mi???ng , trang tr?? b???t m???t. M??n n??y c??ng v???i m??n c?? l?? m??nh th??ch nh???t , b??nh creps " +
                "nh??n khoai m??n kh??ng ngon l???m c??c m??n c??n l???i th?? ok. Nh?? h??ng b??n trong h???m h??i kh?? t??m m???t ch??t , ?????t chung ...', " +
                "'https://images.foody.vn/res/g1/342/prof/s640x400/foody-mobile-pergola-jpg-490-635683258471725878.jpg', " +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg', " +
                        "'94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM', 'Shop Online', 9.4)");

        database.execSQL("insert into Shops values(null,'T??n H????ng Nam Qu??n - M?? S???a B???c Li??u & B??nh Canh', " +
                "'Kh??ng hi???u qu??n ngh?? g?? m?? giao ph???n s?????n cho kh??ch nh?? v???y lu??n, c??y s?????n n?? c??n d??i h??n h???p," +
                " n???u ko bi???t suy ngh?? cho kh??ch th?? ??t nh???t ph???i ch???t ra cho gi???ng h??nh minh ho??? ch??? ???? H??n l?? ??n ??? nh??, c??n ...', " +
                "'https://images.foody.vn/res/g17/161419/prof/s640x400/foody-upload-api-foody-mobile-foody-tan-huong-nam--190104172143.jpg', " +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg', " +
                        "'94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM', 'Shop Online', 9.4)");

        database.execSQL("insert into Shops values(null, 'Chilli Thai - L?? T??? Tr???ng', " +
                "'????? ??n kh?? ngon nh??ng th??i ????? ph???c v??? nh??n vi??n r???t t???, l???n sau s??? ko ???ng h??? n???a'," +
                "'https://images.foody.vn/res/g102/1012534/prof/s640x400/file_restaurant_photo_sufy_16340-d0277df5-211012232712.jpg', " +
                "'https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg', " +
                "'94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM', 'Shop Online', 9.4)");
        Shop s7 = new Shop(7, "L???u & N?????ng Kh??nh Ho??ng",
                "Qu??n c?? c??ch t??nh ti???n r???t bu???n c?????i :)))",
                "https://images.foody.vn/res/g5/46860/prof/s640x400/foody-mobile-lau-de-khanh-hoang-vinh-vien-tp-hcm-140102114559.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM", "Shop Online", 9.4);

        Shop s8 = new Shop(8, "Ph??? 247",
                "Moi lan order la hon 10 phan the nay day,do nha quan so dong ma lai la rat ghien an pho",
                "https://images.foody.vn/res/g2/11414/prof/s640x400/foody-mobile-ue1xq7j3-jpg-176-636195529268772963.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM", "Shop Online", 9.4);
        Shop s9 = new Shop(9, "Baoz Dimsum Restaurant - Nguy???n Tri Ph????ng",
                "Dimsum v??? m??nh th?????ng , ??a s??? m??nh th???y ch??? n??o b??n dimsum v??? c???ng na n?? nhau , kh?? m?? so s??nh ???????c , nh??ng m?? ????? ??? ????y b??? ngu???i qu?? n??n m???t ngon.... ",
                "https://images.foody.vn/res/g12/112526/prof/s640x400/foody-mobile-baoz-mb-jpg-453-635736957180348888.jpg",
                "https://images.foody.vn/res/g12/112526/prof/s640x400/foody-mobile-baoz-mb-jpg-453-635736957180348888.jpg",
                "94/22/2A Ph?? Th??? H??a, P. Ph?? Th??? H??a, TP.Th??? ?????c, TP.HCM", "Shop Online", 9.4);
        Shop s10 = new Shop(10, "G?? R??n KFC - L?? V??n Vi???t",
                "Moi lan order la hon 10 phan the nay day,do nha quan so dong ma lai la rat ghien an pho",
                "https://images.foody.vn/res/g4/34452/prof/s640x400/foody-upload-api-foody-mobile-jhjhjh-190612140554.jpg",
                "https://images.foody.vn/res/g4/34452/prof/s640x400/foody-upload-api-foody-mobile-jhjhjh-190612140554.jpg",
                "193 L?? V??n Vi???t, P. Hi???p Ph??,  Qu???n 9, TP. HCM", "Shop Online", 8.4);
        database.execSQL("insert into Shops values(null,?,?,?,?,?,?,?)", s7.ToParams());
        database.execSQL("insert into Shops values(null,?,?,?,?,?,?,?)", s8.ToParams());
        database.execSQL("insert into Shops values(null,?,?,?,?,?,?,?)", s9.ToParams());
        database.execSQL("insert into Shops values(null,?,?,?,?,?,?,?)", s10.ToParams());


        List<Food> foodList = new ArrayList<>();
        Food f1 = new Food(1, "Combo C??m Tr???n H??n Qu???c S???t Gogi",
                "C??m tr???n h??n qu???c s???t Gogi (400g),Ch??n canh rong bi???n (120ml)," +
                        "Kim chi c???i th???o (50g),Panchan rong bi???n (50g). Gi?? ???? bao g???m 10% VAT.",
                "https://images.foody.vn/res/g100/997226/s120x120/7a9ab620-d30b-485b-8919-f746d16b-9051af10-200910160958.jpeg",
                106000, 1);
        foodList.add(f1);
        Food f2 = new Food(2, "Combo C??m Ba Ch??? B?? M???",
                "Salad ca?? ng???? Deli (73g),Ba ch??? b?? m??? s???t m???t ong (100g),C??m tr???ng (180g),Ch??n canh rong bi???n (120ml),Kim chi c???i th???o (50g),Panchan rong bi???n (50g)",
                "https://images.foody.vn/res/g100/997226/s120x120/f30ae839-662d-4eaf-907b-91ec620d-4c5708f6-200910160859.jpeg",
                106000, 1);
        foodList.add(f2);
        Food f3 = new Food(3, "Combo C??m Tr???n H??n Qu???c",
                "C??m tr???n h??n qu???c (400g),Ch??n canh rong bi???n (120ml),Kim chi c???i th???o (50g),Panchan rong bi???n (50g).",
                "https://images.foody.vn/res/g100/997226/s120x120/1cb1fa3d-820f-40a3-81d7-2e8e839f-db3179ef-200910161153.jpeg",
                106000, 1);
        foodList.add(f3);
        Food f51 = new Food(3, "Combo C??m G???u B?? S???t M???t Ong",
                "Salad t????ng h????p Deli (85g),G???u b?? M??? s???t m???t ong (100g),C??m tr???ng (180g),Ch??n canh rong bi???n (120ml),Kim chi c???i th???o (50g),Panchan rong bi???n (50g)",
                "https://images.foody.vn/res/g100/997226/s120x120/f895e7c6-5f70-4a3f-bcca-03d97d5b-abd420ba-200910161128.jpeg",
                106000, 1);
        foodList.add(f51);
        Food f52 = new Food(3, "Combo Kimbap Ha??n Qu????c",
                "Salad hoa qua?? Deli (169g),Kimbap (1 ph???n),Ch??n canh rong bi???n (120ml), Kim chi c???i th???o (50g),Panchan rong bi???n (50g)",
                "https://images.foody.vn/res/g100/997226/s120x120/b5ab9d9a-49bc-4182-aea7-93cbdacc-ef69e5e8-200910160931.jpeg",
                106000, 1);
        foodList.add(f52);
        Food f53 = new Food(3, "Combo C??m Ba Ch??? Heo S???t Obathan",
                "Salad hoa qua?? Deli (169g),Ba ch??? heo s???t Obathan (100g),C??m tr???ng (180g),Ch??n canh rong bi???n (120ml),Kim chi c???i th???o (50g),Panchan rong bi???n (50g)",
                "https://images.foody.vn/res/g100/997226/s120x120/8808390f-8792-420c-8d0e-44353887-98651866-200910161029.jpeg",
                106000, 1);
        foodList.add(f53);
        Food f54 = new Food(3, "Canh Kim Chi",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g100/997226/s120x120/b9adb3d8-3544-416c-a212-0efe70cdcd84.jpg",
                96000, 1);
        foodList.add(f54);
        Food f55 = new Food(3, "Canh Th???t B?? Bulgogi",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g100/997226/s120x120/916328c7-3435-405b-8df1-eb7af8423034.jpg",
                106000, 1);
        foodList.add(f55);
        Food f56 = new Food(3, "M?? L???nh Tr???n Cay",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g100/997226/s120x120/9c3f9445-81f7-4653-b1a5-4a1711ff-5082510f-210527161808.jpeg",
                85000, 1);
        foodList.add(f56);
        Food f57 = new Food(3, "Mi???n Tr???n H??n Qu???c",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g100/997226/s120x120/00ff79cf-67f3-4f96-a700-13af471948fc.jpg",
                106000, 1);
        foodList.add(f57);
        Food f58 = new Food(3, "Tokpokki Nh??n Ph?? Mai",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g100/997226/s120x120/9ceffb20-1df6-4585-b13a-be9a4a709a8d.jpg",
                126000, 1);
        foodList.add(f58);

//Shop2
        Food f4 = new Food(4, "Ch??n g?? r??t x????ng ng??m s??? t???c - H???p l???n", "H???p 500gr ch??n g?? r??t x????ng, k??m n?????c ch???m si??u ngon",
                "https://images.foody.vn/res/g78/771236/s120x120/ad9be13a-628b-4cbf-b498-6a13028cf516.jpg",
                210000, 2);
        foodList.add(f4);
        Food f5 = new Food(5, "Ch??n g?? r??t x????ng ng??m s??? t???c - H???p nh???", "H???p 250gr ch??n g?? r??t x????ng, k??m n?????c ch???m si??u ngon",
                "https://images.foody.vn/res/g78/771236/s120x120/ad9be13a-628b-4cbf-b498-6a13028cf516.jpg",
                110000, 2);
        foodList.add(f5);
        Food f6 = new Food(5, "Ch??n g?? ng??m s??? t???c - H???p l???n",
                "H???p 500gr ch??n g??, k??m n?????c ch???m si??u ngon.",
                "https://images.foody.vn/res/g78/771236/s120x120/b426425e-dcf9-468f-90ea-672d0d20b470.jpg",
                130000, 2);
        foodList.add(f6);
        Food f7 = new Food(5, "Ch??n g?? ng??m s??? t???c - H???p nh???",
                "H???p 500gr ch??n g??, k??m n?????c ch???m si??u ngon.",
                "https://images.foody.vn/res/g78/771236/s120x120/b426425e-dcf9-468f-90ea-672d0d20b470.jpg",
                65000, 2);
        foodList.add(f7);
        Food f8 = new Food(5, "COMBO 2 h???p ch??n g?? ( c?? x????ng + r??t x????ng ) ng??m",
                "2 h???p nh???",
                "https://images.foody.vn/res/g78/771236/s120x120/d2f5110d-1c6f-4075-a5f0-d9cd3c05ec51.jpg",
                165000, 2);
        foodList.add(f8);
        Food f59 = new Food(5, "Ch??n G?? R??t X????ng S???t Th??i - H???p L???n",
                "H???p 500g, tr???n v???i c??c xo??i si??u ngon",
                "https://images.foody.vn/res/g78/771236/s120x120/36a0b7a5-56d0-4b55-9012-e78f6e28-e6fec1b8-220125231018.jpeg",
                210000, 2);
        foodList.add(f59);
        Food f60 = new Food(5, "Ch??n g?? s???t Th??i - H???p l???n",
                "H???p 500g tr???n c??c xo??i si??u ngon, n?????c ch???m th???n th??nh",
                "https://images.foody.vn/res/g78/771236/s120x120/97e71209-1190-4d8f-8b84-82170c16610d.jpeg",
                130000, 2);
        foodList.add(f60);
        Food f61 = new Food(5, "Ch??n g?? r??t x????ng s???t Th??i - H???p nh???",
                "H???p 500g tr???n c??c xo??i si??u ngon, n?????c ch???m th???n th??nh",
                "https://images.foody.vn/res/g78/771236/s120x120/97e71209-1190-4d8f-8b84-82170c16610d.jpeg",
                110000, 2);
        foodList.add(f61);
        Food f62 = new Food(5, "Ch??n g?? n?????ng s???t Th??i - H???p nh???",
                "H???p 400g tr???n c??c xo??i si??u ngon, n?????c ch???m th???n th??nh",
                "https://images.foody.vn/res/g78/771236/s120x120/97e71209-1190-4d8f-8b84-82170c16610d.jpeg",
                110000, 2);
        foodList.add(f62);
        Food f63 = new Food(5, "Ch??n g?? n?????ng s???t Th??i - H???p nh???",
                "H???p 250g tr???n c??c xo??i si??u ngon, n?????c ch???m th???n th??nh",
                "https://images.foody.vn/res/g78/771236/s120x120/97e71209-1190-4d8f-8b84-82170c16610d.jpeg",
                65000, 2);
        foodList.add(f63);

        //Shop 3
        Food f9 = new Food(5, "B??nh m?? ?????c bi???t",
                "B??nh m?? ?????c bi???t",
                "https://images.foody.vn/res/g8/72633/s120x120/2018912141138-hryh.jpg",
                25000, 3);
        foodList.add(f9);
        Food f10 = new Food(5, "B??nh m?? ch??? b??",
                "B??nh m?? ch??? b??",
                "https://images.foody.vn/res/g8/72633/s120x120/2018122214036-ba%cc%81nh-mi%cc%80-cha%cc%89-bo%cc%80.jpg",
                20000, 3);
        foodList.add(f10);
        Food f11 = new Food(5, "X??i m???n",
                "X??i m???n",
                "https://images.foody.vn/res/g8/72633/s120x120/20181031105419-xoi-man.jpg",
                15000, 3);
        foodList.add(f11);
        Food f12 = new Food(5, "B??nh m?? heo quay",
                "B??nh m?? heo quay",
                "https://images.foody.vn/res/g8/72633/s120x120/201891214121-banh-mi-heo-quay.jpg",
                20000, 3);
        foodList.add(f12);
        Food f13 = new Food(5, "B??nh m?? ch??? l???a",
                "B??nh m?? ch??? l???a",
                "https://images.foody.vn/res/g8/72633/s120x120/201812221434-ba%cc%81nh-mi%cc%80-cha%cc%89-lu%cc%a3a.jpg",
                20000, 3);
        foodList.add(f13);
        Food f64 = new Food(5, "B??nh m?? th???p c???m",
                "B??nh m?? th???p c???m",
                "https://images.foody.vn/res/g4/32218/s120x120/040a6df6-de54-422d-9e31-bf573aa2-2942e981-200908141458.jpeg",
                25000, 3);
        foodList.add(f64);
        Food f65 = new Food(5, "B??nh m?? th???t ph?? l???u",
                "B??nh m?? th???t ph?? l???u",
                "https://images.foody.vn/res/g4/32218/s120x120/92b231fd-5b36-4fb4-a333-4d8c82ed-be84942c-200910141645.jpeg",
                25000, 3);
        foodList.add(f65);
        Food f66 = new Food(5, "B??nh gi??",
                "B??nh gi??",
                "https://images.foody.vn/res/g4/32218/s120x120/c08def06-a915-4d77-9b94-a9e34452-4756dbaf-200908134004.jpeg",
                16000, 3);
        foodList.add(f66);
        Food f67 = new Food(5, "B??NH M?? TR???NG OPLA",
                "B??NH M?? TR???NG OPLA",
                "https://images.foody.vn/res/g4/32218/s120x120/b5d34b17-008d-4220-900f-66fbbf30-f563b977-200908143108.jpeg",
                25000, 3);
        foodList.add(f67);
        Food f68 = new Food(5, "B??NH M?? CH?? B??NG",
                "B??NH M?? CH?? B??NG",
                "https://images.foody.vn/res/g4/32218/s120x120/9f877e0c-4d8f-41e6-901a-838caa5d-0708096b-200908142715.jpeg",
                20000, 3);
        foodList.add(f68);

        //Shop4

        Food f14 = new Food(5, "Cafe ??en ????",
                "Cafe ??en ????",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                38000, 4);
        foodList.add(f14);
        Food f15 = new Food(5, "Cafe s???a ????",
                "Cafe s???a ????",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        foodList.add(f15);
        Food f16 = new Food(5, "Cappuccino",
                "Cappuccino",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        foodList.add(f16);
        Food f17 = new Food(5, "Machiato",
                "Machiato",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        foodList.add(f17);
        Food f18 = new Food(5, "Espresso",
                "Espresso",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        foodList.add(f18);
        Food f19 = new Food(5, "Flan coffee",
                "Cafe, caramel, b???t s???a, kem, b??nh flan",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 4);
        foodList.add(f19);
        Food f20 = new Food(5, "Coconut coffee",
                "Cafe, kem s???a, c??m d???a, vani, kem",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                65000, 4);
        foodList.add(f20);
        Food f21 = new Food(5, "Frappuccino",
                "Caramel/ socola, s???a t????i, kemo",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                75000, 4);
        foodList.add(f21);
        Food f69 = new Food(5, "Matcha smoothies",
                "Tr?? xanh Nh???t, b???t s???a, s???a t????i, kem",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                75000, 4);
        foodList.add(f69);
        Food f70 = new Food(5, "N?????c chanh d??y",
                "N?????c chanh d??y",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                45000, 4);
        foodList.add(f70);
        Food f71 = new Food(5, "Berry Smoothie",
                "D??u, ph??c b???n t???, vi???t qu???t, s???a chua",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                65000, 4);
        foodList.add(f71);
        Food f72 = new Food(5, "Sinh t??? d??u",
                "Sinh t??? d??u",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                55000, 4);
        foodList.add(f72);
        //Shop 5
        Food f22 = new Food(5, "B??nh canh th???p c???m",
                "B??nh canh th???p c???m",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        foodList.add(f22);
        Food f23 = new Food(5, "B??n b?? cay B???c Li??u",
                "B?? cay ?????c bi???t",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        foodList.add(f23);
        Food f24 = new Food(5, "B??nh canh ch??? ng?? v??? (5 lo???i ch???)",
                "B??nh canh ?????c bi???t",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        foodList.add(f24);
        Food f25 = new Food(5, "H??? ti???u h???i s???n",
                "H??? ti???u ?????c bi???t",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        foodList.add(f25);
        Food f26 = new Food(5, "H??? ti???u ch??? ng?? v??? ho??ng kim (Kh??)",
                "H??? ti???u ?????c bi???t",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        foodList.add(f26);
        Food f27 = new Food(5, "Tr?? t???c",
                "????? u???ng",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                15000, 5);
        foodList.add(f27);
        Food f28 = new Food(5, "Tr?? d??u",
                "????? u???ng",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                25000, 5);
        foodList.add(f28);
        Food f74 = new Food(5, "M?? s???a th???p c???m",
                "M?? s???a",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        foodList.add(f74);
        Food f75= new Food(5, "M?? s???a b??nh t??m B???c Li??u",
                "M?? s???a",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        foodList.add(f75);
        Food f76 = new Food(5, "M?? s???a g?? n?????ng (Kh??)",
                "M?? s???a",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                60000, 5);
        foodList.add(f76);
        //Shop 6
        Food f29 = new Food(5, "G???i c?? tr?? truy???n th???ng Th??i",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129115414-img_8581.jpg",
                120000, 6);
        foodList.add(f29);
        Food f30 = new Food(5, "G???i mi???n h???i s???n",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129115628-img_8788.jpg",
                165000, 6);
        foodList.add(f30);
        Food f31 = new Food(5, "G???i ??u ????? t??m kh?? tr???ng mu???i",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129115434-img_8595.jpg",
                100000, 6);
        foodList.add(f31);
        Food f32 = new Food(5, "Salad tr???ng l??ng ????o v???i th???t b???m th??nh",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/201812911556-img_8661.jpg",
                95000, 6);
        foodList.add(f32);
        Food f33 = new Food(5, "N???ng heo n?????ng m???t ong",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/1ebb853e-3578-475d-8d27-1c8504ba9da4.jpg",
                190000, 6);
        foodList.add(f33);
        Food f34 = new Food(5, "M???c n?????ng v???i sauce me & ?????u ph???ng",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/71fc0481-9b18-4b2a-a6dc-434f7bf3-654c5230-211109134633.jpeg",
                323000, 6);
        foodList.add(f34);
        Food f35 = new Food(5, "C?? ch???m nguy??n con chi??n gi??n s???t Chilli Th??i",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129113319-img_9108.jpg",
                250000, 6);
        foodList.add(f35);
        Food f77 = new Food(5, "G???i ??u ????? Ba Kh??a",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129115534-img_8687.jpg",
                90000, 6);
        foodList.add(f77);
        Food f78 = new Food(5, "M??m g???i Somtum cay ki???u Isaan v???i t??p rong",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/0cb20fc7-178f-4f71-98fd-e6dfea76-c8dde54f-211109133920.jpeg",
                130000, 6);
        foodList.add(f78);
        Food f79 = new Food(5, "Steak b?? n?????ng ki???u Th??i",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129114415-img_9216.jpg",
                370000, 6);
        foodList.add(f79);
        Food f80 = new Food(5, "B?? x??o h????ng nhu ti??u xanh",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/2018129114437-img_9561.jpg",
                320000, 6);
        foodList.add(f80);
        Food f81 = new Food(5, "T??m s?? chi??n gi??n s???t me v?? l?? kaffir",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/res/g9/82674/s120x120/93f3759b-b81a-45f0-b3a4-4695ffa6f5f1.jpg",
                190000, 6);
        foodList.add(f81);

        //Shop 7
        Food f36 = new Food(5, "Tu??? b?? s???t Hong Kong",
                "Gi?? ???? bao g???m 10% VAT",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                120000, 7);
        foodList.add(f36);
        Food f37 = new Food(5, "Combo th???t nai v?? d?? n?????ng",
                "Rau mu???ng, ?????u b???p ??i k??m",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                150000, 7);
        foodList.add(f37);
        Food f38= new Food(5, "L???u Gi?? Heo Chao ?????",
                "Rau m?? h??? t??u ??i k??m",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                200000, 7);
        foodList.add(f38);
        Food f39 = new Food(5, "L???u ?????u C??",
                "Rau m?? h??? t??u ??i k??m",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                200000, 7);
        foodList.add(f39);
        Food f40 = new Food(5, "S?????n d?? n?????ng",
                "S?????n d?? n?????ng",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                210000, 7);
        foodList.add(f40);
        Food f41 = new Food(5, "V?? d?? n?????ng",
                "Rau mu???ng ?????u b???p ??i k??m",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                135000, 7);
        foodList.add(f41);
        Food f82 = new Food(5, "L???u d??",
                "Rau m?? h??? t??u ??i k??m",
                "https://images.foody.vn/res/g9/82674/s120x120/93f3759b-b81a-45f0-b3a4-4695ffa6f5f1.jpg",
                230000, 7);
        foodList.add(f82);
        Food f83 = new Food(5, "??c Heo",
                "??c Heo",
                "https://images.foody.vn/res/g9/82674/s120x120/93f3759b-b81a-45f0-b3a4-4695ffa6f5f1.jpg",
                45000, 7);
        foodList.add(f83);
        Food f84 = new Food(5, "H??? Ti???u",
                "H??? Ti???u",
                "https://images.foody.vn/res/g9/82674/s120x120/93f3759b-b81a-45f0-b3a4-4695ffa6f5f1.jpg",
                15000, 7);
        foodList.add(f84);
        Food f85 = new Food(5, "Tu??? B??",
                "Tu??? B??",
                "https://images.foody.vn/res/g9/82674/s120x120/93f3759b-b81a-45f0-b3a4-4695ffa6f5f1.jpg",
                45000, 7);
        foodList.add(f85);

        //Shop 8
        Food f42 = new Food(5, "H??? Ti???u B?? Vi??n",
                "H??? Ti???u B?? Vi??n",
                "https://images.foody.vn/default/s120x120/shopeefood-deli-dish-no-image.png",
                40000, 8);
        foodList.add(f42);
        Food f43 = new Food(5, "B??n b?? Hu??? ?????c bi???t ",
                "B??n b?? Hu??? ?????c bi???t ",
                "https://images.foody.vn/res/g108/1073753/s120x120/67ecbdb9-1107-40f7-a574-44ac9406-77bcaf25-210415122104.jpeg",
                55000, 8);
        foodList.add(f43);
        Food f44 = new Food(5, "B??n b?? Hu??? t??i n???m",
                "B??n b?? Hu??? t??i n???m",
                "https://images.foody.vn/res/g108/1073753/s120x120/67ecbdb9-1107-40f7-a574-44ac9406-77bcaf25-210415122104.jpeg",
                45000, 8);
        foodList.add(f44);
        Food f45 = new Food(5, "B??n b?? Hu??? th?????ng",
                "B??n b?? Hu??? th?????ng",
                "https://images.foody.vn/res/g108/1073753/s120x120/67ecbdb9-1107-40f7-a574-44ac9406-77bcaf25-210415122104.jpeg",
                40000, 8);
        foodList.add(f45);
        Food f46 = new Food(5, "Tr?? T???c X?? Mu???i",
                "Tr?? T???c X?? Mu???i",
                "https://images.foody.vn/res/g108/1073753/s120x120/2b5670be-dcb9-455c-b2bf-7461b046-78efab04-210415122446.jpeg",
                20000, 8);
        foodList.add(f46);
        Food f47 = new Food(5, "Tr?? T???c ",
                "Tr?? T???c ",
                "https://images.foody.vn/res/g108/1073753/s120x120/2b5670be-dcb9-455c-b2bf-7461b046-78efab04-210415122446.jpeg",
                15000, 8);
        foodList.add(f47);
        Food f86 = new Food(5, "B??n ch??? c??",
                "B??n ch??? c??",
                "https://images.foody.vn/res/g108/1073753/s120x120/67ecbdb9-1107-40f7-a574-44ac9406-77bcaf25-210415122104.jpeg",
                35000, 8);
        foodList.add(f86);
        Food f87 = new Food(5, "N?????c M??a",
                "N?????c M??a",
                "https://images.foody.vn/res/g108/1073753/s120x120/037e780d-5cae-478e-9aff-ba1eb4f2-8c2a86d5-210415122408.jpeg",
                15000, 8);
        foodList.add(f87);
        Food f88 = new Food(5, "Sinh T??? M??ng C???u",
                "Sinh T??? M??ng C???u",
                "https://images.foody.vn/res/g108/1073753/s120x120/9c68ee0b-3288-4fce-bfe5-854af3d5-9511e2de-220330125801.jpeg",
                30000, 8);
        foodList.add(f88);
        Food f89 = new Food(5, "Sinh T??? B??",
                "Sinh T??? B??",
                "https://images.foody.vn/res/g108/1073753/s120x120/9c68ee0b-3288-4fce-bfe5-854af3d5-9511e2de-220330125801.jpeg",
                30000, 8);
        foodList.add(f89);

        //Shop 9
        Food f90 = new Food(5, "B??nh Cu???n X.O S?? ??i???p Kh??",
                "B??nh Cu???n X.O S?? ??i???p Kh??",
                "https://images.foody.vn/res/g12/112526/s120x120/8ee6dc79-86ec-4399-bae7-3f9f6deb-4e9fee6e-220509090352.jpeg",
                82000, 9);
        foodList.add(f90);
        Food f91 = new Food(5, "T??m Vi??n H???nh Nh??n",
                "T??m Vi??n H???nh Nh??n",
                "https://images.foody.vn/res/g12/112526/s120x120/8ee6dc79-86ec-4399-bae7-3f9f6deb-4e9fee6e-220509090352.jpeg",
                68000, 9);
        foodList.add(f91);
        Food f92 = new Food(5, "T??? Chim Chi??n X??",
                "T??? Chim Chi??n X??",
                "https://images.foody.vn/res/g12/112526/s120x120/ee3936e3-4161-4c32-ab5d-9d0eb3ff-dc658c10-220125163955.jpeg",
                60000, 9);
        foodList.add(f92);
        Food f93 = new Food(5, "B??nh N?????ng Ph?? Mai ",
                "B??nh N?????ng Ph?? Mai ",
                "https://images.foody.vn/res/g12/112526/s120x120/850caa43-2382-4bc7-aef7-e4f737a8-f97488dc-220125163821.jpeg",
                48000, 9);
        foodList.add(f93);
        Food f94 = new Food(5, "X??u M???i B??o Ng??",
                "X??u M???i B??o Ng??",
                "https://images.foody.vn/res/g12/112526/s120x120/646f93d8-5dc5-4c71-96c4-4bd3734a-d94e5d03-220422131712.jpeg",
                98000, 9);
        foodList.add(f94);
        Food f95 = new Food(5, "B??ng C???i S???t D???u H??o",
                "B??ng C???i S???t D???u H??o",
                "https://images.foody.vn/res/g12/112526/s120x120/c4e9dbaa-beae-4cea-ad1b-6a88020f-7a3be0b7-220125163640.jpeg",
                98000, 9);
        foodList.add(f95);
        Food f96 = new Food(5, "N???m Rang Ki???u H???ng K??ng",
                "N???m Rang Ki???u H???ng K??ng",
                "https://images.foody.vn/res/g12/112526/s120x120/a3e907dd-24a2-451b-b2e0-444bdb07-21635573-220125163732.jpeg",
                118000, 9);
        foodList.add(f96);
        Food f97 = new Food(5, "H?? C???o H???i S???n D??t V??ng",
                "H?? C???o H???i S???n D??t V??ng",
                "https://images.foody.vn/res/g12/112526/s120x120/4df70628-6755-4bee-86e7-01573429-7fed162c-220422131638.jpeg",
                98000, 9);
        foodList.add(f97);
        Food f98 = new Food(5, "B??ng C???i S?? ??i???p S???t Th???t Cua",
                "B??ng C???i S?? ??i???p S???t Th???t Cua",
                "https://images.foody.vn/res/g12/112526/s120x120/2c63fad0-01f2-440c-9d3e-8cda3d84-3c395cf7-220125163559.jpeg",
                228000, 9);
        foodList.add(f98);
        Food f99 = new Food(5, "X??u M???i G???ch Cua",
                "X??u M???i G???ch Cua",
                "https://images.foody.vn/res/g12/112526/s120x120/ed66a64e-6964-4a75-94a4-535a9efb-eb82f9b3-211229155557.jpeg",
                60000, 9);
        foodList.add(f99);

        Food f100 = new Food(5, "H?? C???o Thu??? Tinh",
                "H?? C???o Thu??? Tinh",
                "https://images.foody.vn/res/g12/112526/s120x120/df9ff3b4-fbaf-4aaf-8c73-3c6066e0-dbc9ca08-211229155008.jpeg",
                60000, 9);
        foodList.add(f100);
        Food f101 = new Food(5, "Ch??n G?? H???p T??u X??",
                "Chicken feet & black bean sauce",
                "https://images.foody.vn/res/g12/112526/s120x120/ad61a83a-852c-4848-ae72-da3d6ae8-24d14745-211229154806.jpeg",
                60000, 9);
        foodList.add(f101);

        //Shop 10
        Food f102 = new Food(5, "1 mi???ng G?? Tokbokki",
                "1 mi???ng G?? Tokbokki",
                "https://images.foody.vn/res/g1/4213/s120x120/01ca1bdd-3e6e-455a-a605-2be6f86d-57b0da65-220407160045.jpeg",
                40000, 10);
        foodList.add(f102);
        Food f103 = new Food(5, "Combo G?? Tokbokki HDB",
                "01 mi???ng G?? Tokbokki + 01 Burger Zinger/ 01 Burger G?? Quay Flava + 01 Pepsi Lon",
                "https://images.foody.vn/res/g1/4213/s120x120/f879b634-c7bd-4e8c-a247-8c9f168f-539d11b1-220407163126.jpeg",
                95000, 10);
        foodList.add(f103);
        Food f104 = new Food(5, "2 mi???ng G?? Tokbokki",
                "2 mi???ng G?? Tokbokki",
                "https://images.foody.vn/res/g1/4213/s120x120/cc445bcf-a5a8-4310-8bb2-4271da21-72006f9d-220407160818.jpeg",
                75000, 10);
        foodList.add(f104);
        Food f105 = new Food(5, "Combo G?? Tokbokki HDD",
                "03 mi???ng G?? Tokbokki + 01 mi???ng G?? + 01 Khoai T??y Chi??n (l???n)/02 Thanh B?? Ph??-mai + 02 Pepsi Lon",
                "https://images.foody.vn/res/g1/4213/s120x120/a09aadd3-7d83-492e-ac38-9c6384d3-cbf373f5-220407165244.jpeg",
                195000, 10);
        foodList.add(f105);
        Food f106= new Food(5, "Combo G?? Tokbokki HDE",
                "04 mi???ng G?? Tokbokki + 01 G?? Popcorn (v???a) + 02 Pepsi Lon",
                "https://images.foody.vn/res/g1/4213/s120x120/b050185a-38c5-4608-92ca-cf54f91b-8889fd35-220407165434.jpeg",
                195000, 10);
        foodList.add(f106);
        Food f107= new Food(5, "6 mi???ng G?? Tokbokki",
                "6 mi???ng G?? Tokbokki",
                "https://images.foody.vn/res/g1/4213/s120x120/80e4c555-bce9-4d47-af5a-8fd35852-2bc37dc1-220407161348.jpeg",
                217000, 10);
        foodList.add(f107);
        Food f108= new Food(5, "9 mi???ng G?? Tokbokki",
                "9 mi???ng G?? Tokbokki",
                "https://images.foody.vn/res/g1/4213/s120x120/005f640c-1acc-4988-b518-718914b1-b6110257-220407161434.jpeg",
                318000, 10);
        foodList.add(f108);
        Food f109= new Food(5, "01 B??nh Tr???ng S??-c??-la H???nh Nh??n",
                "01 B??nh Tr???ng S??-c??-la H???nh Nh??n",
                "https://images.foody.vn/res/g1/4213/s120x120/09d6ba87-9ae1-4cd6-8049-b8be1427-735bbc50-220314133112.jpeg",
                19000, 10);
        foodList.add(f109);
        Food f110= new Food(5, "Combo G?? R??n",
                "2 Mi???ng G?? + 1 B??nh Tr???ng + 1 Lon Pepsi",
                "https://images.foody.vn/res/g1/4213/s120x120/7ec82fab-302d-4d80-bf84-5e50524e-29e4587c-210524161949.jpeg",
                97000, 10);
        foodList.add(f110);
        Food f111= new Food(5, "Combo G?? Vi??n",
                "1 Mi???ng G?? + 1 H???p G?? Vi??n (V???a) + 1 Lon Pepsi",
                "https://images.foody.vn/res/g1/4213/s120x120/09bb4751-22d6-4685-8ebb-fa36c989-8f94a5fc-210524161839.jpeg",
                84000, 10);
        foodList.add(f111);

        for (Food f:foodList) {
            database.execSQL("insert into Foods values(null,?,?,?,?,?)",f.toParams());
        }

    }

public void temp(){
  //  database.execSQL("insert into Foods values(null,?,?,?,?,?)",f1.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f2.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f3.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f4.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f5.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f6.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f7.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f8.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f9.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f10.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f11.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f12.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f13.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f14.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f15.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f16.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f17.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f18.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f19.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f20.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f21.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f22.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f23.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f24.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f25.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f26.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f27.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f28.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f29.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f30.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f31.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f32.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f33.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f34.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f35.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f36.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f37.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f38.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f39.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f40.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f41.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f42.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f43.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f44.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f45.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f46.toParams());
//        database.execSQL("insert into Foods values(null,?,?,?,?,?)",f47.toParams());
}


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
