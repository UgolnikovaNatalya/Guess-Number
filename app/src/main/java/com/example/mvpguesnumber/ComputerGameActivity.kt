package com.example.mvpguesnumber

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvpguesnumber.databinding.ActivityComputerGameBinding
import com.example.mvpguesnumber.mvp_computer.ComputerContract
import com.example.mvpguesnumber.mvp_computer.ComputerPresenter
import com.example.mvpguesnumber.mvp_computer.ComputerRepo

class ComputerGameActivity : AppCompatActivity(), ComputerContract.ComputerView {

    private val vb by viewBinding(
        ActivityComputerGameBinding::bind,
        R.id.root
    )

    private val presenter : ComputerContract.ComputerPresenter by lazy {
        ComputerPresenter (
            this,
            ComputerRepo(
                SavedMagicNumberImpl(this),
                SavedAttemptsInterfaceImpl(this)
            )
                )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer_game)

        presenter.load()

        vb.btnStartComp.setOnClickListener {
            presenter.generateCompNumber()
            Log.d("comp", "${presenter.generateCompNumber()} - comp activity")
        }

        vb.btnStartGame.setOnClickListener {
            presenter.startGame()
        }
    }

    override fun showGreetMessage(message: Int) {
        vb.greetMessage.text = getString(message)
    }

    override fun showPlayButton() {
        vb.btnStartGame.isVisible = true
    }

    override fun hideGenerateButton() {
        vb.btnStartComp.isVisible = false
    }

    override fun startNewActivity() {
        startActivity(Intent(this, PlayActivity::class.java))
    }
}