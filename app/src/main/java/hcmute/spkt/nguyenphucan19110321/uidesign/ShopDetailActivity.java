package hcmute.spkt.nguyenphucan19110321.uidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.FoodAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;

public class ShopDetailActivity extends AppCompatActivity {

    RecyclerView recycleViewFoodMost;
    List<Food> foodList = new ArrayList<>();
    private TextView tvTitleShopDetail,tvNameShopDetail, tvAddressShopDetail,tvTypeShopDetail,tvRangePriceShopDetail;
    private ImageView imgShopDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        SetControl();
        LoadDataFromIntent();
        LoadListFood();
    }

    private void LoadDataFromIntent() {
        if(getIntent().getStringExtra("Shop")!=null){
            String shopJSON = getIntent().getStringExtra("Shop");
            Gson gson = new Gson();
            Shop shop = gson.fromJson(shopJSON,Shop.class);
            tvTitleShopDetail.setText(shop.getName());
            tvNameShopDetail.setText(shop.getName());
            tvAddressShopDetail.setText(shop.getAddress());
            Picasso.get().load(shop.getImage()).into(imgShopDetail);
        }

    }

    private void SetControl(){
        recycleViewFoodMost = findViewById(R.id.recycleViewFoodMost);
        imgShopDetail = findViewById(R.id.imgShopDetail);
        tvTitleShopDetail = findViewById(R.id.tvTitleShopDetail);
        tvNameShopDetail  =findViewById(R.id.tvNameShopDetail);
        tvAddressShopDetail = findViewById(R.id.tvAddressShopDetail);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void LoadListFood(){
        if(Database.FOOD_LIST.size()==0){
            Database.MakeDataFood();
        }

        FoodAdapter foodAdapter =new FoodAdapter(this, Database.FOOD_LIST);
        LinearLayoutManager linear =new LinearLayoutManager(this);

        recycleViewFoodMost.setAdapter(foodAdapter);
        recycleViewFoodMost.setLayoutManager(linear);
    }

    private void GoToShopDetail(Shop shop) {
        Intent intent = new Intent();

    }
}