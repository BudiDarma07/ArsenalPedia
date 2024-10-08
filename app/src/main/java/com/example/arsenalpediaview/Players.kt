package com.example.arsenalpediaview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Players(
    val name: String,
    val description: String,
    val photo: Int,
    val position: String,
    val country: String,
    val teknik: String
) : Parcelable