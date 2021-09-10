package com.petroll.tutorialscreens

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.petroll.databinding.ActivityTutorialBinding
import com.petroll.onboarding.LoginActivity
import com.petroll.tutorialscreens.fragments.TutorialScreenFragment

class TutorialActivity : AppCompatActivity() {

    lateinit var binding: ActivityTutorialBinding
    private val NUM_PAGES = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewPager()
    }

    /** set up of view pager
     * method having all the listeners and click for next button
     *
     * */
    private fun setViewPager() {
        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        binding.slider.adapter = pagerAdapter

        binding.slider.setOnTouchListener { view, motionEvent -> true; }

        binding.slider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                if (position < NUM_PAGES - 1) {
                    binding.skipLayout.visibility = View.VISIBLE
                } else {
                    binding.skipLayout.visibility = View.INVISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        binding.rlNext.setOnClickListener {
            Log.e("anim", "------ > " + binding.slider.currentItem.toString());
            if (binding.slider.currentItem == (NUM_PAGES - 1)) {
                // todo intent to call sigin activity
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            } else {
                binding.slider.currentItem = binding.slider.currentItem + 1
            }
        }

        binding.rlSkip.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        binding.skipLayout.visibility = View.VISIBLE
        if (binding.slider.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            binding.slider.currentItem = binding.slider.currentItem - 1
        }
    }

    /**
     * screen slider pager adapter to render single fragment with image and text
     *
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = NUM_PAGES
        override fun getItem(position: Int): Fragment = TutorialScreenFragment(position)
    }
}