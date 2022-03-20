package com.example.dicoding.module.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicoding.databinding.ActivityMainBinding
import com.example.dicoding.entity.Pokemon
import com.example.dicoding.module.adapter.ParentAdapter
import com.example.dicoding.constant.ParentAdapterType

class MainActivity : AppCompatActivity(), MainInterface.View {

    private val presenter = MainPresenter(this)
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val pokedexAdapter: ParentAdapter by lazy {
        ParentAdapter(ParentAdapterType.LIST_POKEMON, presenter)
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

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }

    override fun setToolbar() = with(binding.toolbar) {
        setOnClickedLeftButton { onBackPressed() }
        setOnClickedRightButton { presenter.onClickedAbout() }
    }

    override fun setRecyclerView() = with(binding) {
        rvPokedex.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = pokedexAdapter
        }
    }

    override fun setDataPokedex(list: List<Pokemon>) {
        pokedexAdapter.setData(list)
    }
}