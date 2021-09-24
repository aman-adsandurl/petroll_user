package com.petroll.dashboard.market.marketpackage.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.petroll.R
import com.petroll.databinding.ActivityShopDetailBinding
import com.petroll.utils.BaseActivity

class ShopDetail: BaseActivity(), View.OnClickListener {

    lateinit var binding: ActivityShopDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
        setUpOnClick()
        setUpIconLayout()
    }

    private fun setUpIconLayout() {
        binding.iconLayout.iclCheck.setImageResource(R.drawable.ic_calendar, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclFav.setImageResource(R.drawable.ic_fav_top, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclWish.setImageResource(R.drawable.ic_wishlist, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))

        binding.foodLayout.setSmallCircle()
        binding.accesoryLayout.setSmallCircle()
        binding.healthLayout.setSmallCircle()

        binding.toysLayout.setSmallCircle()
        binding.petsLayout.setSmallCircle()

        binding.medicineLayout.setSmallCircle()
        binding.groomingLayout.setSmallCircle()
        binding.clothingLayout.setSmallCircle()

        binding.bedLayout.setSmallCircle()
        binding.homeLayout.setSmallCircle()

        //
        binding.foodLayout.setOnClickListener(this)
        binding.accesoryLayout.setOnClickListener(this)
        binding.healthLayout.setOnClickListener(this)

        binding.toysLayout.setOnClickListener(this)
        binding.petsLayout.setOnClickListener(this)

        binding.medicineLayout.setOnClickListener(this)
        binding.groomingLayout.setOnClickListener(this)
        binding.clothingLayout.setOnClickListener(this)

        binding.bedLayout.setOnClickListener(this)
        binding.homeLayout.setOnClickListener(this)
        //

        binding.foodLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.green1))
        binding.accesoryLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.owner_c))
        binding.healthLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.ligh_greyish))

        binding.toysLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.light_grey1))
        binding.petsLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.yellow4))

        binding.medicineLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.blue3))
        binding.groomingLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.light_yellow))
        binding.clothingLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.pink4))

        binding.bedLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.pink2))
        binding.homeLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.green5))

        binding.foodLayout.setImageText(resources.getString(R.string.food), R.drawable.ic_food)
        binding.accesoryLayout.setImageText(resources.getString(R.string.accesories), R.drawable.ic_accesory)
        binding.healthLayout.setImageText(resources.getString(R.string.health_supply), R.drawable.ic_health)

        binding.toysLayout.setImageText(resources.getString(R.string.toys), R.drawable.ic_toys)
        binding.petsLayout.setImageText(resources.getString(R.string.pets), R.drawable.ic_pets)

        binding.medicineLayout.setImageText(resources.getString(R.string.medicine), R.drawable.ic_med)
        binding.groomingLayout.setImageText(resources.getString(R.string.grooming), R.drawable.ic_groom)
        binding.clothingLayout.setImageText(resources.getString(R.string.clothing), R.drawable.ic_cloth)

        binding.bedLayout.setImageText(resources.getString(R.string.bed), R.drawable.ic_bed)
        binding.homeLayout.setImageText(resources.getString(R.string.homes), R.drawable.ic_home)

        binding.foodLayout.setTextColorLayout(AppCompatResources.getColorStateList(this, R.color.black))
        binding.accesoryLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.healthLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))

        binding.toysLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.petsLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))

        binding.medicineLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.groomingLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.clothingLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.bedLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.homeLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))


        binding.foodLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14))
        binding.accesoryLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )
        binding.healthLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.toysLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.petsLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.medicineLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.groomingLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.clothingLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.bedLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.homeLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )
    }

    private fun setUpOnClick() {
        binding.rlFollow.setOnClickListener {
            if (binding.tvFollow.text == getString(R.string.follow)) {
                binding.tvFollow.text = getString(R.string.unfollow)
                binding.ivFollowIcon.setImageDrawable(getDrawable(R.drawable.ic_unfollow))
                binding.tvDelivery.text = getString(R.string.unfollow_text)
            } else {
                binding.tvFollow.text = getString(R.string.follow)
                binding.ivFollowIcon.setImageDrawable(getDrawable(R.drawable.ic_follow))
                binding.tvDelivery.text = getString(R.string.delivery_here)
            }
        }
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.hello_pet)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, ProductListingActivity::class.java)
        startActivity(intent)
    }

}