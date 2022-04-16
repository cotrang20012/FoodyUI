package hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;

public class FoodHomeHolder extends RecyclerView.ViewHolder {
    public final ImageView imvItemFood;
    public final TextView lbName,lbDesc;


    public  FoodHomeHolder(@NonNull View itemView) {
        super(itemView);
        imvItemFood = itemView.findViewById(R.id.imvItemFood);
        lbName = itemView.findViewById(R.id.tvNameFoodHome);
        lbDesc = itemView.findViewById(R.id.tvDescriptionFoodHome);
    }
}
