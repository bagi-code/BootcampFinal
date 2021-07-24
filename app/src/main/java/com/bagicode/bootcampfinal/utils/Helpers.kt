package com.bagicode.bootcampfinal.utils

import com.bagicode.bootcampfinal.model.Wrapper
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.UnknownHostException

object Helpers {

    fun Throwable.getErrorBodyMessage(): String {
        return if (this is HttpException) {
            val errorCode = this.code()
            if (errorCode == 405) {
                "Method yang digunakan salah"
            } else if (errorCode == 503) {
                "Error Server"
            } else {
                val parseErrorBody = this.response()?.errorBody()!!.parseErrorBody()
                if (parseErrorBody?.codeMessage == null) {
                    "Permintaan anda belum berhasil di proses. Silakan coba kembali"
                } else {
                    parseErrorBody?.codeMessage.toString()
                }
            }

        } else if (this is ConnectException || this is UnknownHostException) {
            "Maaf Anda sedang Offline. Silakan coba kembali"

        } else {
            return if (this.message == null)
                "Permintaan anda belum berhasil di proses. Silakan coba kembali"
            else if (this.message.equals(""))
                ""
            else
                this.message!!

        }
    }

    fun ResponseBody.parseErrorBody(): Wrapper<*>? {
        val gson = Gson()
        val adapter = gson.getAdapter(Wrapper::class.java)
        try {
            return adapter.fromJson(string())
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

}