package com.bagicode.bootcampfinal

import com.bagicode.bootcampfinal.model.Wrapper
import com.bagicode.bootcampfinal.model.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface Endpoint {

    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("email") email: String,
              @Field("pass") pass: String): Observable<Wrapper<LoginResponse>>

}