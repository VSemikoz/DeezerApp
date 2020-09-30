package ru.vssemikoz.deezerapp.features.playlistselection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.play_list_selection_frag.view.*
import ru.vssemikoz.deezerapp.BR
import ru.vssemikoz.deezerapp.DeezerApplication
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.base.adapter.BaseAdapter
import ru.vssemikoz.deezerapp.databinding.PlayListSelectionFragBinding
import ru.vssemikoz.deezerapp.features.adapters.PlayListAdapter
import ru.vssemikoz.deezerapp.models.PlayList
import javax.inject.Inject


class PlayListSelectionFragment : Fragment() {
    @Inject
    lateinit var viewModel: PlayListSelectionViewModel

    @Inject
    lateinit var adapter: PlayListAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DeezerApplication.getApplicationComponent().fragmentComponent().inject(this)
        viewModel.navigator = activity as PlayListSelectionActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: PlayListSelectionFragBinding =
            DataBindingUtil.inflate(inflater, R.layout.play_list_selection_frag, container, false)
        val view = binding.root
        binding.vmPlaylistScreen = viewModel
        binding.setVariable(BR.vm_playlist_screen, viewModel)
        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View) {
        val numberOfColumns = 3
        recyclerView = view.rv_playlist
        recyclerView.layoutManager = GridLayoutManager(context, numberOfColumns)
        adapter.windowManager = activity!!.windowManager
        adapter.listener = object : BaseAdapter.OnRecyclerItemClickListener {
            override fun onRecyclerItemClick(position: Int, imageView: ImageView) {
                val playList = adapter.items?.get(position)
                playList?.let { viewModel.onPlayListClick(it, imageView) }
            }
        }
        recyclerView.adapter = adapter
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val playListUpdateObserver: Observer<List<PlayList>> = Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
        viewModel.items.observe(this, playListUpdateObserver)
        viewModel.start()
    }

}
