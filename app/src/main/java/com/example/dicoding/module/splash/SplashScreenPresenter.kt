package com.example.dicoding.module.splash

import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashScreenPresenter(
    private var view: SplashScreenInterface.View? = null,
) : SplashScreenInterface.Presenter {

    private var interactor: SplashScreenInterface.Interactor? = null
    private var router: SplashScreenInterface.Router? = null

    override fun onCreate(activity: AppCompatActivity) {
        view = activity as SplashScreenActivity
        interactor = SplashScreenInteractor()
        router = SplashScreenRouter(activity)
        initView()
    }

    override fun onDestroy() {
        view = null
        router = null
    }

    private fun initView() {
        interactor?.startLoading(
            {
                router?.goToMainActivity()
            }, {
                Log.e("SplashScreen", it.message.toString())
            }
        )
    }
}