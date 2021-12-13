package com.petroll.ui.cart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.petroll.R
import com.petroll.databinding.ActivityCartBinding
import com.petroll.databinding.ConfirmOrderBottomsheetBinding
import com.petroll.ui.cart.fragments.AddressFragment
import com.petroll.ui.cart.fragments.CartFragment
import com.petroll.ui.cart.fragments.PaymentFragment
import com.petroll.utils.BaseActivity


class CartActivity : BaseActivity() {

    lateinit var dialog: BottomSheetDialog
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
        binding.back.tvBack.text = getString(R.string.cart_details)
        setNextClick()
        setUpViewPager()

        confirmOrderBottomSheet(layoutInflater)
    }

    fun setNextClick() {
        baseBind.rlNext.setOnClickListener {
            when (binding.vpFragments.currentItem) {
                0 -> {
                    dialog.show()
                }
                1 -> {
                    binding.vpFragments.currentItem = 2
                    binding.back.tvBack.text = getString(R.string.payment)
                    setBottomBarText(getString(R.string.place_order))
                    binding.topProgress.ivPayment.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.indicator_highlight
                        )
                    )
                    binding.topProgress.tvPayment.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.indicator_highlight
                        )
                    )
                }
                else -> {
                    val intent = Intent(this, OrderPlacedActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun backButtonHandling() {
        binding.iclFav.setImageResource(
            R.drawable.ic_wishlist,
            AppCompatResources.getColorStateList(this, R.color.skip_circle_color)
        )
        //my wishlist

        binding.back.backLayout.setOnClickListener {
            when (binding.vpFragments.currentItem) {
                0 -> {
                    finish()
                }
                1 -> {
                    binding.vpFragments.currentItem = 0
                    binding.back.tvBack.text = getString(R.string.cart_details)
                    setBottomBarText(getString(R.string.confirm_order))
//                    backButtonHandling()
                    setNextClick()
                    binding.topProgress.ivAddress.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.line_color
                        )
                    )
                    binding.topProgress.tvAddress.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.top_text_color
                        )
                    )
                }
                else -> {
                    binding.vpFragments.currentItem = 1
                    binding.back.tvBack.text = getString(R.string.address)
                    setBottomBarText(getString(R.string.checkout))
                    binding.topProgress.ivPayment.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.line_color
                        )
                    )
                    binding.topProgress.tvPayment.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.top_text_color
                        )
                    )

                }
            }
        }
    }

    private fun setUpViewPager() {
        val adapter = MyPageAdapter(supportFragmentManager)
        binding.vpFragments.adapter = adapter

        binding.vpFragments.setOnTouchListener { _, _ ->
            binding.vpFragments.parent.requestDisallowInterceptTouchEvent(true)
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

    private fun confirmOrderBottomSheet(inflater: LayoutInflater) {
        dialog = BottomSheetDialog(this)
        val confirmOrderBinding: ConfirmOrderBottomsheetBinding =
            ConfirmOrderBottomsheetBinding.inflate(inflater)
        dialog.setContentView(confirmOrderBinding.root)

        confirmOrderBinding.payAtVisit.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this, OrderPlacedActivity::class.java)
            startActivity(intent)
            finish()
        }

        confirmOrderBinding.other.setOnClickListener {
            dialog.dismiss()

            binding.vpFragments.currentItem = 1
            setBottomBarText(getString(R.string.checkout))
            binding.back.tvBack.text = getString(R.string.address)
            binding.topProgress.ivAddress.setColorFilter(
                ContextCompat.getColor(
                    this,
                    R.color.indicator_highlight
                )
            )
            binding.topProgress.tvAddress.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.indicator_highlight
                )
            )
        }
    }
}