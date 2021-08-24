package com.petroll.onboarding

import android.content.Intent
import android.os.Bundle
import com.petroll.baseclasses.BaseActivity
import com.petroll.databinding.ActivityLandingPageBinding

class LandingPageActivity : BaseActivity() {

    private lateinit var binding: ActivityLandingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onTappingNext()
    }

    fun onTappingNext() {
        binding.cvNext.setOnClickListener {
            val intent = Intent(this, RegisterationActivity::class.java)
            startActivity(intent)
        }
    }
}