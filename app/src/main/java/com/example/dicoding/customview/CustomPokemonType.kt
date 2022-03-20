package com.example.dicoding.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding.databinding.CustomPokemonTypeBinding
import com.example.dicoding.constant.PokemonType
import com.example.dicoding.module.adapter.ChildAdapter
import com.example.dicoding.constant.ChildAdapterType

class CustomPokemonType(
    context: Context,
    attributeSet: AttributeSet? = null
): ConstraintLayout(context, attributeSet) {

    private val binding: CustomPokemonTypeBinding = CustomPokemonTypeBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    private val pokemonTypeAdapter: ChildAdapter by lazy {
        ChildAdapter(ChildAdapterType.LIST_TYPE)
    }

    private fun setRecyclerView() {
        binding.root.apply {
            layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                override fun canScrollHorizontally(): Boolean {
                    return false
                }
            }
            adapter = pokemonTypeAdapter
        }
    }

    init {
        setRecyclerView()
    }

    fun setDataRecyclerView(list: List<PokemonType>) {
        pokemonTypeAdapter.setData(list)
    }
}