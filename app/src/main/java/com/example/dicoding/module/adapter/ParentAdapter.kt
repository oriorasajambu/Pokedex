package com.example.dicoding.module.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding.constant.ParentAdapterType
import com.example.dicoding.databinding.ItemPokemonBinding
import com.example.dicoding.entity.Pokemon

class ParentAdapter(
    private val adapterType: ParentAdapterType,
    val itemClickListener: OnItemClickedListener? = null,
) : RecyclerView.Adapter<BaseViewHolder>() {

    private val data: MutableList<Any> = mutableListOf()
    fun setData(list: List<Any>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ParentAdapterType.LIST_POKEMON.ordinal -> PokedexViewHolder(
                ItemPokemonBinding.inflate(layoutInflater, parent, false)
            )
            else -> throw IllegalArgumentException("view type not found")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is PokedexViewHolder -> holder.bind(data[position] as Pokemon)
        }
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        return when (adapterType) {
            ParentAdapterType.LIST_POKEMON -> ParentAdapterType.LIST_POKEMON.ordinal
        }
    }

    inner class PokedexViewHolder(
        private val binding: ItemPokemonBinding,
    ) : BaseViewHolder(binding) {
        fun bind(pokemon: Pokemon) = with(binding) {
            tvId.text = pokemon.id
            tvName.text = pokemon.name
            tvSpecies.text = pokemon.species
            cptType.setDataRecyclerView(pokemon.type)
            when (pokemon.isAlreadyCatch) {
                true -> ivPokeball.visibility = View.VISIBLE
                else -> ivPokeball.visibility = View.GONE
            }
            ivImage.setImageResource(pokemon.image)
            root.setOnClickListener {
                itemClickListener?.onClickedPokemon(pokemon)
            }
        }
    }
}