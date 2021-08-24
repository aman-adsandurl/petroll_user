package com.petroll.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.petroll.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {


    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        switchToSignUp()
    }

    fun switchToSignUp() {
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, RegisterationActivity::class.java)
            startActivity(intent)
        }

        binding.rlForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}