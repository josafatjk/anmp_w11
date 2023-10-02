package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.viewmodel.CarsViewModel

class CarListFragment : Fragment() {
    private lateinit var viewModel:CarsViewModel
    private val adapter = CarListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarsViewModel::class.java)
        viewModel.refresh()

        val recViewCars = view.findViewById<RecyclerView>(R.id.recViewCars)
        recViewCars.layoutManager = LinearLayoutManager(context)
        recViewCars.adapter = adapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.carsLD.observe(viewLifecycleOwner, Observer {
            adapter.updateCarList(it)
        })

}}