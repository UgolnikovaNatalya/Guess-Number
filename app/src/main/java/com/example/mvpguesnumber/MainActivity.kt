package com.example.mvpguesnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mvpguesnumber.mvp_main.MainContract
import com.example.mvpguesnumber.mvp_main.MainPresenter
import com.example.mvpguesnumber.mvp_main.MainRepo

class MainActivity : AppCompatActivity(), MainContract.MainView {
    lateinit var magicNumber: EditText
    lateinit var startButton: View
    lateinit var greetTex: TextView

    private val presenter: MainContract.MainPresenter by lazy {
        MainPresenter(
            this,
            MainRepo(
                SavedMagicNumberImpl(this),
                SavedAttemptsInterfaceImpl(this)
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        greetTex = findViewById(R.id.greeting)
        startButton = findViewById(R.id.btn_start_game)
        magicNumber = findViewById(R.id.magic_number)

        showGreetMessage()
        startButton.setOnClickListener {
            presenter.saveMN(magicNumber.text.toString())
        }
    }

    override fun showGreetMessage() {
        greetTex.setText(R.string.main_greet)
    }

    override fun showToast(message: Int) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun clearMagicNumber() {
        magicNumber.setText("")
    }

    override fun startNewActivity() {
        startActivity(Intent(this, PlayActivity::class.java))
    }

}
