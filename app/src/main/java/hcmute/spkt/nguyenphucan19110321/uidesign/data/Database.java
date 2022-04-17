package hcmute.spkt.nguyenphucan19110321.uidesign.data;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;

public class Database {
    public static final List<Shop> SHOP_LIST = new ArrayList<>();
    public static final List<Food> FOOD_LIST = new ArrayList<>();
    public static final void MakeData(){
        Shop f1 = new Shop("1","Gogi House - Quán Nướng Hàn Quốc - Saigon Centre",
                "Vài ngày là lại tới gogi một lần nè, món ăn thì khỏi bàn luônnnn, nhân viên thì nhiệt tình, anh chị quản lý dễ thương xĩu luônnnn",
                "https://images.foody.vn/res/g25/248319/prof/s640x400/foody-upload-api-foody-mobile-1-200408093229.jpg",
               "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM","Shop Online",9.4);

        Shop f2 = new Shop("2","Thành Mập - Chân Gà Rút Xương Ngâm Sả Tắc - Bạch Đằng - Shop Online",
                "Nhân viên ngon xĩu luônnnn =))))))))",
                "https://images.foody.vn/res/g100/990502/prof/s640x400/foody-upload-api-foody-mobile-foody-upload-api-foo-191216172331.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM","Shop Online",9.4
                );

        Shop f3 = new Shop("3","Bánh Mì Tuấn Mập - Nguyễn Thị Nhỏ",
                "Ship toàn Thủ Đức",
                "https://images.foody.vn/res/g4/32218/prof/s640x400/foody-mobile-banh-mi-tuan-map-tp-hcm.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM","Shop Online",9.4);
        Shop f4 = new Shop("4","Pergola - Cafe Nhà Hàng Sân Vườn",
                "Đồ ăn vừa miệng , trang trí bắt mắt. Món này cùng với món cá là mình thích nhất , bánh creps " +
                        "nhân khoai môn không ngon lắm các món còn lại thì ok. Nhà hàng bên trong hẻm hơi khó tìm một chút , đợt chung ...",
                "https://images.foody.vn/res/g1/342/prof/s640x400/foody-mobile-pergola-jpg-490-635683258471725878.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM","Shop Online",9.4);

        Shop f5 = new Shop("5","Tân Hương Nam Quán - Mì Sụa Bạc Liêu & Bánh Canh",
                "Không hiểu quán nghĩ gì mà giao phần sườn cho khách như vậy luôn, cây sườn nó còn dài hơn hộp," +
                        " nếu ko biết suy nghĩ cho khách thì ít nhất phải chặt ra cho giống hình minh hoạ chứ ạ? Hên là ăn ở nhà, còn ...",
                "https://images.foody.vn/res/g17/161419/prof/s640x400/foody-upload-api-foody-mobile-foody-tan-huong-nam--190104172143.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM","Shop Online",9.4);

        Shop f6 = new Shop("6","Chilli Thai - Lý Tự Trọng",
                "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g102/1012534/prof/s640x400/file_restaurant_photo_sufy_16340-d0277df5-211012232712.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM","Shop Online",9.4);
        Shop f7 = new Shop("7","Lẩu & Nướng Khánh Hoàng",
                "Quán có cách tính tiền rất buồn cười :)))",
                "https://images.foody.vn/res/g5/46860/prof/s640x400/foody-mobile-lau-de-khanh-hoang-vinh-vien-tp-hcm-140102114559.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM","Shop Online",9.4);

        Shop f8 = new Shop("8","Phở 247",
                "Moi lan order la hon 10 phan the nay day,do nha quan so dong ma lai la rat ghien an pho",
                "https://images.foody.vn/res/g2/11414/prof/s640x400/foody-mobile-ue1xq7j3-jpg-176-636195529268772963.jpg",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                "94/22/2A Phú Thọ Hòa, P. Phú Thọ Hòa, TP.Thủ Đức, TP.HCM","Shop Online",9.4);

        SHOP_LIST.add(f1);
        SHOP_LIST.add(f2);
        SHOP_LIST.add(f3);
        SHOP_LIST.add(f4);
        SHOP_LIST.add(f5);
        SHOP_LIST.add(f6);
        SHOP_LIST.add(f7);
        SHOP_LIST.add(f8);
        SHOP_LIST.add(f7);
        SHOP_LIST.add(f8);
        SHOP_LIST.add(f7);
        SHOP_LIST.add(f8);
    }

    public static final void MakeDataFood(){
        Food f1 = new Food("1","Test 1","Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000);
        Food f2 = new Food("1","Test 1","Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000);
        Food f3 = new Food("1","Test 1","Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g105/1041514/s120x120/2b06d3a1-dbfb-4a88-a672-f94878a8-a63f4179-201119124832.jpeg",
                100000);
        FOOD_LIST.add(f1);
        FOOD_LIST.add(f2);
        FOOD_LIST.add(f3);
    }
}
