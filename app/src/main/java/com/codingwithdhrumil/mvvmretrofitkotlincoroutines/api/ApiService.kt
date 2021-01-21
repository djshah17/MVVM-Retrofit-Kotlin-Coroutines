package com.codingwithdhrumil.mvvmretrofitkotlincoroutines.api

import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.models.Employee
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getEmployees(): ArrayList<Employee>

}