package com.petroll.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewbinding.ViewBinding
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.petroll.R
import com.petroll.databinding.ActivityBaseBinding

//open class BaseActivity<B: ViewBinding>(val bindingFactory: (LayoutInflater) -> B): AppCompatActivity() {
open class BaseActivity: AppCompatActivity() {

//    lateinit var bindingBase: B
    lateinit var baseBind: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseBind = ActivityBaseBinding.inflate(layoutInflater)
        super.setContentView(baseBind.root)
//        bindingBase = bindingFactory(layoutInflater)
    }

    override fun setContentView(view: View?) {
        baseBind.content.removeAllViews()
        baseBind.content.addView(view)
        setAdapter()
    }

    lateinit var actionBarDrawerToggle : ActionBarDrawerToggle
    private fun setAdapter() {
        setSupportActionBar(baseBind.toolbar.toolbar)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, baseBind.drawer, R.string.open, R.string.close)

        baseBind.drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        val actionBar = supportActionBar
        actionBar!!.setHomeAsUpIndicator(R.drawable.left_navigation)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
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