package com.example.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.model.Cars
import com.example.advweek4.model.Specs

class CarListAdapter(val cars:ArrayList<Cars>)
    :RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {
        class CarViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.car_list_item, parent, false)
        return CarListAdapter.CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val txtModel = holder.itemView.findViewById<TextView>(R.id.txtModel)
        val txtYear = holder.itemView.findViewById<TextView>(R.id.txtYear)
        val txtColor = holder.itemView.findViewById<TextView>(R.id.txtColor)
        txtModel.text = cars[position].model
        txtYear.text = cars[position].year.toString()
        txtColor.text = cars[position].color
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