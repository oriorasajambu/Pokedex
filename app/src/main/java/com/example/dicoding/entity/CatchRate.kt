package com.example.dicoding.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatchRate(
    val rate: Int,
    val description: String
): Parcelable
