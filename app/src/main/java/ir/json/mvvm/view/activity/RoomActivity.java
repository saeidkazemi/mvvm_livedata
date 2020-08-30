package ir.json.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ir.json.mvvm.R;

import ir.json.mvvm.model.User;
import ir.json.mvvm.viewmodel.UserViewModel;

public class RoomActivity extends AppCompatActivity {
    private static final String TAG = "RoomActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for (User user : users)
                    Log.e(TAG, "onChanged: " + user.getFirstName() + " " + user.getLastName());
            }
        });

    }
}