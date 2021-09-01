package com.petroll.onboarding

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.petroll.R
import com.petroll.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var binding : ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListeners()
    }

    fun clickListeners(){
        binding.back.backLayout.setOnClickListener {
            finish()
        }

        binding.cvGetOtp.setOnClickListener{
//            if (isOtp()) {
                binding.llNumber.animate()
                    .alpha(0f)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.llNumber.visibility = View.GONE
                            binding.llOtp.visibility = View.VISIBLE
                            binding.heading.setText(R.string.otp_heading)
                            binding.message.setText(R.string.otp_msg)
                            binding.tvOtp.setText(R.string.continue_str)
                        }
                    })
//            } else {
//
//            }
        }
    }
    

}