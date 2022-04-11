package hcmute.spkt.nguyenphucan19110321.uidesign.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.FoodHomeAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;


public class HomeFragment extends Fragment {

    GridView gridViewFoodHome;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridViewFoodHome = view.findViewById(R.id.gridViewFoodHome);
        List<Food> foodList = new ArrayList<>();
        foodList = MakeDataFake();
        FoodHomeAdapter foodHomeAdapter = new FoodHomeAdapter(this.getContext(),foodList);
        gridViewFoodHome.setAdapter(foodHomeAdapter);

    }

    private List<Food> MakeDataFake() {
        List<Food> foodList = new ArrayList<>();
        Food f1 = new Food("1","Gogi House - Quán Nướng Hàn Quốc - Saigon Centre",
                "Vài ngày là lại tới gogi một lần nè, món ăn thì khỏi bàn luônnnn, nhân viên thì nhiệt tình, anh chị quản lý dễ thương xĩu luônnnn",
                "https://images.foody.vn/res/g25/248319/prof/s640x400/foody-upload-api-foody-mobile-1-200408093229.jpg");
        Food f2 = new Food("2","Thành Mập - Chân Gà Rút Xương Ngâm Sả Tắc - Bạch Đằng - Shop Online",
                "Nhân viên ngon xĩu luônnnn =))))))))",
                "https://images.foody.vn/res/g100/990502/prof/s640x400/foody-upload-api-foody-mobile-foody-upload-api-foo-191216172331.jpg");
        Food f3 = new Food("3","Bánh Mì Tuấn Mập - Nguyễn Thị Nhỏ",
                "Ship toàn Thủ Đức",
                "https://images.foody.vn/res/g4/32218/prof/s640x400/foody-mobile-banh-mi-tuan-map-tp-hcm.jpg");
        Food f4 = new Food("4","Pergola - Cafe Nhà Hàng Sân Vườn",
                "Đồ ăn vừa miệng , trang trí bắt mắt. Món này cùng với món cá là mình thích nhất , bánh creps " +
                        "nhân khoai môn không ngon lắm các món còn lại thì ok. Nhà hàng bên trong hẻm hơi khó tìm một chút , đợt chung ...",
                "https://images.foody.vn/res/g1/342/prof/s640x400/foody-mobile-pergola-jpg-490-635683258471725878.jpg");

        Food f5 = new Food("5","Tân Hương Nam Quán - Mì Sụa Bạc Liêu & Bánh Canh",
                "Không hiểu quán nghĩ gì mà giao phần sườn cho khách như vậy luôn, cây sườn nó còn dài hơn hộp," +
                        " nếu ko biết suy nghĩ cho khách thì ít nhất phải chặt ra cho giống hình minh hoạ chứ ạ? Hên là ăn ở nhà, còn ...",
                "https://images.foody.vn/res/g17/161419/prof/s640x400/foody-upload-api-foody-mobile-foody-tan-huong-nam--190104172143.jpg");

        Food f6 = new Food("6","Chilli Thai - Lý Tự Trọng",
                "Đồ ăn khá ngon nhưng thái độ phục vụ nhân viên rất tệ, lần sau sẽ ko ủng hộ nữa",
                "https://images.foody.vn/res/g102/1012534/prof/s640x400/file_restaurant_photo_sufy_16340-d0277df5-211012232712.jpg");
        Food f7 = new Food("7","Lẩu & Nướng Khánh Hoàng",
                "Quán có cách tính tiền rất buồn cười :)))",
                "https://images.foody.vn/res/g5/46860/prof/s640x400/foody-mobile-lau-de-khanh-hoang-vinh-vien-tp-hcm-140102114559.jpg");

        Food f8 = new Food("8","Phở 247",
                "Moi lan order la hon 10 phan the nay day,do nha quan so dong ma lai la rat ghien an pho",
                "https://images.foody.vn/res/g2/11414/prof/s640x400/foody-mobile-ue1xq7j3-jpg-176-636195529268772963.jpg");

        foodList.add(f1);
        foodList.add(f2);
        foodList.add(f3);
        foodList.add(f4);
        foodList.add(f5);
        foodList.add(f6);
        foodList.add(f7);
        foodList.add(f8);
        return foodList;
    }

}