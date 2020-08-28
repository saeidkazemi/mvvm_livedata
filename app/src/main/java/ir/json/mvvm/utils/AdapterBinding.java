package ir.json.mvvm.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class AdapterBinding {
    @BindingAdapter("image")
    public static void Image(ImageView view, String url){
        Glide.with(view).load(url).into(view);
    }
}
