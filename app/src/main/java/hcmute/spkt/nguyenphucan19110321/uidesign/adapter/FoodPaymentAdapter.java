package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.FoodCartHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.FoodPaymentHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;

public class FoodPaymentAdapter extends RecyclerView.Adapter<FoodPaymentHolder>{
    Context context;
    List<Order> orderList;

    public FoodPaymentAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public FoodPaymentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodPaymentHolder(LayoutInflater.from(context).inflate(R.layout.item_food_payment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodPaymentHolder holder, int position) {
        Order order = orderList.get(position);
        String TotalPrice = String.valueOf(order.getPrice()*order.getNumber());
        String Price = String.valueOf(order.getPrice());
        String Number = String.valueOf(order.getNumber());
//        holder.tvFoodNamePayment.setText(order.getName());
//        holder.tvNoFPayment.setText(Number);
//        holder.tvFoodPrice.setText(TotalPrice);
    }



    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
