package com.petroll.dashboard.market.marketpackage.detail

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.petroll.R
import com.petroll.dashboard.adapter.ProductAdapter
import com.petroll.databinding.ActivityProductListingBinding
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
        binding.back.tvBack.text = resources.getText(R.string.hello_pet)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}