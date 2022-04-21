package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.view.CartActivity;
import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.FoodHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;

public class FoodAdapter extends RecyclerView.Adapter<FoodHolder> {

    private Context context;
    private List<Food> foodList;
    public FoodAdapter(Context context,List<Food> foodList){
        this.context = context;
        this.foodList = foodList;
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
                GoToCart();
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
