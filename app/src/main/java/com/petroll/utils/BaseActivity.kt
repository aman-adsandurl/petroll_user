package com.petroll.utils

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.petroll.R
import com.petroll.databinding.ActivityBaseBinding
import com.petroll.ui.dashboard.fragments.FeedFragment
import com.petroll.ui.dashboard.fragments.HomeFragment
import com.petroll.ui.dashboard.fragments.NotificationFragment
import com.petroll.ui.dashboard.fragments.ProfileDashboardFragment
import com.petroll.ui.navigation.fragments.*


open class BaseActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    val HOME = 1
    val FEED = 3
    val NOTIFICATION = 4
    val PROFILE = 5
    val FAV = 2

    val WISHLIST = R.id.nav_wishlist

    lateinit var baseBind: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseBind = ActivityBaseBinding.inflate(layoutInflater)
        super.setContentView(baseBind.root)
        setUpBottomNav()
        setFragment(HomeFragment(), true)
        setUpFragmentsBottomBar()
        setNavigationViewListener()
    }

    fun onQuickAccessClick(onClick: () -> Unit) {
        baseBind.addQuickAccess.visibility = View.VISIBLE
        baseBind.addQuickAccess.setOnClickListener {
            onClick()
        }
    }

    fun hideBottomBar(buttonText: String) {
        baseBind.rlNext.visibility = View.VISIBLE
        baseBind.tvButton.text = buttonText
        baseBind.bottmNav.visibility = View.GONE
    }

    fun setBottomBarText(buttonText: String) {
        baseBind.tvButton.text = buttonText
    }

    fun nextClickListener(intent: Intent) {
        baseBind.rlNext.setOnClickListener {
            startActivity(intent)
        }
    }

    fun showBottomBar() {
        baseBind.rlNext.visibility = View.GONE
        baseBind.bottmNav.visibility = View.VISIBLE
    }

    override fun setContentView(view: View?) {
        baseBind.contentActivity.removeAllViews()
        baseBind.contentActivity.addView(view)
        setAdapter()
    }

    fun hideContent() {
        baseBind.content.visibility = View.GONE
        baseBind.contentActivity.visibility = View.VISIBLE
    }

    fun showContent() {
        baseBind.contentActivity.visibility = View.GONE
        baseBind.content.visibility = View.VISIBLE
    }

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private fun setAdapter() {
        setSupportActionBar(baseBind.toolbar.toolbar)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, baseBind.drawer, R.string.open, R.string.close)

        baseBind.drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        val actionBar = supportActionBar
        actionBar!!.setHomeAsUpIndicator(R.drawable.left_navigation)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    // bottom bar
    protected fun setUpFragmentsBottomBar() {
        baseBind.bottmNav.setOnClickMenuListener {
            when (it.id) {
                HOME -> setFragment(HomeFragment(), true)
                NOTIFICATION -> setFragment(NotificationFragment(), true)
                PROFILE -> setFragment(ProfileDashboardFragment(), true)
                FEED -> setFragment(FeedFragment(), true)
            }
        }
    }

    private fun setFragment(fragment: Fragment, isHome: Boolean) {
        showBottomBar()
        showContent()
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.commit()
    }

    fun onHome() {
        setFragment(HomeFragment(), true)
        baseBind.bottmNav.show(HOME)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun setNavigationViewListener() {
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    protected fun setUpBottomNav() {
        baseBind.bottmNav.add(MeowBottomNavigation.Model(HOME, R.drawable.ic_botm_home))
        baseBind.bottmNav.add(MeowBottomNavigation.Model(FAV, R.drawable.ic_suggestion))
        baseBind.bottmNav.add(MeowBottomNavigation.Model(FEED, R.drawable.ic_inact_feeds))
        baseBind.bottmNav.add(
            MeowBottomNavigation.Model(
                NOTIFICATION,
                R.drawable.ic_inact_notification
            )
        )
        baseBind.bottmNav.add(MeowBottomNavigation.Model(PROFILE, R.drawable.ic_inact_profile))
    }

    private var selectedItem = 0
    protected fun getBottomBarTap(): Int {
        return selectedItem;
    }

    protected fun setUpBottomClickedView(isDashboard: Boolean) {
        if (isDashboard) {
            baseBind.bottmNav.show(1)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_wishlist -> setFragment(WishlistFragment(), false)
            R.id.nav_following -> setFragment(FollowingFragment(false), false)
            R.id.nav_sold -> setFragment(SoldFragment(), false)
            R.id.nav_address -> setFragment(AddAddressFragment(), false)
            R.id.nav_auction -> setFragment(AuctionFragment(true), false)
            R.id.nav_blocklist -> setFragment(FollowingFragment(true), false)
            R.id.nav_appnt -> setFragment(AuctionFragment(false), false)
            R.id.nav_setting -> setFragment(SettingsFragment(), false)
            R.id.nav_order -> setFragment(OrdersFragment(), false)
            R.id.nav_chat -> setFragment(ChatFragment(), false)
        }
        baseBind.drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}