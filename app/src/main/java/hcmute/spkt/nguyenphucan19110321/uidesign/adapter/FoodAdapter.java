package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.data.GLOBAL;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.OrderDetails;
import hcmute.spkt.nguyenphucan19110321.uidesign.view.CartActivity;
import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.FoodHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;
import hcmute.spkt.nguyenphucan19110321.uidesign.view.ShopDetailActivity;

public class FoodAdapter extends RecyclerView.Adapter<FoodHolder> {

    private Context context;
    private List<Food> foodList;
    protected Order order;
    protected List<OrderDetails> orderDetailsList = new ArrayList<>();

    public FoodAdapter(Context context,List<Food> foodList, Order order){
        this.context = context;
        this.foodList = foodList;
        this.order = order;

    }
    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodHolder(LayoutInflater.from(context).inflate(R.layout.item_food_most,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        Food food = foodList.get(position);
        Picasso.get().load(food.getImage()).into(holder.imgFood);
        holder.tvNameFood.setText(food.getName());
        holder.tvDescriptionFood.setText(food.getDescription());
        holder.tvPriceFood.setText(String.valueOf(food.getPrice()));
        holder.btnAddFoodToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(GLOBAL.USER != null){
                    order.setIdUser(GLOBAL.USER.getId());
                    int flag = 0;
                    for(OrderDetails order : orderDetailsList){
                        if(order.getFoodID() == food.getId()){
                            flag = 1;
                            order.setNumber(order.getNumber()+1);
                        }
                    }
                    if(flag==0){
                        OrderDetails orderDetails = new OrderDetails(1,order.getId(),food.getId(),food.getName(),1,food.getPrice());
                        orderDetailsList.add(orderDetails);

                        Intent intent = new Intent(context, CartActivity.class);
                        intent.putExtra("order",order);
                        intent.putExtra("orderdetailslist",(Serializable) orderDetailsList);
                        context.startActivity(intent);
                    }
                } else{
                    Toast.makeText(context,"Bạn phải đăng nhập để thực hiện tính năng này",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void GoToCart() {
        Intent intent = new Intent(context, CartActivity.class);
        context.startActivity(intent);
    }



    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
