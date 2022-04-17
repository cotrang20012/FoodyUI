package hcmute.spkt.nguyenphucan19110321.uidesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.view.HomeFragment;
import hcmute.spkt.nguyenphucan19110321.uidesign.view.ListFragment;
import hcmute.spkt.nguyenphucan19110321.uidesign.view.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment;
            switch (item.getItemId()){
                case R.id.miHome: {
                   selectedFragment = new HomeFragment();
                    break;
                }
                case R.id.miList: {
                    selectedFragment = new ListFragment();
                    break;
                }
                case R.id.miPerson: {
                    selectedFragment = new ProfileFragment();
                    break;
                }
                default:
                    selectedFragment = new HomeFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayoutMain,selectedFragment).commit();
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        setEventNavigation();
        if(Database.SHOP_LIST.size()==0){
            Database.MakeData();
        }

    }

    protected  void setEventNavigation(){
        bottomNavigation.setOnItemSelectedListener(navListener);
        bottomNavigation.setSelectedItemId(R.id.miHome);
    }

    public void onCickSearchBar(View view) {
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }
}