package ir.json.mvvm.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import ir.json.mvvm.model.User;
import ir.json.mvvm.repository.UserRepository;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    public UserViewModel() {
        userRepository = new UserRepository();
    }
    public LiveData<List<User>> getUserList() {
        return userRepository.getListUser();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
