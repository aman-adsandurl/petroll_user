package com.petroll.Navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.utils.BaseActivity
import com.petroll.dashboard.adapter.AppointmentAdapter
import com.petroll.dashboard.adapter.AuctionAdapter
import com.petroll.databinding.FragmentAuctionBinding

class AuctionFragment(val isAuction: Boolean) : Fragment() {

    lateinit var binding: FragmentAuctionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuctionBinding.inflate(layoutInflater)
        setUpData("ongoing")
        setUpRecyclerView()
        setUpBackLayout()
        setUpClickListener()
        return binding.root
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

    private fun setUpClickListener() {
        binding.rlPast.setOnClickListener {
            binding.rlPast.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.tab_selected_bg
            )
            binding.rlOngoing.setBackgroundResource(0)
            setUpData("past")
            setUpRecyclerView()
        }

        binding.rlOngoing.setOnClickListener {
            binding.rlOngoing.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.tab_selected_bg
            )
            binding.rlPast.setBackgroundResource(0)
            setUpData("ongoing")
            setUpRecyclerView()
        }
    }

    private fun setUpBackLayout() {
        if (isAuction) {
            binding.back.tvBack.text = resources.getText(R.string.auction)
        } else {
            // todo for appointments increase the circle size
            binding.back.tvBack.text = resources.getText(R.string.appointment)
        }
        binding.back.backLayout.setOnClickListener {
            (activity as BaseActivity).onHome()
        }
    }

    private fun setUpRecyclerView() {
        binding.rvAuction.layoutManager = LinearLayoutManager(context)
        if (!isAuction) {
            val adapter = AppointmentAdapter(data, requireActivity())
            binding.rvAuction.adapter = adapter
        } else {
            val adapter = AuctionAdapter(data, requireContext())
            binding.rvAuction.adapter = adapter
        }

    }
}