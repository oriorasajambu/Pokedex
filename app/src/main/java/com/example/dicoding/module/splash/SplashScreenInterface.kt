package com.example.dicoding.module.splash

import androidx.appcompat.app.AppCompatActivity

interface SplashScreenInterface {
    interface View

    interface Presenter {
        fun onCreate(activity: AppCompatActivity)
        fun onDestroy()
    }

    interface Interactor {
        fun startLoading(onSuccess: (Long) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun goToMainActivity()
    }
}