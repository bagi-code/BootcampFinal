package com.bagicode.bootcampfinal.model.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("email")
    val email: String,
    @SerializedName("id_user")
    val idUser: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("username")
    val username: String
)