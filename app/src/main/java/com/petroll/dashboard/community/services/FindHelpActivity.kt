package com.petroll.dashboard.community.services

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.adapter.AdoptionAdapter
import com.petroll.dashboard.adapter.FindHelpAdapter
import com.petroll.dashboard.adapter.MatingAdapter
import com.petroll.dashboard.adapter.PostAdapter
import com.petroll.databinding.ActivityAdoptionBinding
import com.petroll.databinding.ActivityFindHelpBinding
import com.petroll.databinding.ActivityMatingsBinding
import com.petroll.databinding.ActivityPostBinding
import com.petroll.utils.BaseActivity

class FindHelpActivity: BaseActivity() {

    lateinit var binding: ActivityFindHelpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpRecyclerView()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpRecyclerView() {
        binding.rvPost.layoutManager = LinearLayoutManager(this)
            val adapter = FindHelpAdapter(listOf("a", "b","a", "b","a", "b"))
            binding.rvPost.adapter = adapter
    }


    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.find_help)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}