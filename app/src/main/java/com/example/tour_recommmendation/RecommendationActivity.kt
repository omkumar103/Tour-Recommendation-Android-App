package com.example.tour_recommmendation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_recommmendation.adapter.TourAdapter
import com.example.tour_recommendation.utils.TourData
import android.view.View
import android.widget.TextView

class RecommendationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        val selectedBudget = intent.getStringExtra("budget")
        val selectedDuration = intent.getStringExtra("duration")
        val selectedInterest = intent.getStringExtra("interest")

        val tourList = TourData.tourList.filter {

            it.budget == selectedBudget &&
                    it.duration == selectedDuration &&
                    it.interest == selectedInterest

        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTours)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val txtNoData = findViewById<TextView>(R.id.txtNoData)


        if (tourList.isEmpty()) {

            recyclerView.visibility = View.GONE
            txtNoData.visibility = View.VISIBLE

        } else {

            recyclerView.visibility = View.VISIBLE
            txtNoData.visibility = View.GONE
            recyclerView.adapter = TourAdapter(tourList)

        }
    }
}