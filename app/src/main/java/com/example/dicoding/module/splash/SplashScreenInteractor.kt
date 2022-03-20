package com.example.dicoding.module.splash

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashScreenInteractor : SplashScreenInterface.Interactor {
    private val disposable = CompositeDisposable()

    override fun startLoading(
        onSuccess: (Long) -> Unit,
        onError: (Throwable) -> Unit,
    ) {
        Single.timer(3, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
            .let(disposable::add)
    }
}