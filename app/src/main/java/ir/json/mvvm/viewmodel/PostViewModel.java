package ir.json.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import ir.json.mvvm.model.Post;
import ir.json.mvvm.repository.PostRepository;

public class PostViewModel extends ViewModel {
    private PostRepository postRepository;
    private LiveData<List<Post>> postResponseLiveData;

    @Inject
    public PostViewModel(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.postResponseLiveData = postRepository.getListPost();
    }

    public LiveData<List<Post>> getPostResponseLiveData()
    {
        return postResponseLiveData;
    }

    public PostRepository getPostRepository() {
        return postRepository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
