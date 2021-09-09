package com.petroll.dashboard.community

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.petroll.R
import com.petroll.databinding.ActivityCommunityBinding
import com.petroll.databinding.ActivityServiceBinding
import com.petroll.utils.BaseActivity

class CommunityActivity: BaseActivity() {

    lateinit var binding: ActivityCommunityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpIconLayout()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpIconLayout() {
        binding.iconLayout.iclCheck.setImageResource(R.drawable.ic_calendar, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclFav.setImageResource(R.drawable.ic_fav_top, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclWish.setImageResource(R.drawable.ic_wishlist, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))


        binding.postLayout.setSmallCircle()
        binding.matingLayout.setSmallCircle()
        binding.lostLayout.setSmallCircle()
        binding.adoptionLayout.setSmallCircle()
        binding.postIncidentLayout.setSmallCircle()
        binding.helpLayout.setSmallCircle()
        binding.newsLayout.setSmallCircle()
        binding.guideLayout.setSmallCircle()

        binding.postLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.green1))
        binding.matingLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.pink2))
        binding.lostLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.yellow1))
        binding.adoptionLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.light_yellow))
        binding.postIncidentLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.light_blue2))
        binding.helpLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.lighter_yellow))
        binding.newsLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.blue3))
        binding.guideLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.yellow2))



        binding.postLayout.setImageText(resources.getString(R.string.post), R.drawable.ic_post)
        binding.matingLayout.setImageText(resources.getString(R.string.mating), R.drawable.ic_mating)
        binding.lostLayout.setImageText(resources.getString(R.string.lost_found), R.drawable.ic_lost)
        binding.adoptionLayout.setImageText(resources.getString(R.string.adoption), R.drawable.ic_adopt)
        binding.postIncidentLayout.setImageText(resources.getString(R.string.post_incident), R.drawable.ic_post_incident)
        binding.helpLayout.setImageText(resources.getString(R.string.find_help), R.drawable.ic_help)
        binding.newsLayout.setImageText(resources.getString(R.string.news_event), R.drawable.ic_news)
        binding.guideLayout.setImageText(resources.getString(R.string.guide), R.drawable.ic_guide)


        binding.postLayout.setTextColorLayout(AppCompatResources.getColorStateList(this, R.color.black))
        binding.matingLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.lostLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.adoptionLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.postIncidentLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.helpLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.newsLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.guideLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))


        binding.postLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14))
        binding.matingLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )
        binding.lostLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.adoptionLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.postIncidentLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.helpLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.newsLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.guideLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.community)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}