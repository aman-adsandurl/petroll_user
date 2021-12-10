package com.petroll.ui.dashboard.market.marketpackage.detail

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.content.res.AppCompatResources
import com.petroll.R
import com.petroll.databinding.ActivityProductDetailBinding
import com.petroll.ui.cart.CartActivity
import com.petroll.utils.BaseActivity
import com.petroll.utils.ViewPagerAdapter


class ProductDetailActivity : BaseActivity() {

    var screenHeight: Int = 0
    var screenWidth: Int = 0
    private lateinit var adapter: ViewPagerAdapter

    lateinit var binding: ActivityProductDetailBinding

    var itemsQuantity: Int = 1

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

        binding.tvQuant.text = itemsQuantity.toString()

        binding.tvMinus.setOnClickListener {
            if (itemsQuantity > 1) {
                itemsQuantity--
                binding.tvQuant.text = itemsQuantity.toString()
            }
        }

        binding.tvAdd.setOnClickListener {
            itemsQuantity++
            binding.tvQuant.text = itemsQuantity.toString()
        }

        baseBind.rlNext.setOnClickListener {
            if (baseBind.tvButton.text == getString(R.string.view_cart)) {
                startActivity(Intent(this, CartActivity::class.java))
            } else {
                setBottomBarText(getString(R.string.view_cart))
            }
        }

        setViewPager()

        setUpButton()
    }

    private fun setUpButton() {
        binding.back.tvBack.text = getString(R.string.product_detail)
        binding.back.backLayout.setOnClickListener {
            if (baseBind.tvButton.text == getString(R.string.view_cart)) {
                setBottomBarText(getString(R.string.add_cart))
            } else {
                finish()
                showBottomBar()
            }
        }

        binding.iconLayout.iclCheck.setImageResource(
            R.drawable.ic_share,
            AppCompatResources.getColorStateList(this, android.R.color.transparent)
        )
        //share

        binding.iconLayout.iclFav.setImageResource(
            R.drawable.ic_wishlist,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //my wishlist

        binding.iconLayout.iclWish.setImageResource(
            R.drawable.ic_cart,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //my cart
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