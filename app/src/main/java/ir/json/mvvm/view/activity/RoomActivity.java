package ir.json.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ir.json.mvvm.R;
import ir.json.mvvm.db.AppDatabase;
import ir.json.mvvm.db.User;

public class RoomActivity extends AppCompatActivity {
    private static final String TAG = "RoomActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "AppDatabase")
                .allowMainThreadQueries()
                .build();
        User user = new User();
        user.firstName = "saeed";
        user.lastName = "kazemi";
        db.userDao().insertAll(user);

        List<User> users = db.userDao().getAll();
        for (User data : users)
            Log.e(TAG, "onCreate: " + data.firstName + " " + data.lastName);
    }
}