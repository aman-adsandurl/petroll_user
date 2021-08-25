package com.petroll.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.petroll.R
import com.petroll.databinding.ActivityDashboardBinding
import com.petroll.databinding.ActivityDashboardUserBinding
import com.petroll.onboarding.LandingPageActivity

class DashboardActivity : AppCompatActivity() {

    lateinit var binding : ActivityDashboardUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLayout()
    }

    private fun setLayout() {
        binding.communityLayout.setBackgroundColorTint(resources.getColorStateList(R.color.dashboard_bg))
        binding.marketLayout.setBackgroundColorTint(resources.getColorStateList(R.color.dashboard_bg))
        binding.serviceLayout.setBackgroundColorTint(resources.getColorStateList(R.color.dashboard_bg))

        binding.serviceLayout.setImageText(resources.getString(R.string.service), R.drawable.premium_ic)
        binding.marketLayout.setImageText(resources.getString(R.string.market), R.drawable.shop_ic)
        binding.communityLayout.setImageText(resources.getString(R.string.community), R.drawable.charity_ic)

        binding.communityLayout.setTextColorLayout(resources.getColorStateList(R.color.white))
        binding.serviceLayout.setTextColorLayout(resources.getColorStateList(R.color.white))
        binding.marketLayout.setTextColorLayout(resources.getColorStateList(R.color.white))
    }


}