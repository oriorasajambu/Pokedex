package com.example.dicoding.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ability(
    val ability: String,
    val hidden: Boolean
): Parcelable