package com.gxj.base.base

import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val mDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        if (!mDisposable.isDisposed) {
            mDisposable.clear()
        }
    }

    protected fun Disposable.addDisposable() {
        mDisposable.add(this)
    }
}