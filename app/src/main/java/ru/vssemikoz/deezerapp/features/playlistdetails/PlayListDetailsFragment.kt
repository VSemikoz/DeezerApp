package ru.vssemikoz.deezerapp.features.playlistdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import ru.vssemikoz.deezerapp.DeezerApplication
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.databinding.PlaylistDetailsFragBinding
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track
import javax.inject.Inject


class PlayListDetailsFragment : Fragment() {
    @Inject
    lateinit var viewModel: PlayListDetailsViewModel

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
        setupCoordinateLayout(view)
        return view
    }

    private fun setupCoordinateLayout(view: View) {
//        val coordinatorLayout = view.findViewById<AppBarLayout>(R.id.appbar)
//        val behavior: PlayListDetailsBehavior<CollapsingToolbarLayout> = PlayListDetailsBehavior()
//        behavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY );
//        behavior.listener = object : SwipeDismissBehavior.OnDismissListener{
//            override fun onDismiss(view: View?) {
//                Log.d("setupCoordinateLayout", "onDismiss")
//            }
//
//            override fun onDragStateChanged(state: Int) {
//                Log.d("setupCoordinateLayout", "onDragStateChanged")
//            }
//
//        }
//        var params = coordinatorLayout.layoutParams as (CoordinatorLayout.LayoutParams)
//        params.behavior = behavior
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.start()
    }
}
