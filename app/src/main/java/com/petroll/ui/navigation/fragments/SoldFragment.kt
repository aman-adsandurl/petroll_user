package com.petroll.ui.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.petroll.R
import com.petroll.databinding.FragmentFollowingBinding
import com.petroll.ui.dashboard.adapter.SoldAdapter
import com.petroll.utils.BaseActivity

class SoldFragment: Fragment() {

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
        binding.rvFollowing.layoutManager = GridLayoutManager(context, 2)
        val adapter = SoldAdapter()
        binding.rvFollowing.adapter = adapter
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.product)
        binding.back.backLayout.setOnClickListener {
            (activity as BaseActivity).onHome()
        }
    }

}