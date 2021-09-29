package com.petroll.cart

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import com.petroll.R
import com.petroll.databinding.ActivityCartBinding
import com.petroll.databinding.ActivityOrderPlacedBinding
import com.petroll.utils.BaseActivity

class OrderPlacedActivity: BaseActivity() {

    lateinit var binding: ActivityOrderPlacedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderPlacedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideContent()
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        params.height = (screenHeight * 0.35).toInt()
        params.width = (screenWidth * 0.35).toInt()
        binding.ivCenter.layoutParams = params
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
        backSetUp()
        hideBottomBar(getString(R.string.continue_shopping))
    }

    fun backSetUp() {
        binding.back.tvBack.text = getText(R.string.order_status)
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