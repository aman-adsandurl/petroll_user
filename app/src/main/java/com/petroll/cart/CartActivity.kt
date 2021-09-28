package com.petroll.cart

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.petroll.R
import com.petroll.databinding.ActivityCartBinding
import com.petroll.utils.BaseActivity
import com.petroll.utils.ViewPagerAdapter
import androidx.fragment.app.FragmentPagerAdapter
import com.petroll.cart.fragments.AddressFragment
import com.petroll.cart.fragments.CartFragment
import com.petroll.cart.fragments.PaymentFragment
import android.view.MotionEvent

import android.view.View.OnTouchListener





class CartActivity : BaseActivity() {

    lateinit var binding: ActivityCartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideContent()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
        hideBottomBar(getString(R.string.confirm_order))
        backButtonHandling()
        setNextClick()
        setUpViewPager()
    }

    private fun setNextClick() {

        baseBind.rlNext.setOnClickListener {
            when (binding.vpFragments.currentItem) {
                0 -> {
                    binding.vpFragments.setCurrentItem(1)
                    setBottomBarText(getString(R.string.checkout))
                    binding.back.tvBack.text = getString(R.string.address)
                    binding.topProgress.ivAddress.setColorFilter(ContextCompat.getColor(this,R.color.indicator_highlight))
                    binding.topProgress.tvAddress.setTextColor(ContextCompat.getColor(this, R.color.indicator_highlight))
                }
                1 -> {
                    binding.vpFragments.setCurrentItem(2)
                    binding.back.tvBack.text = getString(R.string.payment)
                    setBottomBarText(getString(R.string.place_order))
                    binding.topProgress.ivPayment.setColorFilter(ContextCompat.getColor(this,R.color.indicator_highlight))
                    binding.topProgress.tvPayment.setTextColor(ContextCompat.getColor(this, R.color.indicator_highlight))
                }
                else -> {
                    // todo nothing
//                    binding.vpFragments.setCurrentItem(1)

                }
            }
        }
    }

    fun backButtonHandling() {
        binding.back.backLayout.setOnClickListener {
            when (binding.vpFragments.currentItem) {
                0 -> {
                    finish()
                }
                1 -> {
                    binding.vpFragments.setCurrentItem(0)
                    binding.back.tvBack.text = getString(R.string.your_cart)
                    setBottomBarText(getString(R.string.confirm_order))
                    binding.topProgress.ivAddress.setColorFilter(ContextCompat.getColor(this,R.color.line_color))
                    binding.topProgress.tvAddress.setTextColor(ContextCompat.getColor(this, R.color.top_text_color))
                }
                else -> {
                    binding.vpFragments.setCurrentItem(1)
                    binding.back.tvBack.text = getString(R.string.address)
                    setBottomBarText(getString(R.string.checkout))
                    binding.topProgress.ivPayment.setColorFilter(ContextCompat.getColor(this,R.color.line_color))
                    binding.topProgress.tvPayment.setTextColor(ContextCompat.getColor(this, R.color.top_text_color))

                }
            }
        }
    }

    fun setUpViewPager() {
        var adapter = MyPageAdapter(supportFragmentManager)
        binding.vpFragments.adapter = adapter

        binding.vpFragments.setOnTouchListener { _, _ ->
            binding.vpFragments.getParent().requestDisallowInterceptTouchEvent(true)
            true
        }
    }

    private class MyPageAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> CartFragment()
                1 -> AddressFragment()
                else -> PaymentFragment()
            }
        }
    }
}