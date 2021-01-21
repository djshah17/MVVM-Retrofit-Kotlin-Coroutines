package com.codingwithdhrumil.mvvmretrofitkotlincoroutines.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Employee(
    @SerializedName("id")
    val employeeId: Int? = null,

    @SerializedName("name")
    val employeeName: String? = null,

    @SerializedName("username")
    val employeeUserName: String? = null,

    @SerializedName("email")
    val employeeEmail: String? = null,

    @SerializedName("address")
    val employeeAddressObject : EmployeeAddress? = null,

    @SerializedName("phone")
    val employeePhone: String? = null,

    @SerializedName("website")
    val employeeWebsite: String? = null
    ) : Serializable



