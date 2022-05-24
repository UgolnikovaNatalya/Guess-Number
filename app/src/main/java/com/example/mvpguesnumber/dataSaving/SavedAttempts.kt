package com.example.mvpguesnumber

import android.content.Context
import com.example.mvpguesnumber.mvp_main.DEFAULT_ATTEMPT

private const val SP_NAME = "ATT_PREF_NAME"
private const val KEY_SAVE_ATT = "SAVED_ATT_KEY"

interface SavedAttempts {
    var currentAttempt : Int
}

class SavedAttemptsInterfaceImpl (context: Context) : SavedAttempts {

    private val sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    override var currentAttempt: Int

        get() {
            return sp.getInt(KEY_SAVE_ATT, DEFAULT_ATTEMPT)
        }

        set(value) {
            sp.edit()
                .putInt(KEY_SAVE_ATT, value)
                .apply()
        }

}