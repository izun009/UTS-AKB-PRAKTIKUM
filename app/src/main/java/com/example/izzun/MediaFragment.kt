package com.example.izzun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager
import com.example.izzun.AdapterMedia.Adapter
import com.example.izzun.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_media_fragment.*

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 15 Mei 2020
 *
 * */

class MediaFragment : AppCompatActivity() {

    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_fragment)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val mToolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_media)
        mToolbar.title = ("Music & Video")
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)

        mToolbar.setNavigationOnClickListener {
            finish()
            overridePendingTransition(R.anim.stop_animation,R.anim.exit_up)
        }

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        val adapter = Adapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container) as ViewPager
        container.adapter = adapter

        val tabLayout = findViewById(R.id.tabLayout) as TabLayout

        mViewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mViewPager))

    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.stop_animation,R.anim.exit_up)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
