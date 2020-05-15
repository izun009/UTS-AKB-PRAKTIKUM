package com.example.izzun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 12 Mei 2020
 *
 * */

class AdapterDaily(private val list: List<ModelDaily>)
    : RecyclerView.Adapter<DailyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DailyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val dail: ModelDaily = list[position]
        holder.bind(dail)
    }

    override fun getItemCount(): Int = list.size

}