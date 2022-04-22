package hcmute.spkt.nguyenphucan19110321.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import hcmute.spkt.nguyenphucan19110321.uidesign.data.GLOBAL;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.User;

public class ProfileActivity extends AppCompatActivity {

    private Button btnEditProfile,btnFinish;
    private TextView tvNameProfile,tvAddressProfile,tvGenderProfile,tvPhoneProfile;
    private  User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SetControl();
        SetEvent();
        LoadData();
    }

    private void SetEvent() {
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void SetControl(){
        tvAddressProfile =findViewById(R.id.tvAddressProfile);
        tvNameProfile = findViewById(R.id.tvNameProfile);
        tvGenderProfile=findViewById(R.id.txtGenderProfile);
        tvPhoneProfile = findViewById(R.id.txtGenderProfile);
        btnFinish = findViewById(R.id.btnFinishProfile);

    }
    private void LoadData(){
        user =  GLOBAL.USER;
        if(user!=null){
            tvNameProfile.setText(user.getName());
            tvAddressProfile.setText(user.getAddress());
            tvPhoneProfile.setText(user.getPhone());
            tvGenderProfile.setText(user.getGender());
        }
    }
}