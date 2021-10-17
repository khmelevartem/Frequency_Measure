package com.tubetoast.frequencymeasure.data.cache

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import java.util.*

class SharedPrefsStateCache(context: Context) : StateCache {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    override fun getStart(): Date? {
        val json = sharedPreferences.getString(START, DEFAULT)
        return if (json == DEFAULT) null
        else converter.fromJson(json, Date::class.java)
    }

    override fun saveStart(start: Date) {
        editor.putString(START, converter.toJson(start)).apply()
    }

    override fun eraseStart() {
        editor.putString(START, null).apply()
    }

    companion object {
        const val PREFS = "state prefs"
        const val DEFAULT = "shared prefs default"
        const val START = "state start"
        private val converter = Gson()
    }

}
