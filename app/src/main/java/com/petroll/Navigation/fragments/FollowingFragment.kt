package com.petroll.Navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.DashboardActivity
import com.petroll.dashboard.adapter.FollowingAdapter
import com.petroll.dashboard.adapter.WishlistAdapter
import com.petroll.databinding.FragmentAppointmentBinding
import com.petroll.databinding.FragmentFollowingBinding

class FollowingFragment: Fragment() {

    lateinit var binding: FragmentFollowingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingBinding.inflate(layoutInflater)
        setUpRecyclerView()
        setUpBackLayout()
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvFollowing.layoutManager = LinearLayoutManager(context)
        val adapter = FollowingAdapter()
        binding.rvFollowing.adapter = adapter
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.following)
        binding.back.backLayout.setOnClickListener {
            (activity as DashboardActivity).onHome()
        }
    }

}