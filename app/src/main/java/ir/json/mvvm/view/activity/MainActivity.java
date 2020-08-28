package ir.json.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.List;

import ir.json.mvvm.R;
import ir.json.mvvm.adapter.AdapterPost;
import ir.json.mvvm.databinding.ActivityMainBinding;
import ir.json.mvvm.interfaces.ClickPostItem;
import ir.json.mvvm.model.Post;
import ir.json.mvvm.viewmodel.PostViewModel;

public class MainActivity extends AppCompatActivity implements ClickPostItem {
    ActivityMainBinding binding;
    AdapterPost adapterPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PostViewModel postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        LiveData<List<Post>> listMutableLiveData=postViewModel.getPostResponseLiveData();
        listMutableLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                adapterPost = new AdapterPost(posts,MainActivity.this::clickPostItem,MainActivity.this);
                binding.recyclerView.setAdapter(adapterPost);
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