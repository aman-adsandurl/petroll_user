package com.petroll.ui.dashboard.community.services

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.databinding.ActivityFindHelpBinding
import com.petroll.ui.dashboard.adapter.FindHelpAdapter
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
        setUpFragmentsBottomBar()
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

        onQuickAccessClick {
            Toast.makeText(this, "Quick Access", Toast.LENGTH_SHORT).show()
            //TODO:
        }
    }
}