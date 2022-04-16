package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.SearchFoodHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;

public class SearchFoodAdapter extends RecyclerView.Adapter<SearchFoodHolder> {
    Context context;
    List<Food> foodList;

    public SearchFoodAdapter(Context context, List<Food> list) {
        this.foodList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchFoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchFoodHolder(LayoutInflater.from(context).inflate(R.layout.item_search_food, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchFoodHolder holder, int position) {
        Food food = foodList.get(position);
        Picasso.get().load(food.getImageSearch()).into(holder.imgFoodSearch);
        holder.tvNameFoodSearch.setText(food.getName());
        holder.tvAddressFoodSearch.setText(food.getAddress());
        holder.tvTypeStoreFoodSearch.setText(food.getType());
        holder.tvRateFoodSearch.setText(String.valueOf(food.getRate()));
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
