package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.ShopHomeHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;

public class ShopHomeAdapter extends BaseAdapter {
    private Context context;
    private List<Shop> shopList;
    private LayoutInflater layoutInflater;

    public ShopHomeAdapter(Context context, List<Shop> shopList) {
        this.shopList = shopList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return shopList.size();
    }

    @Override
    public Object getItem(int i) {
        return shopList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ShopHomeHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_shop_home, viewGroup,false);
            holder = new ShopHomeHolder(view);
            view.setTag(holder);
        } else {
            holder = (ShopHomeHolder) view.getTag();
        }
        Shop shop = shopList.get(i);
        Picasso.get().load(shop.getImage()).into(holder.imvItemShop);
        holder.lbName.setText(shop.getName());
        holder.lbDesc.setText(shop.getDescription());
        return view;
    }
}


