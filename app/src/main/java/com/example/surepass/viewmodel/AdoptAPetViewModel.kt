package com.example.surepass.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surepass.data.AdoptAPetEntry
import com.example.surepass.domain.retrofit.RetrofitClient
import kotlinx.coroutines.launch

class AdoptAPetViewModel : ViewModel() {
    private val adoptAPetService = RetrofitClient.apiService

    private val _petList = MutableLiveData<List<AdoptAPetEntry>>()
    val petList: LiveData<List<AdoptAPetEntry>> get() = _petList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun fetchPetList() {
        viewModelScope.launch {
            try {
                val response = adoptAPetService.getPetList()
                if (response.isSuccessful) {
                    val adoptAPetResponse = response.body()
                    _petList.value = adoptAPetResponse?.entries
                } else {
                    Log.d(TAG, "fetchPetList: technical error")
                }
            } catch (e: Exception) {
                Log.d(TAG, "fetchPetList: technical error")
            } finally {
                _isLoading.value = false // Hide the loading state
            }
        }
    }
}
