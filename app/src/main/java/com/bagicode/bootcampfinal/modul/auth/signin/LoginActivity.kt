package com.bagicode.bootcampfinal.modul.auth.signin

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bagicode.bootcampfinal.BootCamp
import com.bagicode.bootcampfinal.R
import com.bagicode.bootcampfinal.model.response.LoginResponse
import com.bagicode.bootcampfinal.modul.main.HomeActivity
import com.google.gson.Gson

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var progressDialog: ProgressDialog
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        var btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            presenter.submitLogin("test3@gmail.com", "123456")
        }

    }

    override fun onLoginSuccess(loginResponse: LoginResponse) {
        BootCamp.getApp().setToken(loginResponse.key)

        val gson = Gson()
        val json = gson.toJson(loginResponse)
        BootCamp.getApp().setUser(json)

        val home = Intent(this, HomeActivity::class.java)
        startActivity(home)
        finish()
    }

    override fun onLoginFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait...")
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    override fun dismissLoading() {
        progressDialog.dismiss()
    }
}