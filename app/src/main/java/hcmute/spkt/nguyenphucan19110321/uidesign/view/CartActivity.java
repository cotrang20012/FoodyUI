package hcmute.spkt.nguyenphucan19110321.uidesign.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.FoodAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.FoodCartAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;

public class CartActivity extends AppCompatActivity {
    private TextView tvTotal;
    private TextView tvNameCart;
    private ImageView imgProfileCart;
    List<Order> orderList = new ArrayList<>();
    RecyclerView recyclerViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        SetControls();
        SetTexts();
        LoadListOrder();

    }

    private void SetControls(){
        tvTotal = findViewById(R.id.tvTotal);
        tvNameCart = findViewById(R.id.tvNameCart);
        imgProfileCart = findViewById(R.id.imgProfileCart);
        recyclerViewCart = findViewById(R.id.recyclerViewCart);
    }
    private void SetTexts(){
        SpannableString s1 = new SpannableString("2 ");
        SpannableString s2 = new SpannableString("phần - ");
        SpannableString s3 = new SpannableString("108,000đ");

        int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
        s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
        s2.setSpan(new StyleSpan(Typeface.NORMAL), 0, s2.length(), flag);
        s3.setSpan(new StyleSpan(Typeface.BOLD), 0, s3.length(), flag);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(s1);
        builder.append(s2);
        builder.append(s3);

        tvTotal.setText(builder);
    }

    private void LoadListOrder(){
        if(Database.ORDER_LIST.size()==0){
            Database.MakeDataOrder();
        }
        FoodCartAdapter foodCartAdapter =new FoodCartAdapter(this, Database.ORDER_LIST);
        LinearLayoutManager linear =new LinearLayoutManager(this);

        recyclerViewCart.setAdapter(foodCartAdapter);
        recyclerViewCart.setLayoutManager(linear);
    }
}