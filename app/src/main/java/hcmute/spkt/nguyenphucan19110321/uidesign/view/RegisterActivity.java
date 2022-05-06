package hcmute.spkt.nguyenphucan19110321.uidesign.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.regex.Pattern;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.data.Database;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.DAO.UserDAO;
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
        try {
            Database database  =new Database(this,"Foody.sqlite",null,1);
            String name =txtName.getText().toString().trim();
            String email = txtEmail.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();

            String EMAIL_PATTERN =
                    "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
            if(!Pattern.matches(EMAIL_PATTERN,email)){
                Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
                return;
            }
            if(name.length()<2){
                Toast.makeText(this, "Tên phải dài hơn 1 kí tự", Toast.LENGTH_SHORT).show();
                return;
            }
            if(password.length()<5){
                Toast.makeText(this, "Mật khẩu phải dài hơn 5 kí tự", Toast.LENGTH_SHORT).show();
                return;
            }
            UserDAO userDAO = new UserDAO(database);
            if(userDAO.CheckExistEmail(email)){
                Toast.makeText(this,"Email đã tồn tại",Toast.LENGTH_SHORT).show();
                return;
            }
            int index = email.indexOf("@");
            String username = "";
            if(index>-1){
                username =email.substring(index);
            }
            User user = new User(email,username,password,name);
            user.InsertToDatabase(database);
            Toast.makeText(this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
            GoToLogin();
        }catch (Exception ex){
            Toast.makeText(this, "Lỗi đăng ký", Toast.LENGTH_SHORT).show();
        }

    }

    private void GoToLogin() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void SetControl(){
        txtEmail = findViewById(R.id.txtEmailRegister);
        txtName =findViewById(R.id.txtNameRegister);
        txtPassword =findViewById(R.id.txtPasswordRegister);
        btnRegister = findViewById(R.id.btnRegister);
    }


}