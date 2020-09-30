package ru.vssemikoz.deezerapp.features.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.track_item.view.*
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.base.adapter.BaseAdapter
import ru.vssemikoz.deezerapp.base.adapter.BaseViewHolder
import ru.vssemikoz.deezerapp.models.Track
import ru.vssemikoz.deezerapp.utils.mappers.TrackDateConverter
import javax.inject.Inject

class TrackAdapter @Inject constructor() : BaseAdapter<Track>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Track> {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.track_item, parent, false)
        return TrackViewHolder(view)
    }

    class TrackViewHolder(view: View) : BaseViewHolder<Track>(view) {
        private val trackNameTV: TextView = view.tv_track_name
        private val trackDurationTV: TextView = view.tv_track_duration
        private val trackArtistNameTV: TextView = view.tv_track_artist_name

        override fun onBind(item: Track, listener: OnRecyclerItemClickListener?) {
            trackNameTV.text = item.title
            trackDurationTV.text = TrackDateConverter.map(item.duration)
            trackArtistNameTV.text = item.artist.name
        }
    }
}
