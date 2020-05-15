package com.example.izzun

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 12 Mei 2020
 *
 * */

class DailyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_daily, parent, false)) {
    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.list_title)
        mYearView = itemView.findViewById(R.id.list_description)
    }

    fun bind(dail: ModelDaily) {
        mTitleView?.text = dail.title
        mYearView?.text = dail.hour.toString()
    }

}