package hcmute.spkt.nguyenphucan19110321.uidesign.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.GLOBAL;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.DAO.UserDAO;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.User;

public class LoginActivity extends AppCompatActivity {

    private Database database;
    private EditText txtEmailLogin,txtPasswordLogin;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = new Database(this,"Foody.sqlite",null,1);
        SetControl();
        SetEvent();
        LoadDataFromSharePref();
    }

    private void LoadDataFromSharePref() {
        SharedPreferences pref = getSharedPreferences("USER",MODE_PRIVATE);
        String username = pref.getString("email","");
        String password =pref.getString("password","");
        this.txtEmailLogin.setText(username);
        this.txtPasswordLogin.setText(password);
    }

    private void SetEvent(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLogin();
            }
        });
    }

    private void SetControl(){
        txtEmailLogin = findViewById(R.id.txtEmailLogin);
        txtPasswordLogin = findViewById(R.id.txtPasswordLogin);
        btnLogin  =findViewById(R.id.btnLogin);
    }

    public void onClickGoToRegister(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        finish();
    }

    private void onClickLogin(){
        User user =new User(txtEmailLogin.getText().toString().trim(),txtPasswordLogin.getText().toString().trim());
        UserDAO userDAO = new UserDAO(database);
        User userLogin = userDAO.CheckLogin(user);
        if(userLogin==null){
            Toast.makeText(this,"Sai email hoặc mật khẩu",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            GLOBAL.USER = userLogin;
            SharedPreferences.Editor pref = getSharedPreferences(GLOBAL.PREF_USER,MODE_PRIVATE).edit();
            pref.putString("email",txtEmailLogin.getText().toString().trim());
            pref.putString("password",txtPasswordLogin.getText().toString().trim());
            pref.apply();
            GoToMainActivity();
        }
    }

    private void GoToMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}