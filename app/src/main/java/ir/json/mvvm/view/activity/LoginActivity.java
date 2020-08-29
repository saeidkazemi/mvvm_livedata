package ir.json.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import ir.json.mvvm.R;
import ir.json.mvvm.databinding.ActivityLoginBinding;
import ir.json.mvvm.databinding.ActivityMainBinding;
import ir.json.mvvm.viewmodel.LoginViewModel;
import ir.json.mvvm.viewmodel.PostViewModel;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setData(loginViewModel);
        loginViewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}