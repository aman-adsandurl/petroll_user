package com.petroll.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.petroll.databinding.ActivityRegisterationBinding

class RegisterationActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegisterationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        assigningListeners()
    }

    fun assigningListeners() {
        binding.tvSignin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}