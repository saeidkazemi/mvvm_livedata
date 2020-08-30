package ir.json.mvvm.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.json.mvvm.application.App;
import ir.json.mvvm.db.AppDatabase;
import ir.json.mvvm.model.Post;
import ir.json.mvvm.model.User;
import ir.json.mvvm.remote.ApiRequest;
import ir.json.mvvm.remote.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private AppDatabase database;
    public UserRepository() {
        database = App.getInstanceAppDatabase();
    }
    public LiveData<List<User>> getListUser()
    {
        return database.userDao().getAll();
    }
}
