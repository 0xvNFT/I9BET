package com.i9betstoryphat.i9bet

import android.content.Intent
import android.os.Looper
import com.i9betstoryphat.i9bet.databinding.ActivitySplashBinding
import com.i9betstoryphat.i9bet.ui.ParentActivity
import com.i9betstoryphat.i9bet.ui.phone.PhoneActivity
import com.i9betstoryphat.i9bet.utils.AppUtils

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun getViewBinding() = ActivitySplashBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            var item = AppUtils.getLogin()
            if (item == null) {
                startActivity(Intent(this, PhoneActivity::class.java))
            } else {
                startActivity(Intent(this, ParentActivity::class.java))
            }
        }, 1000)
    }
}
