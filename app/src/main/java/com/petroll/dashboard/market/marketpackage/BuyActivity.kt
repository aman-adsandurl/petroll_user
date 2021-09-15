package com.petroll.dashboard.market.marketpackage

import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import com.petroll.R
import com.petroll.dashboard.adapter.ShopAdapter
import com.petroll.databinding.ActivityBuyBinding
import com.petroll.databinding.ActivityShopBinding
import com.petroll.utils.BaseActivity
import com.allyants.chipview.SimpleChipAdapter
import com.petroll.dashboard.adapter.BuyAdapter


class BuyActivity: BaseActivity() {

    lateinit var binding: ActivityBuyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpRecyclerView()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.buy)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }

    private fun setUpRecyclerView() {
        binding.iconLayout.iclCheck.setImageResource(
            R.drawable.ic_calendar, AppCompatResources.getColorStateList(this,
                R.color.skip_circle_color))
        binding.iconLayout.iclFav.setImageResource(
            R.drawable.ic_fav_top, AppCompatResources.getColorStateList(this,
                R.color.skip_circle_color))
        binding.iconLayout.iclWish.setImageResource(
            R.drawable.ic_wishlist, AppCompatResources.getColorStateList(this,
                R.color.skip_circle_color))

        binding.rvShop.layoutManager = GridLayoutManager(this, 2)
        val adapter = BuyAdapter()
        binding.rvShop.adapter = adapter
    }
}