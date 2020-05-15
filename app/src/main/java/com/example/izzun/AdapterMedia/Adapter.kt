package com.example.izzun.AdapterMedia

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.izzun.MusicFragment
import com.example.izzun.VideoFragment

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 15 Mei 2020
 *
 * */

class Adapter (fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    // sebuah list yang menampung objek Fragment
    private val pages = listOf(
        MusicFragment(),
        VideoFragment()
    )

    // menentukan fragment yang akan dibuka pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    // judul untuk tabs
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> "Third Tab"
        }
    }
}