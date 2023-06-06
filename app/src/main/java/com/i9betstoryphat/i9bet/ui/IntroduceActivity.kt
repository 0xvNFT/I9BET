package com.i9betstoryphat.i9bet.ui

import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.databinding.ActivityPolicyBinding

class IntroduceActivity : BaseActivity<ActivityPolicyBinding>() {
    override fun getViewBinding() = ActivityPolicyBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        binding.imageBack.setOnClickListener {
            finish()
        }
        binding.titleHeader.text = "GIỚI THIỆU"
    }
}