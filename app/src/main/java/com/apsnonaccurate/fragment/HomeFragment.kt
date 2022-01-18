package com.apsnonaccurate.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.apsnonaccurate.R
import com.apsnonaccurate.model.produkModel
import com.inyongtisto.tutorial.adapter.AdapterSlider

class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home,container, false)

        vpSlider = view.findViewById(R.id.vp_slider)

        var arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider= AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider





        return view
    }

    val arrProduk: ArrayList<produkModel>get(){
        val arr =  ArrayList<produkModel>()

        val p1 = produkModel()
        p1.Model = "C8PF Kingston 16"
        p1.Harga = "Rp. 2.000.000"
        p1.Foto = R.drawable.C8PF_kingston_16

        val p2 = produkModel()
        p2.Model = "C8PF Kingston 32"
        p2.Harga = "Rp. 2.200.000"
        p2.Foto = R.drawable.C8PF_kingston_32

        val p3 = produkModel()
        p3.Model = "C8PF Kingston 64"
        p3.Harga = "Rp. 2.400.000"
        p3.Foto = R.drawable.C8PF_kingston_64

        val p4 = produkModel()
        p4.Model = "C8PF Kingston 128"
        p4.Harga = "Rp. 2.800.000"
        p4.Foto = R.drawable.C8PF_kingston_128

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)







        return arr
    }
}