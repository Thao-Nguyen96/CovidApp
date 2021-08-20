package com.nxt.coronaapp

data class Model(val Global: Global, val Countries: ArrayList<Countries>)

data class Global(val TotalConfirmed: Int, val TotalDeaths: Int, val NewConfirmed: Int)
data class Countries(
    val Country: String,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val NewConfirmed: Int,
)