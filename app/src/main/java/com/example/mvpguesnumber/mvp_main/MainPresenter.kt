package com.example.mvpguesnumber.mvp_main

import android.util.Log
import com.example.mvpguesnumber.R
import java.lang.NumberFormatException

private const val MAX_NUMBER = 100

class MainPresenter(
    private val view: MainContract.MainView,
    private val repository: MainContract.MainRepo,
) : MainContract.MainPresenter {

    override fun saveMN(magNum: String) {
        try {
            when {
                magNum.isEmpty() -> view.showToast(R.string.enter_number)
                magNum.toInt() > MAX_NUMBER -> {
                    view.showToast(R.string.start_bigger)
                    view.clearMagicNumber()
                }
                else -> {
                    repository.saveMagicNumber(magNum)
                    repository.startAttempt()
                    view.startNewActivity()
                    Log.d("MN", magNum)
                }
            }

        }
        catch (e: NumberFormatException)
        {
            view.showToast(R.string.error_str_in_numb)
        }
    }
}