package ru.vssemikoz.deezerapp.features

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.playlist_item.view.*
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.base.adapter.BaseAdapter
import ru.vssemikoz.deezerapp.base.adapter.BaseViewHolder
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.utils.ImageUtilsPicasso
import javax.inject.Inject

class PlayListAdapter @Inject constructor():  BaseAdapter<PlayList>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PlayList> {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        return PlayListViewHolder(view, listener)
    }

    class PlayListViewHolder(view: View, listener: OnRecyclerItemClickListener?) :
        BaseViewHolder<PlayList>(view) {
        private val cardView: CardView = view.cv_playlist_item
        private val playListName: TextView = view.tv_name
        private val playListImage: ImageView = view.iv_image

        init {
            cardView.setOnClickListener {
                listener?.onRecyclerItemClick(adapterPosition, playListImage)
            }
        }

        override fun onBind(item: PlayList, listener: OnRecyclerItemClickListener?) {
            playListName.text = item.title
            ImageUtilsPicasso.setImageByUrl(item.cover, playListImage)
        }

    }

}
