package com.example.letssopt.ui.home


data class Contents (
    val title : String ?= null,
    val titleImage : Int?= null,
    val images : List <Int> ,
    val imageWidth : Int= 100,
    val imageHeight : Int = 150
)