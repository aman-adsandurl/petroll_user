package com.petroll.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.petroll.R
import com.petroll.databinding.ActivityDashboardUserBinding
import kotlinx.coroutines.withContext

class ViewPagerAdapter(private val images: List<Int>, private val context: Context) : PagerAdapter() {



    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(container.context).inflate(
            R.layout.item_images_list, container, false)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        imageView.setImageDrawable(AppCompatResources.getDrawable(context, images[position]))

        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount() = images.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}