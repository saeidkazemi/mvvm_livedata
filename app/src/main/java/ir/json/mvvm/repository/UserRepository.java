package ir.json.mvvm.repository;



import androidx.lifecycle.LiveData;

import java.util.List;


import io.reactivex.rxjava3.core.Maybe;

import io.reactivex.rxjava3.core.Observable;
import ir.json.mvvm.application.App;
import ir.json.mvvm.db.AppDatabase;

import ir.json.mvvm.model.User;


public class UserRepository {
    private AppDatabase database;
    public UserRepository() {
        database = App.getInstanceAppDatabase();
    }
    public LiveData<List<User>> getListUser()
    {
        return database.userDao().getAll();
    }

    public Observable<List<User>> getListUserObservable()
    {
        return database.userDao().getAllUserObservable();
    }
}
