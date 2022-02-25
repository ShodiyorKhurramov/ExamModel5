package com.example.exammodel5.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.exammodel5.Fragments.IntroFragment
import com.example.exammodel5.model.Intro


class ViewPagerAdapter(fragmentManager: FragmentManager, private val list: ArrayList<Intro>) :
    FragmentPagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return IntroFragment.getInstance(list[position])
    }
}



