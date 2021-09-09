package com.petroll.Navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.DashboardActivity
import com.petroll.dashboard.adapter.WishlistAdapter
import com.petroll.databinding.FragmentAppointmentBinding

class WishlistFragment: Fragment() {

    lateinit var binding: FragmentAppointmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppointmentBinding.inflate(layoutInflater)
        setUpRecyclerView()
        setUpBackLayout()
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvWishlisht.layoutManager = LinearLayoutManager(context)
        val adapter = WishlistAdapter()
        binding.rvWishlisht.adapter = adapter
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.wishlist_back)
        binding.back.backLayout.setOnClickListener {
            (activity as DashboardActivity).onHome()
        }
    }
}