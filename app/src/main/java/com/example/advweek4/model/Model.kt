package com.example.advweek4.model

import com.google.gson.annotations.SerializedName

data class Student(

    val id:String?,
    @SerializedName("student_name")
    val name:String?,
    @SerializedName("birth_of_date")
    val dob:String?,
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)

data class Cars(
    val id:Int?,
    val model:String?,
    val year:Int?,
    val color:String?,
    val features:List<String>?
)

data class Specs(
    val engine:String?,
    val transmission:String?,
    val topspeed:Double?
)