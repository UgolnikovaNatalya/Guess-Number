package com.example.mvpguesnumber.mvp_main

import android.view.View
import android.widget.EditText

interface MainContract {

    interface MainView
    {
        fun showGreetMessage()
        fun showToast(message : Int)
        fun clearMagicNumber()
        fun startNewActivity()
    }

    interface MainPresenter
    {
        fun saveMN(magNum : String)
    }

    interface MainRepo
    {
        fun saveMagicNumber(numb : String)
        fun startAttempt()
    }
}