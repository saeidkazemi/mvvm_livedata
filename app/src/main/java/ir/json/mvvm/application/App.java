package ir.json.mvvm.application;

import android.app.Application;

import androidx.room.Room;

import ir.json.mvvm.db.AppDatabase;

public class App extends Application {
    private static AppDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        initRoom();
    }

    public static AppDatabase getInstanceAppDatabase()
    {
        return database;
    }
    private void initRoom()
    {
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "test")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
}
