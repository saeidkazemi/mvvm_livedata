package ir.json.mvvm.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ir.json.mvvm.model.User;

@Database(entities = {User.class}, version = 3,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
