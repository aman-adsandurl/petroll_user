package com.petroll.dashboard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuCompat
import androidx.viewpager.widget.ViewPager
import com.petroll.R
import com.petroll.dashboard.market.MarketActivity
import com.petroll.databinding.ActivityDashboardUserBinding
import com.petroll.utils.BaseActivity
import com.petroll.utils.ViewPagerAdapter


class DashboardActivity : BaseActivity() {

    lateinit var binding : ActivityDashboardUserBinding
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLayout()
        setUpBottomNav(binding.bottmNav, true)
    }

    private fun setLayout() {
        binding.communityLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.dashboard_bg))
        binding.marketLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.dashboard_bg))
        binding.serviceLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.dashboard_bg))

        binding.serviceLayout.setImageText(resources.getString(R.string.service), R.drawable.premium_ic)
        binding.marketLayout.setImageText(resources.getString(R.string.market), R.drawable.shop_ic)
        binding.communityLayout.setImageText(resources.getString(R.string.community), R.drawable.charity_ic)

        binding.communityLayout.setTextColorLayout(AppCompatResources.getColorStateList(this, R.color.white))
        binding.serviceLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.white))
        binding.marketLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.white))

        binding.marketLayout.setOnClickListener {
            val intent = Intent(this, MarketActivity::class.java)
            startActivity(intent)
        }


        setAdapter()
        setViewPager()
    }


    // methods for auto scroll
    lateinit var actionBarDrawerToggle : ActionBarDrawerToggle
    private fun setAdapter() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close)

        binding.drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState();
        val actionBar = supportActionBar
        actionBar!!.setHomeAsUpIndicator(R.drawable.left_navigation)
        actionBar.setDisplayHomeAsUpEnabled(true)


        this.adapter = ViewPagerAdapter(listOf(
            R.drawable.shop_ic,
            R.drawable.charity_ic,
            R.drawable.shop_ic,
            R.drawable.charity_ic,
            R.drawable.shop_ic
        ), this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.navigation_menu, menu)
//        MenuCompat.setGroupDividerEnabled(menu, true)
//        return true;
//    }

    private fun setViewPager() {
        binding.vpTop.adapter = adapter
        /**
         * Start automatic scrolling with an
         * interval of 3 seconds.
         */
        binding.vpTop.autoScroll(3000)
    }
    fun ViewPager.autoScroll(interval: Long) {
        val handler =  Handler()
        var scrollPosition = 0
        val runnable = object : Runnable {
            override fun run() {

                /**
                 * Calculate "scroll position" with
                 * adapter pages count and current
                 * value of scrollPosition.
                 */
                val count = adapter?.count ?: 0
                setCurrentItem(scrollPosition++ % count, true)

                handler.postDelayed(this, interval)
            }
        }

        addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                // Updating "scroll position" when user scrolls manually
                scrollPosition = position + 1
            }

            override fun onPageScrollStateChanged(state: Int) {
                // Not necessary
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // Not necessary
            }
        })

        handler.post(runnable)
    }
}

