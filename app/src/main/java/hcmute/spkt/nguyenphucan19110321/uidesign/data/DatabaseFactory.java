package hcmute.spkt.nguyenphucan19110321.uidesign.data;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.SaveShop;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.User;

public class DatabaseFactory {
    public static void CreateDatabase(Database database) {
//        database.ExecQuery("DROP TABLE IF EXISTS Users");
//        database.ExecQuery("DROP TABLE IF EXISTS Foods");
//        database.ExecQuery("DROP TABLE IF EXISTS Shops");
//        database.ExecQuery("DROP TABLE IF EXISTS Saveds");
//        database.ExecQuery("CREATE TABLE IF NOT EXISTS Users(id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                " name VARCHAR(50),avatar VARCHAR(150), username VARCHAR(30),password VARCHAR(30)," +
//                "address VARCHAR(150), gender VARCHAR(5), phone VARCHAR(14),email VARCHAR(44) )");
//        database.ExecQuery("CREATE TABLE IF NOT EXISTS Foods(id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                " name VARCHAR(50), description VARCHAR(30),image VARCHAR(150),price INTEGER," +
//                "idShop INTEGER )");
//        database.ExecQuery("CREATE TABLE IF NOT EXISTS Shops(id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                " name VARCHAR(50), description VARCHAR(30),image VARCHAR(150),imagesearch VARCHAR(150)" +
//                ",address VARCHAR(100),type VARCHAR(100),rate FLOAT(16))");
//        database.ExecQuery("CREATE TABLE IF NOT EXISTS Saveds(id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "idShop INTEGER, idUser INTEGER)");
//        User user = new User(1, "Trần Duy", "", "tranduy", "12345678", "An Giang", "Nam", "0398110398","test@gmail.com");
//        user.InsertToDatabase(database);
//        SaveShop saveShop = new SaveShop(1,1,1);
//        saveShop.InsertToDatabase(database);
    }

    public static final void MakeDataFood(Database db) {
        Food f1 = new Food(1, "Test 1", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 1);
        Food f2 = new Food(2, "Test 2", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 1);
        Food f3 = new Food(3, "Test 3", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 1);

        Food f4 = new Food(4, "Test 4", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 2);
        Food f5 = new Food(5, "Test 5", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 2);
        Food f6 = new Food(6, "Test 6", "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000, 3);

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
        db.ExecQuery("delete from Foods");

        f1.InsertToDatabase(db);
        f2.InsertToDatabase(db);
        f3.InsertToDatabase(db);
        f4.InsertToDatabase(db);
        f5.InsertToDatabase(db);
        f6.InsertToDatabase(db);
        f7.InsertToDatabase(db);
        f8.InsertToDatabase(db);
        f9.InsertToDatabase(db);
        f10.InsertToDatabase(db);
        f11.InsertToDatabase(db);
        f12.InsertToDatabase(db);
    }

    public static final void MakeData(Database db) {
        Shop f1 = new Shop(1, "Gogi House - Quán Nướng Hàn Quốc - Saigon Centre",
                "Vài ngày là lại tới gogi một lần nè, món ăn thì khỏi bàn luônnnn, nhân viên thì nhiệt tình, anh chị quản lý dễ thương xĩu luônnnn",
                "https://images.foody.vn/res/g25/248319/prof/s640x400/foody-upload-api-foody-mobile-1-200408093229.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);

        Shop f2 = new Shop(2, "Thành Mập - Chân Gà Rút Xương Ngâm Sả Tắc - Bạch Đằng - Shop Online",
                "Đồ ăn ngon xĩu luônnnn =))))))))",
                "https://images.foody.vn/res/g100/990502/prof/s640x400/foody-upload-api-foody-mobile-foody-upload-api-foo-191216172331.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4
        );

        Shop f3 = new Shop(3, "Bánh Mì Tuấn Mập - Nguyễn Thị Nhỏ",
                "Ship toàn Thủ Đức",
                "https://images.foody.vn/res/g4/32218/prof/s640x400/foody-mobile-banh-mi-tuan-map-tp-hcm.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);
        Shop f4 = new Shop(4, "Pergola - Cafe Nhà Hàng Sân Vườn",
                "Đồ ăn vừa miệng , trang trí bắt mắt. Món này cùng với món cá là mình thích nhất , bánh creps " +
                        "nhân khoai môn không ngon lắm các món còn lại thì ok. Nhà hàng bên trong hẻm hơi khó tìm một chút , đợt chung ...",
                "https://images.foody.vn/res/g1/342/prof/s640x400/foody-mobile-pergola-jpg-490-635683258471725878.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);

        Shop f5 = new Shop(5, "Tân Hương Nam Quán - Mì Sụa Bạc Liêu & Bánh Canh",
                "Không hiểu quán nghĩ gì mà giao phần sườn cho khách như vậy luôn, cây sườn nó còn dài hơn hộp," +
                        " nếu ko biết suy nghĩ cho khách thì ít nhất phải chặt ra cho giống hình minh hoạ chứ ạ? Hên là ăn ở nhà, còn ...",
                "https://images.foody.vn/res/g17/161419/prof/s640x400/foody-upload-api-foody-mobile-foody-tan-huong-nam--190104172143.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);

        Shop f6 = new Shop(6, "Chilli Thai - Lý Tự Trọng",
                "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g102/1012534/prof/s640x400/file_restaurant_photo_sufy_16340-d0277df5-211012232712.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);
        Shop f7 = new Shop(7, "Lẩu & Nướng Khánh Hoàng",
                "Quán có cách tính tiền rất buồn cười :)))",
                "https://images.foody.vn/res/g5/46860/prof/s640x400/foody-mobile-lau-de-khanh-hoang-vinh-vien-tp-hcm-140102114559.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);

        Shop f8 = new Shop(8, "Phở 247",
                "Moi lan order la hon 10 phan the nay day,do nha quan so dong ma lai la rat ghien an pho",
                "https://images.foody.vn/res/g2/11414/prof/s640x400/foody-mobile-ue1xq7j3-jpg-176-636195529268772963.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM", "Shop Online", 9.4);

        db.ExecQuery("delete from Shops");
        f1.InsertToDatabase(db);
        f2.InsertToDatabase(db);
        f3.InsertToDatabase(db);
        f4.InsertToDatabase(db);
        f5.InsertToDatabase(db);
        f6.InsertToDatabase(db);
        f7.InsertToDatabase(db);
        f8.InsertToDatabase(db);
    }

    public static List<Shop> getListShop(Database db) {
        Cursor cursor = db.SelectData("select * from Shops");
        List<Shop> shopList = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String des = cursor.getString(2);
            String image = cursor.getString(3);
            String imageSearch = cursor.getString(4);
            String address = cursor.getString(5);
            String type = cursor.getString(6);
            double rate = cursor.getDouble(7);
            shopList.add(new Shop(id, name, des, image, imageSearch, address, type, rate));
        }
        return shopList;
    }
}
