package com.example.mvpguesnumber.dataSaving

import android.content.Context

private const val SP_NAME = "CN_PREF_NAME"
private const val KEY_SAVE_CN = "SAVED_CN_KEY"

interface SavedComputerNumber {
    var computerNumber: Int
}

class SavedComputerNumberImpl (context: Context) : SavedComputerNumber {

    private val sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    override var computerNumber: Int
        get() {
            return sp.getInt(KEY_SAVE_CN, -1)
        }
        set(value) {
            sp.edit()
                .putInt(KEY_SAVE_CN, value)
                .apply()
        }
}