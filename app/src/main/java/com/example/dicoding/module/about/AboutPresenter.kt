package com.example.dicoding.module.about

import androidx.appcompat.app.AppCompatActivity

class AboutPresenter(
    private var view: AboutInterface.View? = null,
) : AboutInterface.Presenter {

    private var interactor: AboutInterface.Interactor? = null
    private var router: AboutInterface.Router? = null

    override fun onCreate(activity: AppCompatActivity) {
        view = activity as AboutActivity
        interactor = AboutInteractor()
        router = AboutRouter()
        initView()
    }

    override fun onDestroy() {
        view = null
        router = null
    }

    private fun initView() {
        view?.setToolbar()
    }
}