package com.example.dicoding.module.home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dicoding.entity.Pokemon
import com.example.dicoding.module.adapter.OnItemClickedListener

class MainPresenter(
    private var view: MainInterface.View? = null,
) : MainInterface.Presenter, OnItemClickedListener {

    private var interactor: MainInterface.Interactor? = null
    private var router: MainInterface.Router? = null

    override fun onCreate(activity: AppCompatActivity) {
        view = activity as MainActivity
        interactor = MainInteractor()
        router = MainRouter(activity)
        initView()
    }

    override fun onDestroy() {
        view = null
        router = null
    }

    private fun initView() {
        view?.setToolbar()
        view?.setRecyclerView()
        interactor?.getDataPokemon(
            { response ->
                view?.setDataPokedex(response)
            },
            { response ->
                Log.e("Error", response.message.toString())
            }
        )
    }

    override fun onClickedPokemon(pokemon: Pokemon) {
        router?.goToDetails(pokemon)
    }

    override fun onClickedAbout() {
        router?.goToAbout()
    }
}