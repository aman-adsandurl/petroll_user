package com.petroll.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.petroll.R
import com.petroll.databinding.ActivityBaseBinding

abstract class BaseActivity: AppCompatActivity() {

    lateinit var bindingBase: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingBase = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(bindingBase.root)
//        setUpBottomNav()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
//        layoutInflater.inflate(layoutResID, bindingBase.content, true)
//        super.setContentView(bindingBase.mainContainer)
    }


    protected fun setUpBottomNav(bottom: MeowBottomNavigation, isDashboard: Boolean) {
        bottom.add(MeowBottomNavigation.Model(1, R.drawable.ic_botm_home))
        bottom.add(MeowBottomNavigation.Model(2, R.drawable.ic_suggestion))
        bottom.add(MeowBottomNavigation.Model(3, R.drawable.ic_inact_feeds))
        bottom.add(MeowBottomNavigation.Model(4, R.drawable.ic_inact_notification))
        bottom.add(MeowBottomNavigation.Model(5, R.drawable.ic_inact_profile))

        if (isDashboard) {
            bottom.show(1)
        }

        bottom.setOnClickListener {

        }
    }
}