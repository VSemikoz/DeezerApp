package ru.vssemikoz.deezerapp.features

import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView

class PlayListDetailsBehavior() : CoordinatorLayout.Behavior<RecyclerView>() {
    var listener: OnSwipeListener? = null
    interface OnSwipeListener{
        fun onSwipe()
    }
    override fun layoutDependsOn(parent: CoordinatorLayout, child: RecyclerView, dependency: View): Boolean {
        Log.d("PlayListDetailsBehavior", "layoutDependsOn")
        return dependency is Toolbar
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: RecyclerView,
        dependency: View
    ): Boolean {
        Log.d("PlayListDetailsBehavior", "onDependentViewChanged")

        return super.onDependentViewChanged(parent, child, dependency)
    }
}
