package com.example.mvpguesnumber.mvp_play

import android.util.Log
import com.example.mvpguesnumber.SavedAttempts
import com.example.mvpguesnumber.SavedMagicNumber
import com.example.mvpguesnumber.dataSaving.SavedComputerNumber
import com.example.mvpguesnumber.dataSaving.SavedNumber

class PlayRepo (private val savedMagicNumber: SavedMagicNumber,
                private val savedAttempts : SavedAttempts,
                private val savedUserNumber: SavedNumber)
                : PlayContract.PlayRepo {

    override fun getMagicNumber() : Int {
        return savedMagicNumber.magicNumber
    }

    override fun getAttempt() : Int {
        return savedAttempts.currentAttempt
    }

    override fun updateAttempt(attempt: Int) {
        savedAttempts.currentAttempt = attempt
    }

    override fun getUserCurrentNumber(): Int {
        return savedUserNumber.userNumber
    }

    override fun updateUserCurrentNumber(user_number: Int) {
        savedUserNumber.userNumber = user_number
    }
}