package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.SearchShopHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;

public class SearchShopAdapter extends RecyclerView.Adapter<SearchShopHolder> {
    Context context;
    List<Shop> shopList;

    public SearchShopAdapter(Context context, List<Shop> list) {
        this.shopList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchShopHolder(LayoutInflater.from(context).inflate(R.layout.item_search_shop, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchShopHolder holder, int position) {
        Shop shop = shopList.get(position);
        Picasso.get().load(shop.getImageSearch()).into(holder.imgShopSearch);
        holder.tvNameShopSearch.setText(shop.getName());
        holder.tvAddressShopSearch.setText(shop.getAddress());
        holder.tvTypeStoreShopSearch.setText(shop.getType());
        holder.tvRateShopSearch.setText(String.valueOf(shop.getRate()));
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }
}
