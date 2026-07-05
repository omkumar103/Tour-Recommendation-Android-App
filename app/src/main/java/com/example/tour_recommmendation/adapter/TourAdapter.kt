package com.example.tour_recommmendation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_recommmendation.R
import com.example.tour_recommmendation.model.Tour

class TourAdapter(
    private val tourList: List<Tour>
) : RecyclerView.Adapter<TourAdapter.TourViewHolder>() {

    class TourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtBudget: TextView = itemView.findViewById(R.id.txtBudget)
        val txtDuration: TextView = itemView.findViewById(R.id.txtDuration)
        val txtInterest: TextView = itemView.findViewById(R.id.txtInterest)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tour, parent, false)

        return TourViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tourList.size
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {

        val tour = tourList[position]

        holder.txtName.text = tour.name
        holder.txtBudget.text = "Budget : ${tour.budget}"
        holder.txtDuration.text = "Duration : ${tour.duration}"
        holder.txtInterest.text = "Interest : ${tour.interest}"

    }

}