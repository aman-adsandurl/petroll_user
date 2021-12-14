package com.petroll.ui.dashboard.market.marketpackage

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import com.petroll.R
import com.petroll.databinding.ActivityShopBinding
import com.petroll.ui.dashboard.adapter.ShopAdapter
import com.petroll.utils.BaseActivity

class ShopActivity : BaseActivity() {

    lateinit var binding: ActivityShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpRecyclerView()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.shop)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }

    private fun setUpRecyclerView() {
        binding.iconLayout.iclCheck.setImageResource(
            R.drawable.ic_fav,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //bookmark

        binding.iconLayout.iclFav.setImageResource(
            R.drawable.ic_order,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //my orders

        binding.iconLayout.iclWish.setImageResource(
            R.drawable.ic_cart,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //my cart

        binding.iconLayout.icFilter.visibility = View.VISIBLE
        binding.iconLayout.icFilter.setImageResource(
            R.drawable.ic_filter,
            AppCompatResources.getColorStateList(this, android.R.color.transparent)
        )
        binding.iconLayout.icFilter.setOnClickListener {
            Toast.makeText(this, "Filter Clicked", Toast.LENGTH_SHORT).show()
            //TODO: onFilterClick
        }

        binding.rvShop.layoutManager = GridLayoutManager(this, 2)
        val adapter = ShopAdapter(this@ShopActivity)
        binding.rvShop.adapter = adapter

        onQuickAccessClick {
            Toast.makeText(this, "Quick Access", Toast.LENGTH_SHORT).show()
        }
    }
}