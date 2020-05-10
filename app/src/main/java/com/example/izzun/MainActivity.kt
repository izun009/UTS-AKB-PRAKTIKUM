package com.example.izzun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when(item.itemId){
            R.id.home -> {
                println("Home Pressed")
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.daily -> {
                println("Daily Pressed")
                replaceFragment(DailyFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.gallery -> {
                println("Gallery Pressed")
                replaceFragment(GalleryFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.music -> {
                println("Music Pressed")
                replaceFragment(MusicFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                println("Profile Pressed")
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

}
