package com.i9betstoryphat.i9bet.ui.content

import android.content.Intent
import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.databinding.ActivityDetailContentBinding
import com.i9betstoryphat.i9bet.ui.adapter.ContentDetailAdapter
import com.i9betstoryphat.i9bet.ui.home.HomeFragment
import com.i9betstoryphat.i9bet.ui.read.ReadContentActivity
import com.i9betstoryphat.i9bet.utils.AppCache

class NewActivity : BaseActivity<ActivityDetailContentBinding>() {

    private lateinit var adapter: ContentDetailAdapter
    override fun getViewBinding() = ActivityDetailContentBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        var item = HomeFragment.contentCurrent
        binding.titleHeader.text = item.title.toString()
        binding.titleContent.text = item.detail.toString()
        item.path?.let { binding.imageMain.setImageResource(it) }
        adapter = ContentDetailAdapter()
        binding.rclMain.adapter = adapter

        adapter.clear()
        adapter.addAll(AppCache.getListContentDetail())
        binding.btnRead.setOnClickListener {
            startActivity(Intent(this, ReadContentActivity::class.java))
        }

        binding.layoutHeader.imageBack.setOnClickListener { finish() }
        binding.layoutHeader.textHeader.setText("Mới nhất")
    }

}