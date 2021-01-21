package com.codingwithdhrumil.mvvmretrofitkotlincoroutines.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.api.ApiClient
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.utils.ApiResponse
import kotlinx.coroutines.Dispatchers

class EmployeeViewModel() : ViewModel() {

    fun getEmployees() = liveData(Dispatchers.IO) {
        emit(ApiResponse.loading(data = null))
        try {
            emit(ApiResponse.success(data = ApiClient.apiService.getEmployees()))
        } catch (exception: Exception) {
            emit(ApiResponse.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}