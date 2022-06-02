package com.example.mvpguesnumber.mvp_computer

import android.annotation.SuppressLint
import androidx.annotation.StringRes

interface ComputerContract {

    interface ComputerView {
        @SuppressLint("SupportAnnotationUsage")
        @StringRes
        fun showGreetMessage(message : Int)

        fun showPlayButton()
        fun hideGenerateButton()

        fun startNewActivity()
    }

    interface ComputerPresenter{
        fun load()
        fun generateCompNumber(): Int
        fun startGame()
    }

    interface ComputerRepo{
        fun saveCompMagicNumber(number : Int)
        fun startAttempt()
    }
}