package com.petroll.dashboard.market.marketpackage

import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.Navigation.fragments.AuctionFragment
import com.petroll.R
import com.petroll.dashboard.adapter.AppointmentAdapter
import com.petroll.dashboard.adapter.AuctionAdapter
import com.petroll.dashboard.adapter.BuyAdapter
import com.petroll.databinding.ActivityAuctionBinding
import com.petroll.databinding.ActivityBuyBinding
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
        binding.rvAuction.layoutManager = LinearLayoutManager(this)
            val adapter = AuctionAdapter(data, this)
            binding.rvAuction.adapter = adapter
    }
}