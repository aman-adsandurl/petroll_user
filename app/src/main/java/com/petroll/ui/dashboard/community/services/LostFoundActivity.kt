package com.petroll.ui.dashboard.community.services

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.databinding.ActivityLostFoundBinding
import com.petroll.ui.dashboard.adapter.LostFoundAdapter
import com.petroll.utils.BaseActivity

class LostFoundActivity: BaseActivity() {

    lateinit var binding: ActivityLostFoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLostFoundBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpRecyclerView()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpRecyclerView() {
        binding.rvPost.layoutManager = LinearLayoutManager(this)
            val adapter = LostFoundAdapter(listOf("a", "b","a", "b","a", "b"), this)
            binding.rvPost.adapter = adapter
    }


    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.lost_found)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}