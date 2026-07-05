package com.example.tour_recommmendation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.content.Intent
import android.widget.Button

class PreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        val budgetSpinner = findViewById<Spinner>(R.id.spBudget)
        val durationSpinner = findViewById<Spinner>(R.id.spDuration)
        val interestSpinner = findViewById<Spinner>(R.id.spInterest)

        val budgetList = arrayOf(
            "Low",
            "Medium",
            "High",
            "Luxury"
        )

        val durationList = arrayOf(
            "1-2 Days",
            "3-5 Days",
            "6-10 Days",
            "10+ Days"
        )

        val interestList = arrayOf(
            "Nature",
            "Adventure",
            "Beach",
            "Historical",
            "Religious",
            "Wildlife"
        )

        budgetSpinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, budgetList)

        durationSpinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, durationList)

        interestSpinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, interestList)

        val btnRecommend = findViewById<Button>(R.id.btnRecommend)

        btnRecommend.setOnClickListener {

            val intent = Intent(this, RecommendationActivity::class.java)

            intent.putExtra("budget", budgetSpinner.selectedItem.toString())
            intent.putExtra("duration", durationSpinner.selectedItem.toString())
            intent.putExtra("interest", interestSpinner.selectedItem.toString())

            startActivity(intent)

        }
    }
}