package ru.vssemikoz.deezerapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import ru.vssemikoz.deezerapp.DeezerApplication
import ru.vssemikoz.deezerapp.R

class ImageUtilsPicasso {
    companion object{
        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun setImageByUrl(imageView: ImageView, url: String) {
            Picasso.with(DeezerApplication.getInstance()?.applicationContext)
                .load(url)
                .error(R.mipmap.no_image_found)
                .into(imageView)
        }
    }
}
