package com.i9betstoryphat.i9bet.ui

import android.content.Intent
import android.net.Uri
import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.databinding.ActivitySupportBinding

class SupportActivity : BaseActivity<ActivitySupportBinding>() {

    override fun getViewBinding() = ActivitySupportBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        binding.imageBack.setOnClickListener {
            finish()
        }
        binding.layoutFb.setOnClickListener {  openWed("https://m.facebook.com/") }

        binding.layoutZalo.setOnClickListener {  openWed("https://zalo.me/pc") }

        binding.layoutTelegram.setOnClickListener {  openWed("https://web.telegram.org/") }

        binding.layoutMes.setOnClickListener {  openWed("https://www.messenger.com/") }

    }

    private fun openWed(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }


}