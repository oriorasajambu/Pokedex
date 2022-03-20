package com.example.dicoding.module.home

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding.entity.Pokemon

interface MainInterface {
    interface View {
        fun setDataPokedex(list: List<Pokemon>)
        fun setRecyclerView(): RecyclerView
        fun setToolbar()
    }

    interface Presenter {
        fun onCreate(activity: AppCompatActivity)
        fun onDestroy()
        fun onClickedAbout()
    }

    interface Interactor {
        fun getDataPokemon(
            onSuccess: (List<Pokemon>) -> Unit,
            onError: (Throwable) -> Unit
        )
    }

    interface Router {
        fun goToDetails(pokemon: Pokemon)
        fun goToAbout()
    }
}