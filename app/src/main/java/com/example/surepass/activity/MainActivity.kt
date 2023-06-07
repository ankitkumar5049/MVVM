package com.example.surepass.activity

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.surepass.R
import com.example.surepass.adapter.PetAdapter
import com.example.surepass.data.AdoptAPetEntry
import com.example.surepass.viewmodel.AdoptAPetViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AdoptAPetViewModel by viewModels()
    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listViewPets)
        progressBar = findViewById(R.id.progressBar)

        viewModel.petList.observe(this) { petList ->
            handlePetList(petList)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            handleLoadingState(isLoading)
        }

        viewModel.fetchPetList()
    }

    private fun handlePetList(petList: List<AdoptAPetEntry>) {
        val adapter = PetAdapter(this, petList)
        listView.adapter = adapter
    }

    private fun handleLoadingState(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}