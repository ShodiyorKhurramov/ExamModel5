package com.example.exammodel5.Fragments



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.exammodel5.R
import com.example.exammodel5.adapter.SortAdapter


class SortFragment: Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        rootView = layoutInflater.inflate(R.layout.fragment_sort, container, false)


        val adapter = SortAdapter(rootView.context,R.layout.item_sort)
        rootView.findViewById<RecyclerView>(R.id.recycler_sort).adapter = adapter

        return rootView
    }
}