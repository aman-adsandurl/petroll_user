package com.petroll.ui.dashboard.market

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.content.res.AppCompatResources
import com.petroll.R
import com.petroll.databinding.ActivityMarketBinding
import com.petroll.ui.dashboard.market.marketpackage.AuctionActivity
import com.petroll.ui.dashboard.market.marketpackage.BuyActivity
import com.petroll.ui.dashboard.market.marketpackage.ShopActivity
import com.petroll.utils.BaseActivity

class MarketActivity : BaseActivity() {

    lateinit var binding: ActivityMarketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpIconLayout()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpIconLayout() {
        binding.iconLayout.iclCheck.setImageResource(R.drawable.ic_calendar, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclFav.setImageResource(R.drawable.ic_fav_top, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))
        binding.iconLayout.iclWish.setImageResource(R.drawable.ic_wishlist, AppCompatResources.getColorStateList(this,R.color.skip_circle_color))


        binding.shopLayout.setSmallCircle()
        binding.sellLayout.setSmallCircle()
        binding.auctionLayout.setSmallCircle()


        binding.shopLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.light_yellow))
        binding.sellLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.ligh_greyish))
        binding.auctionLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(this,R.color.lighter_yellow))

        binding.shopLayout.setImageText(resources.getString(R.string.shop), R.drawable.ic_shop)
        binding.sellLayout.setImageText(resources.getString(R.string.buy_sell), R.drawable.ic_sell)
        binding.auctionLayout.setImageText(resources.getString(R.string.auction), R.drawable.ic_auction_market)

        binding.shopLayout.setTextColorLayout(AppCompatResources.getColorStateList(this, R.color.black))
        binding.sellLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))
        binding.auctionLayout.setTextColorLayout(AppCompatResources.getColorStateList(this,R.color.black))


        binding.shopLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14))
        binding.sellLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )
        binding.auctionLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.shopLayout.setOnClickListener {
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }

        binding.sellLayout.setOnClickListener {
            val intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }

        binding.auctionLayout.setOnClickListener {
            val intent = Intent(this, AuctionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.market)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}