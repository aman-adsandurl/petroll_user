package com.petroll.dashboard.community.services

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.adapter.AdoptionAdapter
import com.petroll.dashboard.adapter.FindHelpAdapter
import com.petroll.dashboard.adapter.MatingAdapter
import com.petroll.dashboard.adapter.PostAdapter
import com.petroll.databinding.*
import com.petroll.utils.BaseActivity

class NewsEventActivity: BaseActivity() {

    lateinit var binding: ActivityNewsEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.news_event)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}