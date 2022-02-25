package com.example.exammodel5.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exammodel5.R
import com.example.exammodel5.model.HomeHorizantal


class HomeHorizantalAdapter(
    private val context: Context,
    private val list: ArrayList<HomeHorizantal>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_home_horizantal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        if (holder is MyViewHolder) {

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}