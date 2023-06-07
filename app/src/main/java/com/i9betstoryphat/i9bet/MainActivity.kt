package com.i9betstoryphat.i9bet

import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.i9betstoryphat.i9bet.databinding.ActivityMainBinding
import com.i9betstoryphat.i9bet.ui.home.HomeFragment

class MainActivity : BaseActivity<ActivityMainBinding>(){

    private var fragmentMain: Fragment? = null
    private var fragmentManager: FragmentManager? = null

    override fun initView() {
        super.initView()
        val home = HomeFragment()
        val dashBoard = HomeFragment()
        val noti = HomeFragment()
        fragmentManager = supportFragmentManager
        val navView = binding.navView
        navView.selectedItemId = R.id.navigation_home
        loadFragment(home)
        navView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_home -> loadFragment(home)
                R.id.navigation_dashboard -> loadFragment(dashBoard)
                R.id.navigation_notifications -> loadFragment(noti)
            }
            false
        }
    }
    private fun loadFragment(fragment: Fragment) {
        if (fragment.isAdded) {
            if (fragment.isVisible) {
                fragmentMain = fragment
                return
            }
            fragmentManager?.beginTransaction()?.hide(fragmentMain!!)?.show(fragment)?.commit()
        } else {
            if (fragmentMain != null) {
                fragmentManager?.beginTransaction()
                    ?.add(R.id.nav_host_fragment_activity_main, fragment)?.hide(fragmentMain!!)?.commit()
            } else {
                fragmentManager?.beginTransaction()
                    ?.add(R.id.nav_host_fragment_activity_main, fragment)?.commit()
            }
        }
        fragmentMain = fragment
    }


    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)
}