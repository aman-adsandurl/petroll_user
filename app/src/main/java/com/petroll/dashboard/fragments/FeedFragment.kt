package com.petroll.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.petroll.R
import com.petroll.utils.BaseActivity
import com.petroll.databinding.FragmentFeedBinding
import com.petroll.databinding.FragmentProfileDashboardBinding

class FeedFragment: Fragment() {

    lateinit var binding: FragmentFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(layoutInflater)
        setUpBackLayout()
        return binding.root
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.appointment)
        binding.back.backLayout.setOnClickListener {
            (activity as BaseActivity).onHome()
        }
    }

}