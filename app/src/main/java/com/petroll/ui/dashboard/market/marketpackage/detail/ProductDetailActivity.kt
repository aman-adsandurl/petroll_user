package com.petroll.ui.dashboard.market.marketpackage.detail

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.petroll.R
import com.petroll.databinding.ActivityProductDetailBinding
import com.petroll.ui.cart.CartActivity
import com.petroll.utils.BaseActivity
import com.petroll.utils.ViewPagerAdapter


class ProductDetailActivity: BaseActivity() {

    var screenHeight: Int = 0
    var screenWidth: Int = 0
    private lateinit var adapter: ViewPagerAdapter

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
        val vpParam = RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        params.height = (screenHeight * 0.35).toInt()
        vpParam.height = (screenHeight * 0.30).toInt()
        binding.rlViewpager.layoutParams = params
        binding.rlVpView.layoutParams = vpParam

        hideBottomBar(getString(R.string.add_cart))
        nextClickListener(Intent(this, CartActivity::class.java))
        setViewPager()

        setUpButton()
    }

    private fun setUpButton() {
        binding.back.tvBack.text = getString(R.string.product_detail)
        binding.back.backLayout.setOnClickListener {
            finish()
            showBottomBar()
        }
    }

    private fun updateDimen() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels
        screenWidth = displayMetrics.widthPixels
    }

    private fun setViewPager() {
        adapter = ViewPagerAdapter(
            listOf(
                R.drawable.ic_product,
                R.drawable.ic_product_detail,
                R.drawable.ic_product_detail,
                R.drawable.ic_product_detail,
                R.drawable.ic_product_detail
            ), this
        )

        binding.vp.adapter = adapter

        binding.dotsIndicator.setViewPager(binding.vp)
    }
}