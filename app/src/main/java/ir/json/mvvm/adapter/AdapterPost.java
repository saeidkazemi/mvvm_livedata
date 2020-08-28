package ir.json.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.json.mvvm.R;
import ir.json.mvvm.databinding.ItemPostBinding;
import ir.json.mvvm.interfaces.ClickPostItem;
import ir.json.mvvm.model.Post;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.viewHolder> {
    private List<Post> posts;
    ClickPostItem clickPostItem;

    public AdapterPost(List<Post> posts,ClickPostItem clickPostItem) {
        this.posts=posts;
        this.clickPostItem=clickPostItem;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final Post post = posts.get(position);
        holder.binding.setPost(post);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPostItem.clickPostItem(post);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding binding;
        public viewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
