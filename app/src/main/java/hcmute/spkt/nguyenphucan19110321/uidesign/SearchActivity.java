package hcmute.spkt.nguyenphucan19110321.uidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.SearchFoodAdapter;
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
        Toast.makeText(SearchActivity.this, String.valueOf(Database.foodList.size()), Toast.LENGTH_SHORT).show();
        SearchFoodAdapter searchFoodAdapter =new SearchFoodAdapter(this, Database.foodList);
        LinearLayoutManager linear =new LinearLayoutManager(this);
        recycleViewSearchFood.setAdapter(searchFoodAdapter);
        recycleViewSearchFood.setLayoutManager(linear);
    }
}