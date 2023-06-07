package com.i9betstoryphat.i9bet.ui

import android.content.Intent
import android.net.Uri
import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.MainActivity
import com.i9betstoryphat.i9bet.databinding.ActivityParentBinding
import com.i9betstoryphat.i9bet.utils.AppUtils

class ParentActivity : BaseActivity<ActivityParentBinding>() {
    override fun getViewBinding() = ActivityParentBinding.inflate(layoutInflater)


    override fun initView() {
        super.initView()
        var item = AppUtils.getLogin()
        if (item?.lct == "true") {
            binding.textIntroduce.setText("ĐỔI LINK")
        } else {
            binding.textIntroduce.setText("GIỚI THIỆU")
        }
        binding.textHome.setOnClickListener {
            if (item?.lct == "true") {
                openWed(item.homeURL)
            } else {
                startActivity(Intent(this, MainActivity::class.java))

            }
        }

        binding.textIntroduce.setOnClickListener {
            if (item?.lct == "true") {
                openWed(item.changeURL)
            } else {
                startActivity(Intent(this, IntroduceActivity::class.java))
            }
        }

        binding.textPolicy.setOnClickListener {
            startActivity(Intent(this, PolicyActivity::class.java))

        }

        binding.textSupport.setOnClickListener {
            if (item?.lct == "true") {
                openWed(item.contact)
            } else {
                startActivity(Intent(this, SupportActivity::class.java))

            }
        }
    }

    private fun openWed(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}