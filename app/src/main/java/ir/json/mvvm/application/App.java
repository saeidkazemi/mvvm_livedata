package ir.json.mvvm.application;
import androidx.room.Room;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import ir.json.mvvm.db.AppDatabase;
import ir.json.mvvm.di.component.AppComponent;
import ir.json.mvvm.di.component.DaggerAppComponent;

public class App extends DaggerApplication {
    private static AppDatabase database;
    private final AppComponent appInjector = DaggerAppComponent.builder().application(this).build();
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

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return appInjector;
    }
}
