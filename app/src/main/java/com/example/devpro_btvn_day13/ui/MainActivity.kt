package com.example.devpro_btvn_day13.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModelProvider
import com.example.devpro_btvn_day13.R
import com.example.devpro_btvn_day13.api.response.BaseResponse
import com.example.devpro_btvn_day13.repositories.WeatherRepository

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private fun showLoading() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weatherRepository = WeatherRepository()

        val mainViewModelFactory=MainViewModelFactory(weatherRepository,application)

        mainViewModel= ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.getCurrentWeatherByCityName("Hà nội")
        mainViewModel.currentWeatherResult.observe(this, Observer {it
            when(it){
                is BaseResponse.Loading ->showLoading()
                is BaseResponse.Success ->{
                    hideLoading()
                    val currentWeatherResponse=it.data
                    Log.d("TAG", "onCreate: ${currentWeatherResponse?.city}")
                }
                is BaseResponse.Error ->{
                    hideLoading()
                    val currentWeatherResponse=it.data
                    Log.d("TAG", "onCreate: ${it.message}")
                }
            }

        })
    }

    private fun hideLoading() {
    }
}