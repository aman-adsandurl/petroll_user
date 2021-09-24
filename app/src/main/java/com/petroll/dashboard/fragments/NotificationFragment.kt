package com.petroll.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.adapter.NotificationAdapter
import com.petroll.databinding.FragmentNotificationBinding
import com.petroll.utils.BaseActivity

class NotificationFragment : Fragment() {

    lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(layoutInflater)

        binding.rvNotification.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<String>()

        for (i in 1..5) {
            data.add("Your order #" + 198298 + i + 4 + " has been shipped")
        }
        val adapter = NotificationAdapter(data)
        binding.rvNotification.adapter = adapter

        setUpBackLayout()
        return binding.root
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.notification)
        binding.back.backLayout.setOnClickListener {
            (activity as BaseActivity).onHome()
        }
    }

}