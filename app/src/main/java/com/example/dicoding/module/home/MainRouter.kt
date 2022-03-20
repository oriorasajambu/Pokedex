package com.example.dicoding.module.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.dicoding.constant.Constants
import com.example.dicoding.entity.Pokemon
import com.example.dicoding.module.about.AboutActivity
import com.example.dicoding.module.detail.DetailActivity

class MainRouter(private val activity: AppCompatActivity) : MainInterface.Router {
    override fun goToDetails(pokemon: Pokemon) {
        Intent(activity, DetailActivity::class.java).apply {
            putExtra(Constants.DATA_POKEMON.name, pokemon)
        }.also { activity.startActivity(it) }
    }

    override fun goToAbout() {
        Intent(activity, AboutActivity::class.java).also {
            activity.startActivity(it)
        }
    }
}