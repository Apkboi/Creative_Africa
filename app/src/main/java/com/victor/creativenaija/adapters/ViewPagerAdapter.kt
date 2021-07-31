package com.victor.creativenaija.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.victor.creativenaija.R

class ViewPagerAdapter(var context: Context) : PagerAdapter() {
    var inflater: LayoutInflater? = null

    var images = intArrayOf(
        R.drawable.photographm,
        R.drawable.dancem,
        R.drawable.singerm
    )
    var headers = intArrayOf(
        R.string.header1,
        R.string.header2,
        R.string.header3
    )

    var descriptions = intArrayOf(
        R.string.Description1,
        R.string.Description2,
        R.string.Description3
    )



    override fun getCount(): Int {
        return headers.size
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as FrameLayout)

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as FrameLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater!!.inflate(R.layout.slider_layout, container, false)
        var imageView = view.findViewById<ImageView>(R.id.imgBg)
        var txtHeader = view.findViewById<TextView>(R.id.txtHeader)
        var txtDescription = view.findViewById<TextView>(R.id.txtDescription)
        imageView.setImageResource(images[position])
        txtDescription.setText(descriptions[position])
        txtHeader.setText(headers[position])
        container.addView(view)
        return view

//        return super.instantiateItem(container, position)
    }
}