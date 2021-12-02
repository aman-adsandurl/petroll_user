package com.petroll.ui.onboarding

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.petroll.databinding.ActivityLoginBinding
import com.petroll.ui.dashboard.DashboardActivity

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        switchToSignUp()
    }

    private fun switchToSignUp() {
        val spannableText = SpannableString(binding.tvSignUp.text)
        spannableText.setSpan(
            android.text.style.StyleSpan(android.graphics.Typeface.BOLD),
            binding.tvSignUp.text.length - 7,
            binding.tvSignUp.text.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableText.setSpan(
            ForegroundColorSpan(Color.BLACK),
            binding.tvSignUp.text.length - 7,
            binding.tvSignUp.text.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvSignUp.text = spannableText

        binding.cvSignIn.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

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