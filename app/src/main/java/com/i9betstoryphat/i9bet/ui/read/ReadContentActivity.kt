package com.i9betstoryphat.i9bet.ui.read

import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.databinding.ActivityReadContentBinding
import com.i9betstoryphat.i9bet.ui.home.HomeFragment

class ReadContentActivity : BaseActivity<ActivityReadContentBinding>() {
    override fun getViewBinding() = ActivityReadContentBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        binding.layoutHeader.imageBack.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
        super.initData()
        var item = HomeFragment.contentCurrent
        binding.layoutHeader.textHeader.setText("ĐỌC TRUYỆN")
        binding.titleHeader.text = item.title
        binding.titleContent.text = item.detailpath?.let { getString(it) }

    }
}