package com.example.dicoding.module.detail

import androidx.appcompat.app.AppCompatActivity
import com.example.dicoding.constant.Constants
import com.example.dicoding.entity.Pokemon

class DetailPresenter(
    private var view: DetailInterface.View? = null
): DetailInterface.Presenter {

    private var interactor: DetailInterface.Interactor? = null
    private var router: DetailInterface.Router? = null
    private lateinit var pokemon: Pokemon

    override fun onCreate(activity: AppCompatActivity) {
        view = activity as DetailActivity
        interactor = DetailInteractor()
        router = DetailRouter()
        getDataIntent(activity)
        initView()
    }

    override fun onDestroy() {
        view = null
        router = null
    }

    private fun getDataIntent(activity: AppCompatActivity) = with(activity.intent) {
        pokemon = this.getParcelableExtra<Pokemon>(Constants.DATA_POKEMON.name) as Pokemon
    }

    private fun initView() {
        view?.setToolbar()
        view?.setData(pokemon)
    }
}