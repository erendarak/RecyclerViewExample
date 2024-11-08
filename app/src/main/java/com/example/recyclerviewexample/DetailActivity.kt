package com.example.recyclerviewexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerviewexample.model.F1Driver
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewexample.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DRIVER_NAME = "driver_name"
        const val DRIVER_TEAM = "driver_team"
        const val DRIVER_CHAMPIONSHIPS = "driver_championships"
        const val DRIVER_YEARS = "driver_years"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_detail
        )

        val name = intent.getStringExtra(DRIVER_NAME) ?: "N/A"
        val team = intent.getStringExtra(DRIVER_TEAM) ?: "N/A"
        val championships = intent.getIntExtra(DRIVER_CHAMPIONSHIPS, 0)
        val years = intent.getIntegerArrayListExtra(DRIVER_YEARS) ?: arrayListOf()

        val driver = F1Driver(name, team, championships, years)
        binding.driver = driver

        val yearsText = years.joinToString(", ")
        binding.yearsTextView.text = yearsText

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

