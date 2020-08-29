package ir.json.mvvm.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ir.json.mvvm.model.Post;
import ir.json.mvvm.remote.ApiRequest;
import ir.json.mvvm.remote.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private ApiRequest apiRequest;
    public MutableLiveData<Boolean> progressState = new MutableLiveData<>();
    public PostRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }
    public LiveData<List<Post>> getListPost()
    {
        final MutableLiveData<List<Post>> data = new MutableLiveData<>();
        apiRequest.getListPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful())
                {
                    data.setValue(response.body());
                    progressState.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                data.setValue(null);
                progressState.setValue(false);
            }
        });
        return data;
    }
}
