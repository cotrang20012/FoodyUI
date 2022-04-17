package hcmute.spkt.nguyenphucan19110321.uidesign.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.ShopDetailActivity;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.ShopHomeAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.event.IClickItemShopHomeListener;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Shop;


public class HomeFragment extends Fragment {

    GridView gridViewFoodHome;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridViewFoodHome = view.findViewById(R.id.gridViewFoodHome);
        if(Database.SHOP_LIST.size()==0){
            Database.MakeData();
        }
        ShopHomeAdapter shopHomeAdapter = new ShopHomeAdapter(this.getContext(), Database.SHOP_LIST, new IClickItemShopHomeListener() {
            @Override
            public void onClickItemShopHome(Shop shop) {
                GoToShopDetail(shop);
            }

        });
        gridViewFoodHome.setAdapter(shopHomeAdapter);

    }

    private void GoToShopDetail(Shop shop) {
        Intent intent = new Intent(this.getContext(), ShopDetailActivity.class);
        Gson gson = new Gson();
        String shopJSON = gson.toJson(shop);
        intent.putExtra("Shop",shopJSON);
        startActivity(intent);
    }
}