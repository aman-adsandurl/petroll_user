package com.petroll.ui.dashboard.market.marketpackage.buy_detail

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.petroll.R
import com.petroll.databinding.ActivityBuyDetailBinding
import com.petroll.utils.BaseActivity

class BuyDetailActivity: BaseActivity() {

    lateinit var binding: ActivityBuyDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpFragmentsBottomBar()
        setUpBottomClickedView(false)
        updateDimen()
        hideBottomBar(getString(R.string.start_chat))

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        params.height = (screenHeight * 0.35).toInt()
        binding.ivProduct.layoutParams = params
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.item_detail)
        binding.back.backLayout.setOnClickListener {
            finish()
        }

        binding.icShare.setOnClickListener {
            Toast.makeText(this, "Share Clicked", Toast.LENGTH_SHORT).show()
            //TODO: onShareClick
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