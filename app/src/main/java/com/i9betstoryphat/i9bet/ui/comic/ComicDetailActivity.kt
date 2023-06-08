package com.i9betstoryphat.i9bet.ui.comic

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.Toast
import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.data.Content
import com.i9betstoryphat.i9bet.data.EventReload
import com.i9betstoryphat.i9bet.databinding.ActivityDetailComicBinding
import com.i9betstoryphat.i9bet.ui.home.HomeFragment
import com.i9betstoryphat.i9bet.ui.read.ReadContentActivity
import com.i9betstoryphat.i9bet.utils.AppCache
import org.greenrobot.eventbus.EventBus
import java.io.File
import java.io.FileOutputStream


class ComicDetailActivity : BaseActivity<ActivityDetailComicBinding>() {

    private lateinit var adapter: ComicAdapter
    override fun getViewBinding() = ActivityDetailComicBinding.inflate(layoutInflater)
    private var isClick = false
    private var contentDetail = Content()
    override fun initView() {
        super.initView()
        var item = HomeFragment.contentCurrent
        binding.titleHeader.text = item.title.toString()
        binding.titleContent.text = item.detail.toString()
        item.path?.let { binding.imageMain.setImageResource(it) }
        adapter = ComicAdapter()

        binding.rclMain.adapter = adapter
        adapter.clear()
        adapter.addAll(AppCache.getListContent())

        binding.btnOk.setOnClickListener {
            HomeFragment.contentCurrent = contentDetail
            startActivity(Intent(this, ReadContentActivity::class.java))
        }

        binding.imageBack.setOnClickListener {
            finish()
        }
        binding.btnLove.setOnClickListener {
            AppCache.saveLoveItem(item)
            Toast.makeText(this, "Thêm vào yêu thích thành công", Toast.LENGTH_LONG).show()
            android.os.Handler().postDelayed({
                EventBus.getDefault().post(EventReload())
            }, 1000)
        }

        adapter.click = {
            contentDetail = it
            isClick = true
            binding.titleHeader.text = it.title
            binding.titleContent.text = it.detail
            it.path?.let { it1 -> binding.imageMain.setImageResource(it1) }
        }
    }


}