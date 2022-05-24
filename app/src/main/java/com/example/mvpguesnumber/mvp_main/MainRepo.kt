package com.example.mvpguesnumber.mvp_main

import com.example.mvpguesnumber.SavedAttempts
import com.example.mvpguesnumber.SavedMagicNumber
const val DEFAULT_ATTEMPT = 2

//class MainRepo (private val sharedPreferences : SharedPreferences): MainContract.MainRepo
class MainRepo(
    private val savedMagicNumber: SavedMagicNumber,
    private val startAttempt : SavedAttempts
) : MainContract.MainRepo {

    //save magic number
    override fun saveMagicNumber(numb: String) {
        savedMagicNumber.magicNumber = numb.toInt()
    }

    //rewrite number of attempts every time
    //when press on button "Let's go!"
    override fun startAttempt() {
        startAttempt.currentAttempt = DEFAULT_ATTEMPT
    }
}