package ir.json.mvvm.remote;

import java.util.List;

import ir.json.mvvm.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("api/json/get/4k-1IhJlt")
    Call<List<Post>> getListPost();
}
