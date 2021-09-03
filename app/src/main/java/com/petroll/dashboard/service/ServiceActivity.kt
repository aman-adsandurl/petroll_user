package com.petroll.dashboard.service

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.petroll.R
import com.petroll.databinding.ActivityServiceBinding
import com.petroll.utils.BaseActivity

class ServiceActivity : BaseActivity() {

    lateinit var binding: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()

        setUpIconLayout()
        // todo to shift it to base activity
        setUpBottomNav(binding.bottmNav, false)
    }

    private fun setUpIconLayout() {
        binding.iconLayout.iclCheck.setImageResource(R.drawable.ic_calendar, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclFav.setImageResource(R.drawable.ic_fav_top, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclWish.visibility = View.GONE


        binding.vetLayout.setSmallCircle()
        binding.trainerLayout.setSmallCircle()
        binding.peerLayout.setSmallCircle()
        binding.spaLayout.setSmallCircle()
        binding.consultantLayout.setSmallCircle()

        binding.vetLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.light_blue1))
        binding.trainerLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.yellow2))
        binding.peerLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.yellow1))
        binding.spaLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.light_blue2))
        binding.consultantLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.pink1))



        binding.vetLayout.setImageText(resources.getString(R.string.vet), R.drawable.ic_shop)
        binding.trainerLayout.setImageText(resources.getString(R.string.trainer), R.drawable.ic_sell)
        binding.peerLayout.setImageText(resources.getString(R.string.peer), R.drawable.ic_auction_market)
        binding.spaLayout.setImageText(resources.getString(R.string.spa_and_body), R.drawable.ic_auction_market)
        binding.consultantLayout.setImageText(resources.getString(R.string.consultant), R.drawable.ic_auction_market)


        binding.vetLayout.setTextColorLayout(AppCompatResources.getColorStateList(this, R.color.black))
        binding.trainerLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.peerLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.spaLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.consultantLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))


        binding.vetLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14))
        binding.trainerLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )
        binding.peerLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.spaLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.consultantLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.service)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}