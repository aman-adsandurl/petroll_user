package com.petroll.ui.dashboard.market.marketpackage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import com.petroll.R
import com.petroll.databinding.ActivityBuyBinding
import com.petroll.ui.dashboard.adapter.BuyAdapter
import com.petroll.utils.BaseActivity


class BuyActivity : BaseActivity() {

    lateinit var binding: ActivityBuyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpRecyclerView()
        setUpFragmentsBottomBar()
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
        binding.icFilter.setImageResource(
            R.drawable.ic_filter,
            AppCompatResources.getColorStateList(this, android.R.color.transparent)
        )
        binding.icFilter.setOnClickListener {
            Toast.makeText(this, "Filter Clicked", Toast.LENGTH_SHORT).show()
            //TODO: onFilterClick
        }

        binding.icSearch.setImageResource(
            R.drawable.ic_search,
            AppCompatResources.getColorStateList(this, android.R.color.transparent)
        )
        binding.icSearch.setOnClickListener {
            Toast.makeText(this, "Filter Clicked", Toast.LENGTH_SHORT).show()
            //TODO: onFilterClick
        }

        binding.rvShop.layoutManager = GridLayoutManager(this, 2)
        val adapter = BuyAdapter(this)
        binding.rvShop.adapter = adapter

        onQuickAccessClick {
            Toast.makeText(this, "Quick Access", Toast.LENGTH_SHORT).show()
        }

        onAddClick {
            Toast.makeText(this, "Add click", Toast.LENGTH_SHORT).show()
        }
    }
}