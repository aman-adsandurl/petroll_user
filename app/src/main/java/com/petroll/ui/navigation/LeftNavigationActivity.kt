package com.petroll.ui.navigation

import android.os.Bundle
import com.petroll.databinding.ActivityLeftNavigationBinding
import com.petroll.utils.BaseActivity

class LeftNavigationActivity : BaseActivity() {

    lateinit var binding: ActivityLeftNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeftNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setFragment(HomeFragment())
//        setUpFragmentsBottomBar()
        setUpBottomClickedView(false)
    }

}