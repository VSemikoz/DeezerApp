package ru.vssemikoz.deezerapp.features.adapters

import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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

class PlayListAdapter @Inject constructor() : BaseAdapter<PlayList>() {

    lateinit var windowManager: WindowManager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PlayList> {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        initViewSize(parent, view)
        return PlayListViewHolder(view, listener)
    }

    private fun initViewSize(parent: ViewGroup, view: View) {
        val metrics = DisplayMetrics()
        val margin = parent.context.resources.getDimension(R.dimen.margin_16dp).toInt()
        windowManager.defaultDisplay?.getMetrics(metrics)
        view.layoutParams.width = metrics.widthPixels / 3 - margin
        view.layoutParams.height = metrics.widthPixels / 3 - margin
        view.requestLayout()
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
            playListName.text = item.title.reduceString(15)
            ImageUtilsPicasso.setImageByUrl(playListImage, item.coverSmall)
        }

        private fun String.reduceString(reduceLength: Int): String = if (reduceLength > length) this
        else "${substring(0, reduceLength)}..."

    }

}
