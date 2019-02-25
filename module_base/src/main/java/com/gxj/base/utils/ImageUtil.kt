package com.gxj.base.utils

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView?, url: String) {
    imageView?.let {
        val options = RequestOptions()
//            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//            .placeholder(R.mipmap.ic_launcher_round)
//            .error(R.mipmap.ic_launcher_round)
//            .dontAnimate()

        Glide.with(it.context)
//            .asGif()
            .load(url)
            .into(it)
    }
}

fun loadImage(imageView: ImageView?, url: String) {
    if (imageView == null || TextUtils.isEmpty(url)) {
        return
    }
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)

}


