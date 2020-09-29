package ru.vssemikoz.deezerapp.features

import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import de.hdodenhof.circleimageview.CircleImageView

//@CoordinatorLayout.DefaultBehavior(PlayListDetailsBehavior::class)
class PlayListDetailsBehavior<V: View>() : CoordinatorLayout.Behavior<V>() {
    interface OnSwipeListener{
        fun onSwipe()
    }
    override fun layoutDependsOn(parent: CoordinatorLayout, child: V, dependency: View): Boolean {
        Log.d("PlayListDetailsBehavior", "layoutDependsOn")
        return dependency is Toolbar
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: V,
        dependency: View
    ): Boolean {
        Log.d("PlayListDetailsBehavior", "onDependentViewChanged")

        return super.onDependentViewChanged(parent, child, dependency)
    }
}
