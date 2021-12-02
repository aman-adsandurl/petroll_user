package com.petroll.ui.dashboard.community.services

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.databinding.ActivityPostBinding
import com.petroll.ui.dashboard.adapter.PostAdapter
import com.petroll.utils.BaseActivity

class PostActivity: BaseActivity() {

    lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
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
            val adapter = PostAdapter(listOf("a", "b","a", "b","a", "b"))
            binding.rvPost.adapter = adapter
    }


    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.post)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}