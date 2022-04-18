package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.FoodCartHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.FoodHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;

public class FoodCartAdapter extends RecyclerView.Adapter<FoodCartHolder> {
    private Context context;
    private List<Order> orderList;

    public FoodCartAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public FoodCartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new FoodCartHolder(LayoutInflater.from(context).inflate(R.layout.item_food_cart,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodCartHolder holder, int position) {
        Order order = orderList.get(position);
        String TotalPrice = String.valueOf(order.getPrice()*order.getNumber());
        String Price = String.valueOf(order.getPrice());
        String Number = String.valueOf(order.getNumber());
        holder.tvFoodNameCart.setText(order.getName());
        holder.tvNumberofFood.setText(Number);
        holder.tvTotal.setText(Price+"đ x "+Number+" = "+TotalPrice+"đ");
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
