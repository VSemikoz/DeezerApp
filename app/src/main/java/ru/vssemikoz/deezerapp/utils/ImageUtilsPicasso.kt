package ru.vssemikoz.deezerapp.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso
import ru.vssemikoz.deezerapp.DeezerApplication
import ru.vssemikoz.deezerapp.R

object ImageUtilsPicasso {
    fun setImageByUrl(url: String, imageView: ImageView) {
        Picasso.with(DeezerApplication.getInstance()?.applicationContext)
            .load(url)
            .error(R.mipmap.ic_launcher)
            .into(imageView)
    }

}
