package com.example.mvpguesnumber.mvp_computer

import android.util.Log
import com.example.mvpguesnumber.R

class ComputerPresenter(
    private val view: ComputerContract.ComputerView,
    private val compRepo: ComputerContract.ComputerRepo
) : ComputerContract.ComputerPresenter {

    private var cNum = 0

    override fun load() {
        view.showGreetMessage(R.string.comp_greet)
    }

    override fun generateCompNumber() : Int  {
        cNum = (0..100).random()
        compRepo.saveCompMagicNumber(cNum)
        Log.d("comp", "$cNum - comp presenter")

        compRepo.startAttempt()

        view.startNewActivity()
        return cNum
    }

    override fun startGame() {
        view.startNewActivity()
    }
}