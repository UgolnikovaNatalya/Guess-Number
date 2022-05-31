package com.example.mvpguesnumber

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.mvpguesnumber.dataSaving.SavedComputerNumberImpl
import com.example.mvpguesnumber.dataSaving.SavedUserNumberImpl
import com.example.mvpguesnumber.mvp_play.PlayContract
import com.example.mvpguesnumber.mvp_play.PlayPresenter
import com.example.mvpguesnumber.mvp_play.PlayRepo

class PlayActivity : AppCompatActivity(), PlayContract.PlayView {

    lateinit var greetTxt: TextView
    lateinit var pictures: ImageView
    lateinit var tryNumber: EditText
    lateinit var tryBtn: Button
    lateinit var againBtn: Button

    private val presenter: PlayContract.PlayPresenter by lazy {
        PlayPresenter(
            this,
            PlayRepo(
                SavedMagicNumberImpl(this),
                SavedAttemptsInterfaceImpl(this),
                SavedUserNumberImpl(this)
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        greetTxt = findViewById(R.id.tryt)
        pictures = findViewById(R.id.smile)
        tryNumber = findViewById(R.id.try_number)
        tryBtn = findViewById(R.id.btn_try)
        againBtn = findViewById(R.id.btn_again)

        presenter.load()

        tryBtn.setOnClickListener {
            presenter.checkNumber(tryNumber.text.toString())
        }
        againBtn.setOnClickListener {
            startGameAgain()
        }


    }

    override fun changeGreetMessage(message: Int, attempts: Int) {
        greetTxt.text = getString(message, attempts)
    }

    override fun changePicture(picture: Int) {
        pictures.setImageDrawable(ContextCompat.getDrawable(this,picture))
    }

    override fun clearTryNumber() {
        tryNumber.setText("")
    }

    override fun hideTryNumber() {
        tryNumber.isVisible = false
    }

    override fun showButtonPlayAgain() {
        againBtn.isVisible = true
    }

    override fun hideButtonPlayAgain() {
        againBtn.isVisible = false
    }

    override fun showButtonTry() {
        tryBtn.isVisible = true
    }

    override fun hideButtonTry() {
        tryBtn.isVisible = false
    }

    override fun showToast(message: Int) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun startGameAgain() {
        startActivity(Intent(this, StartActivity::class.java))
    }
}