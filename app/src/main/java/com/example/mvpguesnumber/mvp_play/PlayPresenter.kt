package com.example.mvpguesnumber.mvp_play


import android.util.Log
import com.example.mvpguesnumber.R
import com.example.mvpguesnumber.mvp_main.DEFAULT_ATTEMPT
import java.lang.NumberFormatException

class PlayPresenter(
    private val view: PlayContract.PlayView,
    private val playRepo: PlayContract.PlayRepo
) : PlayContract.PlayPresenter {

    private var attempts = playRepo.getAttempt()
    private val magicNumber = playRepo.getMagicNumber()
    private val myNumber = playRepo.getUserCurrentNumber()

    override fun load() {
        Log.d("attempt", attempts.toString())
        when  {
            attempts == DEFAULT_ATTEMPT -> {
                view.changeGreetMessage(R.string.play_greet, attempts)
            }
            attempts > 0 -> {
                if (myNumber == magicNumber)
                    view.changeGreetMessage(R.string.win, attempts)
                if (myNumber < magicNumber)
                    view.changeGreetMessage(R.string.less, attempts)
                if (myNumber > magicNumber)
                    view.changeGreetMessage(R.string.bigger, attempts)
            }
            else -> {
                view.changeGreetMessage(R.string.loose, attempts)
            }
        }

    }

    override fun checkNumber(tryNum: String) {
        try {

            if (tryNum.isEmpty()) {
                view.showToast(R.string.enter_number)
            } else {
                //вычитаем попытку и записываем ее в sp
                attempts --
                playRepo.updateAttempt(attempts)
                Log.d("attemptN", attempts.toString())

                if (attempts > 0) {
                    when {
                        magicNumber == tryNum.toInt() -> {
                            view.changeGreetMessage(R.string.win, attempts)
                            view.hideTryNumber()
                            view.hideButtonTry()
                            view.showButtonPlayAgain()
                        }
                        magicNumber > tryNum.toInt() -> {
                            view.changeGreetMessage(R.string.less, attempts)
                            view.clearTryNumber()
                        }

                        magicNumber < tryNum.toInt() -> {
                            view.changeGreetMessage(R.string.bigger, attempts)
                            view.clearTryNumber()
                        }
                    }
                } else {
                    view.changeGreetMessage(R.string.loose, attempts)
                    view.hideTryNumber()
                    view.hideButtonTry()
                    view.showButtonPlayAgain()
                }
            }
            playRepo.updateUserCurrentNumber(tryNum.toInt())

        }
        catch (e: NumberFormatException){
            Log.d("error", "Empty try number field")
        }



    }
}