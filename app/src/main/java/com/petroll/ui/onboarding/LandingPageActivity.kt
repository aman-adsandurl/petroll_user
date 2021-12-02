package com.petroll.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.petroll.R
import com.petroll.databinding.ActivityLandingPageBinding

class LandingPageActivity : AppCompatActivity() {

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

        binding.back.backLayout.setOnClickListener {
            finish()
        }

        val listItems = arrayOf("Select Service Category")
        val adapter = ArrayAdapter(this, R.layout.custom_textview, listItems)
        adapter.setDropDownViewResource(R.layout.custom_textview)
        binding.spinnerServiceCategory.adapter = adapter
    }
}