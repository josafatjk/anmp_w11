package com.example.advweek4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advweek4.model.Cars
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class CarsViewModel(application: Application):AndroidViewModel(application) {
    val carsLD = MutableLiveData<ArrayList<Cars>>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/anmp/cars.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Cars>>() { }.type
                val result = Gson().fromJson<List<Cars>>(it, sType)
                carsLD.value = result as ArrayList<Cars>?
                Log.d("showvolley", result.toString())
            },
            {
                Log.d("showvolley", it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}