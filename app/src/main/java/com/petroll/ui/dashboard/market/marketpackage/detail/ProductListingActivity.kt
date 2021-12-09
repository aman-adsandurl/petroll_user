package com.petroll.ui.dashboard.market.marketpackage.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import com.petroll.R
import com.petroll.databinding.ActivityProductListingBinding
import com.petroll.ui.dashboard.adapter.ProductAdapter
import com.petroll.utils.BaseActivity

class ProductListingActivity : BaseActivity() {

    lateinit var binding: ActivityProductListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideContent()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
        setUpBackLayout()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.rvProducts.layoutManager = GridLayoutManager(this, 2)
        val adapter = ProductAdapter(this@ProductListingActivity)
        binding.rvProducts.adapter = adapter
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.product)
        binding.back.backLayout.setOnClickListener {
            finish()
        }

        binding.iconLayout.iclCheck.setImageResource(
            R.drawable.ic_fav,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //bookmark

        binding.iconLayout.iclFav.setImageResource(
            R.drawable.ic_wishlist,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //my wishlist

        binding.iconLayout.iclWish.setImageResource(
            R.drawable.ic_order,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //my cart

        binding.iconLayout.icForthIcon.visibility = View.VISIBLE
        binding.iconLayout.icForthIcon.setImageResource(
            R.drawable.ic_cart,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //my cart icon
    }
}