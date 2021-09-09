package com.petroll.Navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.DashboardActivity
import com.petroll.dashboard.adapter.SelectAdressAdapter
import com.petroll.databinding.FragmentAuctionBinding
import com.petroll.databinding.FragmentFollowingBinding
import com.petroll.utils.BaseActivity

class AuctionActivity: Fragment() {

    lateinit var binding: FragmentAuctionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuctionBinding.inflate(layoutInflater)
        setUpRecyclerView()
        setUpBackLayout()
        setUpClickListener()
        return binding.root
    }

    private fun setUpClickListener() {

    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.select_address)
        binding.back.backLayout.setOnClickListener {
            (activity as DashboardActivity).onHome()
        }
    }

    private fun setUpRecyclerView() {
//        binding.rvFollowing.layoutManager = LinearLayoutManager(context)
//        val adapter = SelectAdressAdapter()
//        binding.rvFollowing.adapter = adapter
    }
}