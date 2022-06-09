package com.example.motivacional

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val secutiry: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        secutiry.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return secutiry.getString(key,"") ?: "" //Operador Elvis
    }

    fun storeAge(key: String, str: String){
        secutiry.edit().putString(key,str).apply()
    }

    fun getAge(key: String):String {
        return secutiry.getString(key, "") ?: ""
    }
}