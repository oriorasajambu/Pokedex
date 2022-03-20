package com.example.dicoding.module.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dicoding.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity: AppCompatActivity(), SplashScreenInterface.View {

    private val presenter = SplashScreenPresenter(this)
    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.onCreate(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}