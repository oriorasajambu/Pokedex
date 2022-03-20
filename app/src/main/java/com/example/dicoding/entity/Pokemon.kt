package com.example.dicoding.entity

import android.os.Parcelable
import com.example.dicoding.constant.PokemonType
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: String,
    val image: Int,
    val name: String,
    val species: String,
    val type: List<PokemonType>,
    val height: String,
    val weight: String,
    val abilities: List<Ability>,
    val catchRate: CatchRate,
    val descriptions: String,
    val isAlreadyCatch: Boolean
): Parcelable
