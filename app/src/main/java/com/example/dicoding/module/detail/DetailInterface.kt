package com.example.dicoding.module.detail

import androidx.appcompat.app.AppCompatActivity
import com.example.dicoding.entity.Pokemon

interface DetailInterface {
    interface View {
        fun setData(pokemon: Pokemon)
        fun setToolbar()
    }

    interface Presenter {
        fun onCreate(activity: AppCompatActivity)
        fun onDestroy()
    }

    interface Interactor

    interface Router
}