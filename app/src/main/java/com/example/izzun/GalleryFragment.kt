package com.example.izzun

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_gallery.*

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 13 Mei 2020
 *
 * */

/**
 * A simple [Fragment] subclass.
 */
class GalleryFragment : Fragment() {

//    private var recyclerView: RecyclerView? = null
//    private var charItem: ArrayList<ModelGallery>? = null
//    private var gridLayoutManager: GridLayoutManager? = null
//    private var alphaAdapters: AdapterGallery? = null

    val REQUEST_CODE = 100

    private val item3 = listOf(
        ModelGallery("Apple",R.drawable.letter_a),
        ModelGallery("Bee",R.drawable.letter_b),
        ModelGallery("Cat",R.drawable.letter_c),
        ModelGallery("Drum",R.drawable.letter_d),
        ModelGallery("Enak",R.drawable.letter_e),
        ModelGallery("Fish",R.drawable.letter_f),
        ModelGallery("Gloves",R.drawable.letter_g),
        ModelGallery("House",R.drawable.letter_h),
        ModelGallery("Indihome",R.drawable.letter_i),
        ModelGallery("Juice",R.drawable.letter_j),
        ModelGallery("Key",R.drawable.letter_k),
        ModelGallery("Lock",R.drawable.letter_l),
        ModelGallery("Mug",R.drawable.letter_m),
        ModelGallery("Net",R.drawable.letter_n),
        ModelGallery("Orange",R.drawable.letter_o),
        ModelGallery("Paprica",R.drawable.letter_p),
        ModelGallery("Queen",R.drawable.letter_q),
        ModelGallery("Robot",R.drawable.letter_r),
        ModelGallery("Snake",R.drawable.letter_s),
        ModelGallery("Teapot",R.drawable.letter_t),
        ModelGallery("Umbrella",R.drawable.letter_u),
        ModelGallery("Vulcanic",R.drawable.letter_v),
        ModelGallery("Watch",R.drawable.letter_w),
        ModelGallery("Xenovon",R.drawable.letter_x),
        ModelGallery("Yoyo",R.drawable.letter_y),
        ModelGallery("Zipper",R.drawable.letter_z)

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_gallery, container, false)
    // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_gallery, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_picture.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            // set the custom adapter to the RecyclerView
            adapter = AdapterGallery(item3){

            }
            //openGalleryForImage()
        }

//        val images = listOf<Image>(
//            Image("Images 1", R.drawable.letter_a),
//            Image("Images 2", R.drawable.letter_b),
//            Image("Images 3", R.drawable.letter_c),
//            Image("Images 4", R.drawable.letter_d),
//            Image("Images 5", R.drawable.letter_e)
//        )
//
//        val recyclerView = findViewById<RecyclerView>(R.id.imagesRecyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = ImageAdapter(this, images)

    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.type = "image/*"
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            //picture.setImageURI(data?.data) // handle chosen image
        }
    }



    companion object {
        fun newInstance(): GalleryFragment =
            GalleryFragment()
    }


//    private fun setAlphas(): ArrayList<ModelGallery> {
//
//        var arrayList: ArrayList<ModelGallery> = ArrayList()
//
//        arrayList.add(ModelGallery(R.drawable.letter_a, "A Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_b, "B Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_c, "C Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_d, "D Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_e, "E Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_f, "F Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_g, "G Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_h, "H Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_i, "I Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_j, "J Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_k, "K Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_l, "L Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_m, "M Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_n, "N Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_o, "o Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_p, "P Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_q, "Q Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_r, "R Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_s, "S Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_t, "T Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_u, "U Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_v, "V Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_w, "W Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_x, "X Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_y, "Y Latter"))
//        arrayList.add(ModelGallery(R.drawable.letter_z, "Z Latter"))
//
//        return arrayList
//    }

}
