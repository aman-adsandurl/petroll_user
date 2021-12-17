package com.petroll.ui.dashboard.market.marketpackage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.petroll.R
import com.petroll.databinding.ActivityAuctionBinding
import com.petroll.ui.dashboard.adapter.AuctionAdapter
import com.petroll.utils.BaseActivity

class AuctionActivity : BaseActivity() {

    lateinit var binding: ActivityAuctionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuctionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpData("ongoing")
        setUpRecyclerView()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.auction)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }

    lateinit var data: ArrayList<String>
    private fun setUpData(type: String) {
        data = ArrayList()

        if (data.isNotEmpty()) {
            data.clear()
        }

        for (i in 1..5) {
            data.add(type)
        }
    }

    private fun setUpRecyclerView() {
        val adapter = AuctionAdapter(data, this)
        binding.rvAuction.adapter = adapter

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
            Toast.makeText(this, "search Clicked", Toast.LENGTH_SHORT).show()
            //TODO: onSearchClick
        }

        onQuickAccessClick {
            Toast.makeText(this, "Quick Access", Toast.LENGTH_SHORT).show()
            //TODO: onQuickAccessClick
        }

        onAddClick {
            Toast.makeText(this, "Add click", Toast.LENGTH_SHORT).show()
            //TODO onAddClick
        }
    }
}