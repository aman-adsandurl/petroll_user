package com.petroll.dashboard.market

import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.petroll.R
import com.petroll.databinding.ActivityMarketBinding
import com.petroll.utils.BaseActivity

class MarketActivity : BaseActivity() {

    lateinit var binding: ActivityMarketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()

        setUpIconLayout()
        // todo to shift it to base activity
        setUpBottomNav(binding.bottmNav, false)
    }

    private fun setUpIconLayout() {
        binding.iconLayout.iclCheck.setImageResource(R.drawable.ic_calendar, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclFav.setImageResource(R.drawable.ic_fav_top, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclWish.setImageResource(R.drawable.ic_wishlist, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.market)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}