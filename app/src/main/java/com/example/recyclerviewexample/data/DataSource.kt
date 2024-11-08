package com.example.recyclerviewexample.data
import android.content.Context
import com.example.recyclerviewexample.model.F1Driver
import com.example.recyclerviewexample.R

class DataSource(private val context: Context) {

    private fun getDriverNamesList(): Array<String> {
        return context.resources.getStringArray(R.array.driver_names_array)
    }

    private fun getDriverTeamsList(): Array<String> {
        return context.resources.getStringArray(R.array.driver_teams_array)
    }

    private fun getDriverChampionshipsList(): Array<String> {
        return context.resources.getStringArray(R.array.driver_championships_array)
    }

    private fun getDriverYearsList(): Array<String> {
        return context.resources.getStringArray(R.array.driver_years_array)
    }

    fun loadF1Drivers(): List<F1Driver> {
        val namesList = getDriverNamesList()
        val teamsList = getDriverTeamsList()
        val championshipsList = getDriverChampionshipsList()
        val yearsList = getDriverYearsList()

        val drivers = mutableListOf<F1Driver>()
        val size = minOf(namesList.size, teamsList.size, championshipsList.size, yearsList.size)

        for (i in 0 until size) {
            val name = namesList[i]
            val team = teamsList[i]
            val championships = championshipsList[i].toIntOrNull() ?: 0
            val yearsString = yearsList[i]
            val years = yearsString.split(",").mapNotNull { it.trim().toIntOrNull() }

            drivers.add(F1Driver(name, team, championships, years))
        }
        return drivers
    }
}

