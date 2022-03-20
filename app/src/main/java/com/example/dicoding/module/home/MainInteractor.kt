package com.example.dicoding.module.home

import com.example.dicoding.constant.DataDummy
import com.example.dicoding.entity.Pokemon
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainInteractor : MainInterface.Interactor {

    private val disposable = CompositeDisposable()

    override fun getDataPokemon(
        onSuccess: (List<Pokemon>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        Single.just(DataDummy.listDataDummy())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
            .let(disposable::add)
    }

}