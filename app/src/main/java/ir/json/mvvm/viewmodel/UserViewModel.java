package ir.json.mvvm.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.json.mvvm.model.User;
import ir.json.mvvm.repository.UserRepository;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    public UserViewModel() {
        userRepository = new UserRepository();
    }
    public LiveData<List<User>> getUserList() {
        return userRepository.getListUser();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
