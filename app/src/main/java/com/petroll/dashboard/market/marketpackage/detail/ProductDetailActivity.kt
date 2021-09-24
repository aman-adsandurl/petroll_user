package com.petroll.dashboard.market.marketpackage.detail

import android.os.Bundle
import android.util.DisplayMetrics
import com.petroll.databinding.ActivityProductDetailBinding
import com.petroll.databinding.ActivityProductListingBinding
import com.petroll.utils.BaseActivity
import android.app.Activity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout


class ProductDetailActivity: BaseActivity() {

    var screenHeight: Int = 0
    var screenWidth: Int = 0

    lateinit var binding: ActivityProductDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideContent()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)

        updateDimen()
        val params = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        params.height = (screenHeight * 0.35).toInt()
        binding.rlViewpager.layoutParams = params
    }

    private fun updateDimen() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels
        screenWidth = displayMetrics.widthPixels
    }
}