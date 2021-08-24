package com.petroll.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.petroll.R
import com.petroll.databinding.ActivitySplashBinding
import com.petroll.databinding.ActivityTutorialBinding
import com.petroll.tutorialscreens.TutorialActivity

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.splashBg.postDelayed(Runnable {
            val intent = Intent(this, TutorialActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }, 3000)
    }
}