package hcmute.spkt.nguyenphucan19110321.uidesign.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.SearchShopAdapter;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recycleViewSearchFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setControl();
        LoadData();
    }

    private void setControl(){
        recycleViewSearchFood =findViewById(R.id.recycleViewSearchFood);
    }

    private void LoadData(){
        Toast.makeText(SearchActivity.this, String.valueOf(Database.SHOP_LIST.size()), Toast.LENGTH_SHORT).show();
        SearchShopAdapter searchShopAdapter =new SearchShopAdapter(this, Database.SHOP_LIST);
        LinearLayoutManager linear =new LinearLayoutManager(this);
        recycleViewSearchFood.setAdapter(searchShopAdapter);
        recycleViewSearchFood.setLayoutManager(linear);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}