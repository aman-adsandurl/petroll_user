package com.petroll.tutorialscreens.fragments

import android.app.Activity
import android.graphics.Insets
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.petroll.R
import com.petroll.databinding.FragmentScreenTutorialBinding


class TutorialScreenFragment(val item:Int) : Fragment() {

    var currentItem : Int = item
    lateinit var binding : FragmentScreenTutorialBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreenTutorialBinding.inflate(inflater,container,false)
        setUpImageText()
        return binding.root
    }

    fun getScreenHeight(activity: Activity): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics = activity.windowManager.currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMetrics.bounds.height() - insets.bottom - insets.top
        } else {
            val displayMetrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
    }

    private fun setUpImageText() {
        Log.e("anim", "value is ----- >  $currentItem");
//        binding.ivTutorial.setBackgroundResource(0)
        when (currentItem) {
            0 -> {
                binding.ivTutorial.setBackgroundResource(R.drawable.tutorial_first)
                binding.tvTutorialHeading.setText(R.string.headingfirst)
                binding.tvTutorialMessage.setText(R.string.messagefirst)
            }
            1 -> {
                binding.ivTutorial.setBackgroundResource(R.drawable.tutorial_second)
                binding.tvTutorialHeading.setText(R.string.headingsecond)
                binding.tvTutorialMessage.setText(R.string.messagefirst)
            }
            2 -> {
                binding.ivTutorial.setBackgroundResource(R.drawable.tutorial_third)
                binding.tvTutorialHeading.setText(R.string.headingthird)
                binding.tvTutorialMessage.setText(R.string.messagefirst)
            }
        }
    }
}