package com.testapp.Utils

import android.content.Context
import android.content.SharedPreferences

object PrefService {

    val PREF_NAME = "MySharedName"
    lateinit var preferences:SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun setLoggedIn(value:Boolean){

        preferences.edit().putBoolean("login",true)

    }

    fun getLoggedIn():Boolean{

        return preferences.getBoolean("login",false)
    }

}