package hcmute.spkt.nguyenphucan19110321.uidesign.view.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hcmute.spkt.nguyenphucan19110321.uidesign.view.LoginActivity;
import hcmute.spkt.nguyenphucan19110321.uidesign.R;

public class AccountFragment extends Fragment {

    private Button btnGoToLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        SetControl(view);
        SetEvent();
    }

    public void SetControl(View view) {
        btnGoToLogin = view.findViewById(R.id.btnGoToLogin);
    }

    private void SetEvent() {
        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToLogin();
            }
        });
    }

    private void GoToLogin() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }
}