package com.bagicode.bootcampfinal.modul.auth.signin

import com.bagicode.bootcampfinal.base.BasePresenter
import com.bagicode.bootcampfinal.base.BaseView
import com.bagicode.bootcampfinal.model.response.LoginResponse

interface LoginContract {
    interface View : BaseView {
        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(message: String)
    }

    interface Presenter : LoginContract, BasePresenter {
        fun submitLogin(email:String, password:String)
    }
}