package com.example.recyclerviewexample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.DetailActivity
import com.example.recyclerviewexample.model.F1Driver
import android.view.View
import android.widget.TextView
import com.example.recyclerviewexample.R


class ItemAdapter(private val drivers: List<F1Driver>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val teamTextView: TextView = view.findViewById(R.id.teamTextView)

        fun bind(driver: F1Driver) {
            nameTextView.text = driver.name
            teamTextView.text = driver.team

            view.setOnClickListener {
                val context = view.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.DRIVER_NAME, driver.name)
                    putExtra(DetailActivity.DRIVER_TEAM, driver.team)
                    putExtra(DetailActivity.DRIVER_CHAMPIONSHIPS, driver.championships)
                    putIntegerArrayListExtra(DetailActivity.DRIVER_YEARS, ArrayList(driver.years))
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = drivers.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(drivers[position])
    }
}

