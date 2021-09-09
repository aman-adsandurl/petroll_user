package com.petroll.Navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.DashboardActivity
import com.petroll.dashboard.adapter.SelectAdressAdapter
import com.petroll.dashboard.adapter.SoldAdapter
import com.petroll.databinding.FragmentFollowingBinding
import com.petroll.utils.BaseActivity

class AddAddressFragment: Fragment() {

    lateinit var binding: FragmentFollowingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingBinding.inflate(layoutInflater)
        setUpRecyclerView()
        setUpBackLayout()
        (activity as BaseActivity).hideBottomBar()
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvFollowing.layoutManager = LinearLayoutManager(context)
        val adapter = SelectAdressAdapter()
        binding.rvFollowing.adapter = adapter
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.select_address)
        binding.back.backLayout.setOnClickListener {
            (activity as DashboardActivity).onHome()
            (activity as BaseActivity).showBottomBar()
        }
    }
}