package com.petroll.dashboard

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.viewpager.widget.ViewPager
import com.petroll.R
import com.petroll.databinding.ActivityDashboardUserBinding
import com.petroll.utils.ViewPagerAdapter

class DashboardActivity : AppCompatActivity() {

    lateinit var binding : ActivityDashboardUserBinding
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLayout()
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

        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.setHomeAsUpIndicator(R.drawable.left_drawer)
        actionBar.setDisplayHomeAsUpEnabled(true)

        setAdapter()
        setViewPager()
    }


    private fun setAdapter() {

        this.adapter = ViewPagerAdapter(listOf(
            R.drawable.shop_ic,
            R.drawable.charity_ic,
            R.drawable.shop_ic,
            R.drawable.charity_ic,
            R.drawable.shop_ic
        ), this)
    }


    private fun setViewPager() {
        binding.vpTop.adapter = adapter

        /**
         * Start automatic scrolling with an
         * interval of 3 seconds.
         */
        binding.vpTop.autoScroll(3000)
    }

    fun ViewPager.autoScroll(interval: Long) {

        val handler = Handler()
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

