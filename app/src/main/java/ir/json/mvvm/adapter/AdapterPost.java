package ir.json.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ir.json.mvvm.R;
import ir.json.mvvm.databinding.ItemPostBinding;
import ir.json.mvvm.interfaces.ClickPostItem;
import ir.json.mvvm.model.Post;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.viewHolder> {
    private List<Post> posts;
    private ClickPostItem clickPostItem;
    private Context mContext;
    private ItemPostBinding binding;
    public AdapterPost(List<Post> posts, ClickPostItem clickPostItem, Context mContext) {
        this.posts=posts;
        this.clickPostItem=clickPostItem;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = ItemPostBinding.inflate(inflater,parent,false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final Post post = posts.get(position);
        Glide.with(mContext).load(posts.get(position).getImage())
                .into(holder.binding.image);
        holder.binding.name.setText(posts.get(position).getName());
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
        private ItemPostBinding binding;
        public viewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
