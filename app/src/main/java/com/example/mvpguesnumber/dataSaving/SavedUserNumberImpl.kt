package com.example.mvpguesnumber.dataSaving

import android.content.Context

private const val NAME_SP = "USER CURRENT NUMBER"
const val KEY_SAVED_USER_CURRENT_NUMBER = "CURRENT NUMBER"

interface SavedNumber {
    var userNumber : Int
}

class SavedUserNumberImpl (context: Context) : SavedNumber {

    private val sp = context.getSharedPreferences(NAME_SP, Context.MODE_PRIVATE)

    override var userNumber: Int
        get() {
            return sp.getInt(KEY_SAVED_USER_CURRENT_NUMBER, -1)
        }
        set(value) {
            sp.edit()
                .putInt(KEY_SAVED_USER_CURRENT_NUMBER, value)
                .apply()
        }
}