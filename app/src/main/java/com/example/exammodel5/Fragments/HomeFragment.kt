package com.example.exammodel5.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exammodel5.R
import com.example.exammodel5.adapter.HomeHorizantalAdapter
import com.example.exammodel5.adapter.HomeVerticalAdapter
import com.example.exammodel5.model.HomeHorizantal
import com.example.exammodel5.model.HomeVertical


class HomeFragment : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = layoutInflater.inflate(R.layout.fragment_home, container, false)

        val recyclerViewHorizontal =
            rootView.findViewById<RecyclerView>(R.id.recycler_view_horizontal)

        val recyclerViewVertical =
            rootView.findViewById<RecyclerView>(R.id.recycler_view_vertical)


        recyclerViewHorizontal.layoutManager =
            LinearLayoutManager(rootView.context, LinearLayoutManager.HORIZONTAL, false)
        val adapter1 = HomeHorizantalAdapter(rootView.context, prepareHorizontalItems())
        recyclerViewHorizontal.adapter = adapter1

        recyclerViewVertical.layoutManager =
            GridLayoutManager(rootView.context, 2)
        val adapter2 = HomeVerticalAdapter(rootView.context,prepareVerticalItems())
        recyclerViewVertical.adapter = adapter2

        return rootView
    }

    private fun prepareHorizontalItems(): ArrayList<HomeHorizantal> {
        val list = ArrayList<HomeHorizantal>()

        for (i in 1..20) {
          list.add(HomeHorizantal(R.drawable.anonim_image,"title"))
        }
        return list
    }

    private fun prepareVerticalItems(): ArrayList<HomeVertical> {
        val list = ArrayList<HomeVertical>()

        for (i in 1..20) {
            list.add(HomeVertical(R.drawable.anonim_image, "title", 2))
        }
        return list
    }
}