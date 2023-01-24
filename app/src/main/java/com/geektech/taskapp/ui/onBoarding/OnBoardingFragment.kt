package com.geektech.taskapp.ui.onBoarding

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.geektech.taskapp.R
import com.geektech.taskapp.data.Pref
import com.geektech.taskapp.databinding.FragmentOnBoardingBinding
import com.geektech.taskapp.ui.onBoarding.adapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        val adapter = OnBoardingAdapter() {
            pref.saveSeen()
            findNavController().navigateUp()
        }

        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }

}