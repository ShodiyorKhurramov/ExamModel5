package com.example.exammodel5.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.exammodel5.Fragments.ChatFragment
import com.example.exammodel5.Fragments.HomeFragment
import com.example.exammodel5.Fragments.SearchFragment
import com.example.exammodel5.Fragments.SortFragment
import com.example.exammodel5.R
import com.example.exammodel5.adapter.ViewPagerAdapter
import com.example.exammodel5.model.Intro
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var viewPager: ViewPager
    private lateinit var dotsIndicator: DotsIndicator
    private lateinit var skipButton: TextView
    private lateinit var nextButton: TextView
    private lateinit var linearLayoutBottom: LinearLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
    }

    private fun initViews() {
        context = this
        viewPager = findViewById(R.id.view_pager)
        dotsIndicator = findViewById(R.id.dots_indicator)
        skipButton = findViewById(R.id.skip_button)
        nextButton = findViewById(R.id.next_button)
        linearLayoutBottom = findViewById(R.id.intro_page_bottom_linear_layout)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)

        val adapter = ViewPagerAdapter(supportFragmentManager, prepareIntroModels())
        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)

        nextButton.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }
        skipButton.setOnClickListener {
            
            viewPager.visibility = View.GONE
            linearLayoutBottom.visibility = View.INVISIBLE
            bottomNavigationView.visibility = View.VISIBLE
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeFragment())
                .commit()
        }

        bottomNavigationView.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                if (item.itemId == R.id.icon_home) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, HomeFragment())
                        .commit()
                } else
                    if (item.itemId == R.id.icon_filter) {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, SortFragment())
                            .commit()
                    }
                if (item.itemId == R.id.icon_chat) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, ChatFragment())
                        .commit()
                }
                if (item.itemId == R.id.icon_search) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SearchFragment())
                        .commit()
                }
                return true
            }
        })

    }

    private fun prepareIntroModels(): ArrayList<Intro> {
        val list = ArrayList<Intro>()

        list.add(
            Intro(
                R.drawable.ic_baseline_favorite_border_24,
                "Saved Listings",
                "Save your favorite listings to come back to them later"
            )
        )

        list.add(
            Intro(
                R.drawable.ic_outline_camera_alt_24,
                "Add new Listings",
                "Save your favorite listings to come back to them later"
            )
        )

        list.add(
            Intro(
                R.drawable.ic_baseline_chat_bubble_outline_24,
                "Chat",
                "Save your favorite listings to come back to them later"
            )
        )

        list.add(
            Intro(
                R.drawable.ic_baseline_notifications_none_24,
                "Get notified",
                "Save your favorite listings to come back to them later"
            )
        )

        return list
    }
}