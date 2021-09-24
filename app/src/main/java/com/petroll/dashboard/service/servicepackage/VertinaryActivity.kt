package com.petroll.dashboard.service.servicepackage

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.adapter.AppointmentAdapter
import com.petroll.dashboard.adapter.BuyAdapter
import com.petroll.databinding.ActivityBuyBinding
import com.petroll.databinding.ActivityVertinaryBinding
import com.petroll.utils.BaseActivity

class VertinaryActivity: BaseActivity() {

    lateinit var binding: ActivityVertinaryBinding

    private lateinit var extras: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVertinaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        extras = intent.extras!!
        setUpBackLayout()
        hideContent()
        setUpData("ongoing")
        setUpClickListener()
        setUpRecyclerView()
        setUpFragmentsBottomBar()
        if (extras.getString("name")?.equals(resources.getText(R.string.spa_and_body)) == false) {
            hideBottomBar("Ask " +extras.getString("name"))
        } else {
            hideBottomBar("Find Spa")
        }

        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpClickListener() {
        binding.rlPast.setOnClickListener {
            binding.rlPast.background = ContextCompat.getDrawable(this,
                R.drawable.tab_selected_bg
            )
            binding.rlOngoing.setBackgroundResource(0)
            setUpData("past")
            setUpRecyclerView()
        }

        binding.rlOngoing.setOnClickListener {
            binding.rlOngoing.background = ContextCompat.getDrawable(
                this,
                R.drawable.tab_selected_bg
            )
            binding.rlPast.setBackgroundResource(0)
            setUpData("ongoing")
            setUpRecyclerView()
        }
    }


    lateinit var data: ArrayList<String>
    private fun setUpData(type: String) {
        data = ArrayList()

        if (data.isNotEmpty()) {
            data.clear()
        }

        for (i in 1..3) {
            data.add(type)
        }
    }

    private fun setUpRecyclerView() {
        binding.rvVertinary.layoutManager = LinearLayoutManager(this)
        val adapter = AppointmentAdapter(data)
        binding.rvVertinary.adapter = adapter
    }


    private fun setUpBackLayout() {
        binding.back.tvBack.text = extras.getString("name")
        binding.back.backLayout.setOnClickListener {
            finish()
            showBottomBar()
        }
    }
}