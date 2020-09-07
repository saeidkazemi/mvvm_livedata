package ir.json.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import ir.json.mvvm.adapter.AdapterPostDataBinding;
import ir.json.mvvm.databinding.ActivityMainBinding;
import ir.json.mvvm.interfaces.ClickPostItem;
import ir.json.mvvm.model.Post;
import ir.json.mvvm.viewmodel.PostViewModel;
import ir.json.mvvm.viewmodel.ViewModelProviderFactory;

public class MainActivity extends DaggerAppCompatActivity implements ClickPostItem {
    private ActivityMainBinding binding;
    private AdapterPostDataBinding adapterPost;
    private PostViewModel postViewModel;
    @Inject ViewModelProviderFactory factory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        postViewModel = new ViewModelProvider(this,factory).get(PostViewModel.class);
        postViewModel.getPostResponseLiveData().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                if (posts != null){
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                adapterPost = new AdapterPostDataBinding(posts,MainActivity.this::clickPostItem);
                binding.recyclerView.setAdapter(adapterPost);}
                else
                    Toast.makeText(MainActivity.this, "Check your connection to the network", Toast.LENGTH_SHORT).show();
            }
        });
        postViewModel.getPostRepository().progressState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (!aBoolean)binding.progressWheel.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void clickPostItem(Post post) {
        Toast.makeText(this, post.getName(), Toast.LENGTH_SHORT).show();
    }
}