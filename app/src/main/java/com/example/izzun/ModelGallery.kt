package com.example.izzun

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 13 Mei 2020
 *
 * */

@Parcelize
data class ModelGallery(
    val nama: String,
    val image: Int
) : Parcelable