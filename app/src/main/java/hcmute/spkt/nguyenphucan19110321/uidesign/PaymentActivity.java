package hcmute.spkt.nguyenphucan19110321.uidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.FoodCartAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.FoodPaymentAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;

public class PaymentActivity extends AppCompatActivity {
    TextView tvNamePayment,tvAddressPayment,tvTotalItem,tvShippingFee,tvPlatformFee,tvTotalPrice,tvPricePayment,tvShippingPrice,tvPlatformPrice;
    Button btnPayment;
    ImageView imgProfilePayment;
    RecyclerView recyclerViewCartPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        SetControls();
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
        if(Database.ORDER_LIST.size()==0){
            Database.MakeDataOrder();
        }
        FoodPaymentAdapter foodCartAdapter =new FoodPaymentAdapter(this, Database.ORDER_LIST);
        LinearLayoutManager linear =new LinearLayoutManager(this);

        recyclerViewCartPayment.setAdapter(foodCartAdapter);
        recyclerViewCartPayment.setLayoutManager(linear);
    }
}