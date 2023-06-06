package com.i9betstoryphat.i9bet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.customview.PagerScroll
import com.i9betstoryphat.i9bet.data.Banner
import com.i9betstoryphat.i9bet.databinding.FragmentHomeBinding
import com.i9betstoryphat.i9bet.ui.adapter.ContentAdapter
import com.i9betstoryphat.i9bet.ui.banner.BannerAdapter
import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var pagerBanner: BannerAdapter

    private lateinit var adapterContent: ContentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()


    }

    private fun initView() {
        var list = ArrayList<Banner>()
        list.add(Banner("image 1", 0, R.drawable.banner_1))
        list.add(Banner("image 2", 1, R.drawable.banner_2))

        pagerBanner = BannerAdapter(list, requireActivity())
        binding.viewPager.adapter = pagerBanner
        binding.dotsIndicator.numberOfItems = list.size
        binding.viewPager.addOnPageChangeListener(object : PagerScroll() {
            override fun onSelected(position: Int) {
                super.onSelected(position)
                selectDotAtPosition( binding.dotsIndicator, position)
            }
        })

        adapterContent = ContentAdapter()


    }

    private fun selectDotAtPosition(dotIndicator: DotIndicator, position: Int) {
        dotIndicator.setSelectedItem(position, true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}