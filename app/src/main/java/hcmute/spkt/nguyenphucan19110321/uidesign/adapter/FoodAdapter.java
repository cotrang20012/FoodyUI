package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.FoodHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.event.IClickItemShopHomeListener;
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
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
