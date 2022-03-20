package com.example.dicoding.module.splash

import android.content.Intent
import com.example.dicoding.module.home.MainActivity

class SplashScreenRouter(private val activity: SplashScreenActivity) :
    SplashScreenInterface.Router {
    override fun goToMainActivity() {
        Intent(activity, MainActivity::class.java).also {
            activity.startActivity(it)
            activity.finish()
        }
    }
}