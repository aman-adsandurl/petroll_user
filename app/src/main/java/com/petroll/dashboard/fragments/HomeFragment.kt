package com.petroll.dashboard.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.petroll.R
import com.petroll.dashboard.community.CommunityActivity
import com.petroll.dashboard.market.MarketActivity
import com.petroll.dashboard.service.ServiceActivity
import com.petroll.databinding.FragmentHomeBinding
import com.petroll.utils.ViewPagerAdapter

class HomeFragment : Fragment() {

    private lateinit var adapter: ViewPagerAdapter
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setLayout()
        return binding.root
    }

    private fun setLayout() {
        binding.communityLayout.setBackgroundColorTint(
            AppCompatResources.getColorStateList(
                requireContext(),
                R.color.dashboard_bg
            )
        )
        binding.marketLayout.setBackgroundColorTint(
            AppCompatResources.getColorStateList(
                requireContext(),
                R.color.dashboard_bg
            )
        )
        binding.serviceLayout.setBackgroundColorTint(
            AppCompatResources.getColorStateList(
                requireContext(),
                R.color.dashboard_bg
            )
        )

        binding.serviceLayout.setImageText(
            resources.getString(R.string.service),
            R.drawable.premium_ic
        )
        binding.marketLayout.setImageText(resources.getString(R.string.market), R.drawable.shop_ic)
        binding.communityLayout.setImageText(
            resources.getString(R.string.community),
            R.drawable.charity_ic
        )

        binding.communityLayout.setTextColorLayout(
            AppCompatResources.getColorStateList(
                requireContext(),
                R.color.white
            )
        )
        binding.serviceLayout.setTextColorLayout(
            AppCompatResources.getColorStateList(
                requireContext(),
                R.color.white
            )
        )
        binding.marketLayout.setTextColorLayout(
            AppCompatResources.getColorStateList(
                requireContext(),
                R.color.white
            )
        )

        binding.marketLayout.setOnClickListener {
            val intent = Intent(context, MarketActivity::class.java)
            startActivity(intent)
        }

        binding.serviceLayout.setOnClickListener {
            val intent = Intent(context, ServiceActivity::class.java)
            startActivity(intent)
        }

        binding.communityLayout.setOnClickListener {
            val intent = Intent(context, CommunityActivity::class.java)
            startActivity(intent)
        }

        setViewPager()
    }

    private fun setViewPager() {
        adapter = ViewPagerAdapter(
            listOf(
                R.drawable.shop_ic,
                R.drawable.charity_ic,
                R.drawable.shop_ic,
                R.drawable.charity_ic,
                R.drawable.shop_ic
            ), requireContext()
        )

        binding.vpTop.adapter = adapter
        /**
         * Start automatic scrolSignling with an
         * interval of 3 seconds.
         */
        binding.vpTop.autoScroll(3000)

        binding.dotsIndicator.setViewPager(binding.vpTop)
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

        addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
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