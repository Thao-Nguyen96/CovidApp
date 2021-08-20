package com.nxt.coronaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemAdapter(var listCountry: ArrayList<Countries>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {

            holder.itemView.tv_country.text = listCountry[position].Country
            holder.itemView.tv_country_total_confirmed.text =
                listCountry[position].TotalConfirmed.toString()
            holder.itemView.tv_country_new_confirmed.text =
                listCountry[position].NewConfirmed.toString()
            holder.itemView.tv_country_total_deaths.text = listCountry[position].TotalDeaths.toString()
    }

    override fun getItemCount(): Int {
        return listCountry.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}