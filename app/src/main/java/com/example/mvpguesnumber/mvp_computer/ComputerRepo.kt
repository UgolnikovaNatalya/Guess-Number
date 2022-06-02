package com.example.mvpguesnumber.mvp_computer

import com.example.mvpguesnumber.SavedAttempts
import com.example.mvpguesnumber.SavedMagicNumber
import com.example.mvpguesnumber.mvp_main.DEFAULT_ATTEMPT

class ComputerRepo(
    private val savedNumber: SavedMagicNumber,
    private val startAttempt: SavedAttempts
) : ComputerContract.ComputerRepo {

    override fun saveCompMagicNumber(number: Int) {
        savedNumber.magicNumber = number
    }

    override fun startAttempt() {
        startAttempt.currentAttempt = DEFAULT_ATTEMPT
    }

}