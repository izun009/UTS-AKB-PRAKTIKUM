package com.example.izzun

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment



/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 14 Mei 2020
 *
 * */

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    lateinit var mDialog : Dialog
    lateinit var Ig : ImageView
    lateinit var Github : ImageView
    lateinit var Hp : ImageView
    lateinit var Maps : ImageView
    lateinit var About : ImageView
    lateinit var btnClose: ImageView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_profile, container, false)
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Ig = view.findViewById(R.id.ig_pic)
        Hp = view.findViewById(R.id.phone_pic)
        Github = view.findViewById(R.id.github_pic)
        Maps = view.findViewById(R.id.maps_pic)
        About = view.findViewById(R.id.about_pic)


        Ig.setOnClickListener(View.OnClickListener {
            val uri = Uri.parse("http://instagram.com/_u/1zzun")
            val likeIng = Intent(Intent.ACTION_VIEW, uri)

            likeIng.setPackage("com.instagram.android")

            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/1zzun")
                    )
                )
            }
        })

        Hp.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:082178420871")
            startActivity(intent)
        })

        Github.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.github.com/izun009")
            startActivity(intent)
        }

//        Maps.setOnClickListener {
//
//            val gmmIntentUri = Uri.parse("https://goo.gl/maps/V399dKGD6xoVWuZ98")
//            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
//            mapIntent.setPackage("com.google.android.apps.maps")
//            startActivity(mapIntent)
//
//        }
        

        Maps.setOnClickListener(View.OnClickListener {
            val uri = Uri.parse("https://goo.gl/maps/V399dKGD6xoVWuZ98")
            val likeIng = Intent(Intent.ACTION_VIEW, uri)

            likeIng.setPackage("com.google.android.apps.maps")

            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                    Uri.parse(
                        ""+uri
                    ))
                )
            }
        })


        About.setOnClickListener(View.OnClickListener {

            mDialog.setContentView(R.layout.dialog_about)
            btnClose = mDialog.findViewById(R.id.exit_icon)
            btnClose.setOnClickListener(View.OnClickListener { mDialog.dismiss() })
            mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.show()
        })



    }



}
