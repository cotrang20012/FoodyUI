package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Base64;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Food;

public class FoodHomeAdapter extends BaseAdapter {
    private Context context;
    private List<Food> foodList;
    private LayoutInflater layoutInflater;

    public FoodHomeAdapter(Context context, List<Food> foodList) {
        this.foodList = foodList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FoodHomeHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_food_home, viewGroup,false);
            holder = new FoodHomeHolder(view);
            view.setTag(holder);
        } else {
            holder = (FoodHomeHolder) view.getTag();
        }
        Food food = foodList.get(i);
        Picasso.get().load(food.getImage()).into(holder.imvItemFood);
        holder.lbName.setText(food.getName());
        holder.lbDesc.setText(food.getDescription());
        return view;
    }
}


