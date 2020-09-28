package ru.vssemikoz.deezerapp.base

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import ru.vssemikoz.deezerapp.BR

abstract class BaseViewModel<N> : BaseObservable() {
    @Bindable
    var loading = true
        set(value) {
            field = value
            notifyPropertyChanged(BR._all)
        }

    var navigator: N? = null

    abstract fun start()
}
