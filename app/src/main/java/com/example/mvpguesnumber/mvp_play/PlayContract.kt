package com.example.mvpguesnumber.mvp_play

import android.view.View
import android.widget.EditText
import androidx.annotation.DrawableRes

interface PlayContract {

    interface PlayView {
        fun changeGreetMessage(message: Int, attempts: Int)
        fun changePicture(@DrawableRes picture: Int)

        fun clearTryNumber()
        fun hideTryNumber()

        fun showButtonPlayAgain()
        fun hideButtonPlayAgain()

        fun showButtonTry()
        fun hideButtonTry()

        fun showToast(message: Int)
        fun startGameAgain()
    }

    interface PlayPresenter {
        fun load()
        fun checkNumber(tryNum: String)
    }

    interface PlayRepo {
        fun getMagicNumber() : Int

        fun getAttempt() : Int
        fun updateAttempt (attempt: Int)

        fun getUserCurrentNumber() : Int
        fun updateUserCurrentNumber(user_number : Int)
    }
}