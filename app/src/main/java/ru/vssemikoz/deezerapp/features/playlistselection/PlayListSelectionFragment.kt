package ru.vssemikoz.deezerapp.features.playlistselection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.play_list_selection_frag.view.*
import ru.vssemikoz.deezerapp.DeezerApplication
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.base.adapter.BaseAdapter
import ru.vssemikoz.deezerapp.databinding.PlayListSelectionFragBinding
import ru.vssemikoz.deezerapp.features.PlayListAdapter
import ru.vssemikoz.deezerapp.models.PlayList
import javax.inject.Inject


class PlayListSelectionFragment : Fragment() {
    @Inject
    lateinit var viewModel: PlayListSelectionViewModel

    @Inject
    lateinit var recyclerViewAdapter: PlayListAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DeezerApplication.getApplicationComponent().fragmentComponent().inject(this)
        viewModel.setNavigator(activity as PlayListSelectionActivity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.play_list_selection_frag, container, false)
        val viewDataBinding: PlayListSelectionFragBinding = PlayListSelectionFragBinding.bind(view)
        viewDataBinding.viewmodel = viewModel
        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View) {
        val numberOfColumns = 3
        recyclerView = view.rv_playlist
        recyclerView.layoutManager = GridLayoutManager(context, numberOfColumns)
        recyclerViewAdapter.windowManager = activity!!.windowManager
        recyclerViewAdapter.listener = object : BaseAdapter.OnRecyclerItemClickListener {
            override fun onRecyclerItemClick(position: Int, imageView: ImageView) {
                val playList = recyclerViewAdapter.items?.get(position)
                playList?.let { viewModel.onPlayListClick(it) }
            }
        }
        recyclerView.adapter = recyclerViewAdapter
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val userListUpdateObserver: Observer<List<PlayList>> = Observer {
            recyclerViewAdapter.items = it
            recyclerViewAdapter.notifyDataSetChanged()
        }
        viewModel.items.observe(this, userListUpdateObserver)
        viewModel.start()
    }

}
