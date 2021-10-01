package com.petroll.dashboard.market.marketpackage.buy_detail

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import com.petroll.R
import com.petroll.databinding.ActivityDetailAuctionBinding
import com.petroll.utils.BaseActivity

class AuctionDetailActivity : BaseActivity() {

    lateinit var binding: ActivityDetailAuctionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAuctionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpFragmentsBottomBar()
        setUpBottomClickedView(false)
        hideBottomBar(getString(R.string.place_your_bid))

        updateDimen()
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        params.height = (screenHeight * 0.35).toInt()
        binding.ivProduct.layoutParams = params
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.auction)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }

    var screenHeight: Int = 0
    var screenWidth: Int = 0
    private fun updateDimen() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels
        screenWidth = displayMetrics.widthPixels
    }
}