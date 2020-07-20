package com.SoftwareInversion.withallah.java.withallah

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class pageAdapter:PagerAdapter {

    lateinit var layouts:IntArray
    lateinit var inflater:LayoutInflater
    lateinit var con:Context
    constructor(layouts:IntArray,con:Context):super(){
        this.layouts=layouts
        this.con=con
        inflater=con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
return view==`object`
    }

    override fun getCount(): Int {
        return layouts.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
var veiw:View=inflater.inflate(layouts[position],container,false)
        container.addView(veiw)
        return veiw
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        var veiw:View=`object` as View
        container.removeView(veiw)

    }

}