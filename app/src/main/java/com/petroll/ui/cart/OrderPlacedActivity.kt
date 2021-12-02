package com.petroll.ui.cart

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import com.petroll.R
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

        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
        backSetUp()
        hideBottomBar(getString(R.string.continue_shopping))

        baseBind.rlNext.setOnClickListener {
            finish()
        }
    }

    fun backSetUp() {
        binding.back.tvBack.text = getText(R.string.order_status)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}