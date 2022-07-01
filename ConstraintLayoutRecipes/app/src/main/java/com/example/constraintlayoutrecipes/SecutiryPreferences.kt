package com.example.constraintlayoutrecipes

import android.content.Context
import android.content.SharedPreferences

class SecutiryPreferences(context: Context) {

    private val secutiry: SharedPreferences =
        context.getSharedPreferences("CLR", Context.MODE_PRIVATE)

    fun storeLike(key: String, str: String) {
        secutiry.edit().putString(key, str).apply()
    }

    fun getStoreLike(key: String): String {
        return secutiry.getString(key, "")?:""
    }

    fun storeIcon(key: String, str: String) {
        secutiry.edit().putString(key, str).apply()
    }

    fun getStoreIcon(key: String): String {
        return secutiry.getString(key, "")?:""
    }

}