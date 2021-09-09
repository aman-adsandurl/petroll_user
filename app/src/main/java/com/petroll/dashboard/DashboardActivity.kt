package com.petroll.dashboard

import android.os.Bundle
import com.petroll.databinding.ActivityDashboardUserBinding
import com.petroll.utils.BaseActivity


class DashboardActivity : BaseActivity() {

    lateinit var binding: ActivityDashboardUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showContent()
        setUpBottomClickedView(true)
    }


}

