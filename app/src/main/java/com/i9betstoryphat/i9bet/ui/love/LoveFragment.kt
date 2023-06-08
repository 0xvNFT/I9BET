package com.i9betstoryphat.i9bet.ui.love

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.data.EventReload
import com.i9betstoryphat.i9bet.databinding.FragmentDashboardBinding
import com.i9betstoryphat.i9bet.ui.adapter.ContentDetailAdapter
import com.i9betstoryphat.i9bet.ui.content.ContentDetailActivity
import com.i9betstoryphat.i9bet.ui.home.HomeFragment
import com.i9betstoryphat.i9bet.utils.AppUtils
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class LoveFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private var adapter = ContentDetailAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {
        binding.rclMain.adapter = adapter
        adapter.clear()
        var list = AppUtils.getLoveStory()
        if (list.isNullOrEmpty()) {
            list = ArrayList()
        }
        adapter.addAll(list)
        binding.layoutHeader.imageBack.visibility = View.GONE
        binding.layoutHeader.textHeader.setText("YÊU THÍCH")

        binding.textNovel.setOnClickListener {
            selectNovel(true)
        }

        binding.textComic.setOnClickListener {
            selectNovel(false)
        }

        selectNovel(true)
        adapter.click = {
            HomeFragment.contentCurrent = it
            startActivity(Intent(requireActivity(), ContentDetailActivity::class.java))
        }

    }

    private fun selectNovel(check: Boolean) {
        if (check) {
            binding.viewNovel.setBackgroundResource(R.color.color_text_more)
            binding.textNovel.setTextColor(resources.getColor(R.color.color_text_more))
            binding.textComic.setTextColor(resources.getColor(R.color.white))

            binding.viewComic.setBackgroundResource(R.color.white)

        } else {
            binding.viewNovel.setBackgroundResource(R.color.white)
            binding.viewComic.setBackgroundResource(R.color.color_text_more)
            binding.textNovel.setTextColor(resources.getColor(R.color.white))
            binding.textComic.setTextColor(resources.getColor(R.color.color_text_more))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: Any) {
        try {
            if (event is EventReload) {
                adapter.clear()
                var list = AppUtils.getLoveStory()
                if (list.isNullOrEmpty()) {
                    list = ArrayList()
                }
                adapter.addAll(list)
            }
        } catch (ignored: Exception) {
        }
    }
}