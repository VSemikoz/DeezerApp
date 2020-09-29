package ru.vssemikoz.deezerapp.features.playlistdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.playlist_details_frag.view.*
import ru.vssemikoz.deezerapp.DeezerApplication
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.databinding.PlaylistDetailsFragBinding
import ru.vssemikoz.deezerapp.features.PlayListDetailsBehavior
import ru.vssemikoz.deezerapp.features.adapters.TrackAdapter
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track
import javax.inject.Inject


class PlayListDetailsFragment : Fragment() {
    @Inject
    lateinit var viewModel: PlayListDetailsViewModel
    @Inject
    lateinit var adapter: TrackAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DeezerApplication.getApplicationComponent().fragmentComponent().inject(this)
        viewModel.navigator = activity as PlayListDetailsActivity
        activity?.intent?.extras.let {
            if (it != null) {
                viewModel.playList = it.getSerializable("playListItem") as PlayList
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.playlist_details_frag, container, false)
        val viewDataBinding: PlaylistDetailsFragBinding = PlaylistDetailsFragBinding.bind(view)
        viewDataBinding.vmDetails = viewModel
        initRecyclerView(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val trackListUpdateObserver: Observer<List<Track>> = Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
        viewModel.trackList.observe(this, trackListUpdateObserver)
        viewModel.start()
    }

    private fun initRecyclerView(view: View) {
        recyclerView = view.rv_tracklist
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}
