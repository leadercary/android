package com.example.myapplication.network.model

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(context: Context) {
    private val prefm = "mPref"
    private val prefs = context.getSharedPreferences(prefm,MODE_PRIVATE)

    var token: String?
    get() = prefs.getString("token","")
    set(value) {
        prefs.edit().putString("token",value).apply()
    }


}
class App: Application() {
    companion object {
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}