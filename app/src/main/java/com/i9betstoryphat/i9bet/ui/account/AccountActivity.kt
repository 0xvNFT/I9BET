package com.i9betstoryphat.i9bet.ui.account

import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.databinding.ActivityAccountBinding

class AccountActivity : BaseActivity<ActivityAccountBinding>() {

    override fun getViewBinding() = ActivityAccountBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        binding.layoutHeader.imageBack.setOnClickListener {
            finish()
        }

        binding.layoutHeader.textHeader.text = "THÔNG TIN"

        binding.btnOut.setOnClickListener {
            finishAffinity()
        }

    }
}
