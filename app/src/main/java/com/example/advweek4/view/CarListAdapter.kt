package com.example.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.model.Cars

class CarListAdapter(val cars:ArrayList<Cars>)
    :RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {
        class CarViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.car_list_item, parent, false)
        return CarListAdapter.CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        var txtResult = holder.itemView.findViewById<TextView>(R.id.txtResult)
        var model = cars[position].model
        var year = cars[position].year
        txtResult.text = "$model $year"
    }

    fun updateCarList(newCars: ArrayList<Cars>) {
        cars.clear()
        cars.addAll(newCars)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cars.size
    }

}