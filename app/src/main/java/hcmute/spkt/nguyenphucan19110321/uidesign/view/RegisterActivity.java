package hcmute.spkt.nguyenphucan19110321.uidesign.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.provider.SelfDestructiveThread;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword,txtName;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        SetControl();
        SetEvent();
    }

    private void SetEvent() {
    btnRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickRegister();


        }
    });
    }

    private void onClickRegister() {
        Database database  =new Database(this,"Foody.sqlite",null,1);
        String name =txtName.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        User user = new User(email,password,name);
        user.InsertToDatabase(database);
    }

    private void SetControl(){
        txtEmail = findViewById(R.id.txtEmailRegister);
        txtName =findViewById(R.id.txtNameRegister);
        txtPassword =findViewById(R.id.txtPasswordRegister);
        btnRegister = findViewById(R.id.btnRegister);
    }


}