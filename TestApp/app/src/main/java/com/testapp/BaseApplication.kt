package com.testapp

import android.app.Application
import com.testapp.Utils.PrefService


class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        PrefService.init(this)

    }

}