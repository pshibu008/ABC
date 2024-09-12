package com.example.abc.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.abc.R
import com.example.abc.domain.model.CustomItem

class CarouselViewPagerAdapter(
    private val customItems: List<CustomItem>,
    private val onPageSelected: (Int) -> Unit
) : RecyclerView.Adapter<CarouselViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(customItems[position].image)
        holder.itemView.setOnClickListener {
            onPageSelected(position)
        }
    }

    override fun getItemCount(): Int = customItems.size
}
