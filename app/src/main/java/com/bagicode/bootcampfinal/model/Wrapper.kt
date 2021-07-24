package com.bagicode.bootcampfinal.model


import com.google.gson.annotations.SerializedName

data class Wrapper <T> (
    @SerializedName("codeMessage")
    val codeMessage: String,
    @SerializedName("codeStatus")
    val codeStatus: String,
    @SerializedName("data")
    val data: T
)