package ir.json.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Observable;

import ir.json.mvvm.databinding.ItemPostBinding;
import ir.json.mvvm.databinding.ItemPostDataBindingBinding;
import ir.json.mvvm.interfaces.ClickPostItem;
import ir.json.mvvm.model.Post;

public class AdapterPostDataBinding extends RecyclerView.Adapter<AdapterPostDataBinding.viewHolder> {
    private List<Post> posts;
    private ClickPostItem clickPostItem;
    private Context mContext;
    private ItemPostDataBindingBinding binding;
    public AdapterPostDataBinding(List<Post> posts, ClickPostItem clickPostItem, Context mContext) {
        this.posts=posts;
        this.clickPostItem=clickPostItem;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemPostDataBindingBinding.inflate(inflater,parent,false);
        return new viewHolder(binding);
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
        private ItemPostDataBindingBinding binding;
        public viewHolder(@NonNull ItemPostDataBindingBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
