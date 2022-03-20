package com.example.dicoding.module.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding.constant.ChildAdapterType
import com.example.dicoding.databinding.ItemPokemonTypeBinding
import com.example.dicoding.constant.PokemonType

class ChildAdapter(
    private val adapterType: ChildAdapterType,
    private val itemClickListener: OnItemClickedListener? = null,
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
            ChildAdapterType.LIST_TYPE.ordinal -> PokemonTypeViewHolder(
                ItemPokemonTypeBinding.inflate(layoutInflater, parent, false),
                parent.context
            )
            else -> throw IllegalArgumentException("view type not found")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is PokemonTypeViewHolder -> holder.bind(data[position] as PokemonType)
        }
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        return when (adapterType) {
            ChildAdapterType.LIST_TYPE -> ChildAdapterType.LIST_TYPE.ordinal
        }
    }

    inner class PokemonTypeViewHolder(
        private val binding: ItemPokemonTypeBinding,
        private val context: Context
    ) : BaseViewHolder(binding) {
        fun bind(type: PokemonType) = with(binding) {
            root.setCardBackgroundColor(context.getColor(type.color))
            tvType.text = type.name
        }
    }
}