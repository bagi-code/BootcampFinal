package com.bagicode.bootcampfinal.modul.auth.signin

import com.bagicode.bootcampfinal.HttpClient
import com.bagicode.bootcampfinal.utils.Helpers.getErrorBodyMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter (private val view:LoginContract.View) : LoginContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun submitLogin(email: String, password: String) {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.codeStatus.equals("200")) {
                        view.onLoginSuccess(it.data)
                    } else {
                        view.onLoginFailed(it.codeMessage)
                    }

                },
                {
                    view.dismissLoading()
                    view.onLoginFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {}

    override fun unSubscribe() {
        mCompositeDisposable!!.clear()
    }
}