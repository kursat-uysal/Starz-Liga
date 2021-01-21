package com.hr190005.kursat_uysal_final.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideHelper {

    public static void useGlideWithUrl(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .fitCenter()
                .into(imageView);
    }
}
