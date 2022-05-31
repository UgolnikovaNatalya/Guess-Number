package com.example.mvpguesnumber

import android.content.Context
import android.util.Log

private const val SP_NAME = "SM_PREF_NAME"
private const val KEY_SAVE_MN = "SAVED_MN_KEY"

interface SavedMagicNumber {
    var magicNumber: Int
}

//для сохранения состояния нужен sharedPreference
//для него нужен context

class SavedMagicNumberImpl(context: Context) : SavedMagicNumber {

    private val sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    override var magicNumber: Int
        get() {
            return sp.getInt(KEY_SAVE_MN, -1)
        }
        set(value) {
            sp.edit()
                .putInt(KEY_SAVE_MN, value)
                .apply()
        }


}