package com.codingwithdhrumil.mvvmretrofitkotlincoroutines.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.R
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.models.Employee
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.utils.ApiStatus
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.utils.Utility.showProgressBar
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.utils.Utility.hideProgressBar
import com.codingwithdhrumil.mvvmretrofitkotlincoroutines.viewmodels.EmployeeViewModel
import com.example.mvvmsample.adapters.EmployeesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var listEmployees: MutableList<Employee>
    private lateinit var employeesAdapter: EmployeesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_employees.layoutManager = LinearLayoutManager(this@MainActivity)
        listEmployees = mutableListOf<Employee>()
        employeesAdapter = EmployeesAdapter(this,
            listEmployees
        )
        recycler_employees.adapter = employeesAdapter

        val employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        employeeViewModel.getEmployees().observe(this, Observer {
            it?.let { apiResponse ->
                when (apiResponse.apiStatus) {
                    ApiStatus.SUCCESS -> {
                        recycler_employees.visibility = View.VISIBLE
                        hideProgressBar()
                        apiResponse.data?.let {
                            listEmployees.clear()
                            listEmployees.addAll(it)
                            employeesAdapter.apply {
                                notifyDataSetChanged()
                            }
                        }
                    }
                    ApiStatus.ERROR -> {
                        recycler_employees.visibility = View.VISIBLE
                        hideProgressBar()
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    ApiStatus.LOADING -> {
                        showProgressBar()
                        recycler_employees.visibility = View.GONE
                    }
                }
            }
        })

    }

}
