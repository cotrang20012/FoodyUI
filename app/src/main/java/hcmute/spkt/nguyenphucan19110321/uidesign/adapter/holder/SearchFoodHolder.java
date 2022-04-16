package hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;


public class SearchFoodHolder extends RecyclerView.ViewHolder{

    public final ImageView imgFoodSearch;
    public final TextView tvNameFoodSearch;
    public final TextView tvAddressFoodSearch;
    public final TextView tvTypeStoreFoodSearch;
    public final TextView tvRateFoodSearch;
    public SearchFoodHolder(@NonNull View itemView) {
        super(itemView);
        this.imgFoodSearch = itemView.findViewById(R.id.imgFoodSearch);
        this.tvNameFoodSearch =itemView.findViewById(R.id.tvNameFoodSearch);
        this.tvAddressFoodSearch = itemView.findViewById(R.id.tvAddressFoodSearch);
        this.tvTypeStoreFoodSearch = itemView.findViewById(R.id.tvTypeStoreFoodSearch);
        this.tvRateFoodSearch =itemView.findViewById(R.id.tvRateFoodSearch);
    }
}
