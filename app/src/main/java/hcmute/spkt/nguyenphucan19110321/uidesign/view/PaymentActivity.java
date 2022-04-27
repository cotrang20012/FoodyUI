package hcmute.spkt.nguyenphucan19110321.uidesign.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.FoodCartAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.FoodPaymentAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.OrderDetails;
import lombok.Data;

public class PaymentActivity extends AppCompatActivity {
    TextView tvNamePayment,tvAddressPayment,tvTotalItem,tvShippingFee,tvPlatformFee,tvTotalPrice,tvPricePayment,tvShippingPrice,tvPlatformPrice;
    Button btnPayment;
    ImageView imgProfilePayment;
    RecyclerView recyclerViewCartPayment;
    Order order;
    List<OrderDetails> orderDetailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        SetControls();

        Intent intent = getIntent();
        order = (Order) intent.getSerializableExtra("order");
        orderDetailsList = (List<OrderDetails>) intent.getSerializableExtra("orderdetails");

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SQL = "";
                Database database  =new Database(PaymentActivity.this,"Foody.sqlite",null,1);
                database.ExecQuery(SQL);

            }
        });

        LoadListOrder();
    }

    private void SetControls(){
        btnPayment = findViewById(R.id.btnPayment);
        imgProfilePayment = findViewById(R.id.imgProfilePayment);
        tvNamePayment =findViewById(R.id.tvNamePayment);
        tvAddressPayment = findViewById(R.id.tvAddressPayment);
        tvTotalItem = findViewById(R.id.tvTotalItem);
        tvShippingFee = findViewById(R.id.tvShippingFee);
        tvShippingPrice = findViewById(R.id.tvShippingPrice);
        tvPlatformFee = findViewById(R.id.tvPlatformFee);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        tvPricePayment = findViewById(R.id.tvPricePayment);
        tvPlatformPrice = findViewById(R.id.tvPlatformPrice);
        recyclerViewCartPayment = findViewById(R.id.recycleViewCartPayment);
    }

    private void LoadListOrder(){
        FoodPaymentAdapter foodCartAdapter =new FoodPaymentAdapter(this, order,orderDetailsList);
        LinearLayoutManager linear =new LinearLayoutManager(this);

        recyclerViewCartPayment.setAdapter(foodCartAdapter);
        recyclerViewCartPayment.setLayoutManager(linear);
    }
}