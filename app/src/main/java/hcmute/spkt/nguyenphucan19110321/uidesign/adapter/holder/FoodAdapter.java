package hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;

public class FoodAdapter extends RecyclerView.Adapter<FoodHolder> {

    Context context;
    List<Food> foodList;
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
        holder.tvPriceFood.setText(food.getPrice());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
