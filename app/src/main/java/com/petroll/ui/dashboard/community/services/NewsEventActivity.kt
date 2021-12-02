package com.petroll.ui.dashboard.community.services

import android.os.Bundle
import com.petroll.R
import com.petroll.databinding.ActivityNewsEventBinding
import com.petroll.utils.BaseActivity

class NewsEventActivity: BaseActivity() {

    lateinit var binding: ActivityNewsEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.news_event_top)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}