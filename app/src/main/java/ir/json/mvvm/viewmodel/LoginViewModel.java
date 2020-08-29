package ir.json.mvvm.viewmodel;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private String username;
    private String password;
    private MutableLiveData<String> data = new MutableLiveData<>();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void sendToServer(View view){
        if (TextUtils.isEmpty(username))
            data.setValue("لطفا نام کاربری را وارد کنید");
        else if (TextUtils.isEmpty(password))
            data.setValue("لطفا رمز عبور را وارد کنید");
        else
            data.setValue("login");
    }

    public MutableLiveData<String> getData() {
        return data;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
