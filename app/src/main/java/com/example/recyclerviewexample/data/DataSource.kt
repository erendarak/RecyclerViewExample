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

    fun loadF1Drivers(): List<F1Driver> {
        val namesList = getDriverNamesList()
        val teamsList = getDriverTeamsList()
        val championshipsList = getDriverChampionshipsList()

        val drivers = mutableListOf<F1Driver>()
        for (i in namesList.indices) {
            val name = namesList[i]
            val team = teamsList[i]
            val championships = championshipsList[i].toIntOrNull() ?: 0

            drivers.add(F1Driver(name, team, championships))
        }
        return drivers
    }
}

