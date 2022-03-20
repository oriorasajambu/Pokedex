package com.example.dicoding.module.about

import androidx.appcompat.app.AppCompatActivity

interface AboutInterface {
    interface View {
        fun setToolbar()
    }

    interface Presenter {
        fun onCreate(activity: AppCompatActivity)
        fun onDestroy()
    }

    interface Interactor

    interface Router
}