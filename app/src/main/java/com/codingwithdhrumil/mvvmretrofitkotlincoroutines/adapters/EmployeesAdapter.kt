package com.example.mvvmsample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.R
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.models.Employee

class EmployeesAdapter(private val context: Context, private var listEmployees: MutableList<Employee>) : RecyclerView.Adapter<EmployeesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.employee_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listEmployees.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val getEmployee = listEmployees.get(position)
        holder.employeeName?.text = getEmployee.employeeName
        holder.employeeInfo1?.text = getEmployee?.employeeUserName + " | " + getEmployee?.employeeEmail
        holder.employeeInfo2?.text = getEmployee?.employeePhone + " | " + getEmployee?.employeeWebsite
        val employeeAddressObj = getEmployee.employeeAddressObject
        holder.employeeAddress?.text = employeeAddressObj?.employeeSuite + "," + employeeAddressObj?.employeeStreet + "," + employeeAddressObj?.employeeCity + "," + employeeAddressObj?.employeeZipCode
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        var employeeName: TextView? = null
        var employeeInfo1: TextView? = null
        var employeeInfo2: TextView? = null
        var employeeAddress: TextView? = null

        init {
            employeeName = view.findViewById(R.id.txt_employee_name)
            employeeInfo1 = view.findViewById(R.id.txt_employee_info1)
            employeeInfo2 = view.findViewById(R.id.txt_employee_info2)
            employeeAddress = view.findViewById(R.id.txt_employee_address)
        }

    }

}