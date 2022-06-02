package com.example.mvpguesnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvpguesnumber.databinding.ActivityMainBinding
import com.example.mvpguesnumber.mvp_main.MainContract
import com.example.mvpguesnumber.mvp_main.MainPresenter
import com.example.mvpguesnumber.mvp_main.MainRepo

class MainActivity : AppCompatActivity(), MainContract.MainView {
    private val viewBinding by viewBinding(
        ActivityMainBinding :: bind,
        R.id.root
    )

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

        showGreetMessage()
        viewBinding.btnStartGame.setOnClickListener {
            presenter.saveMN(viewBinding.magicNumber.text.toString())
        }
    }

    override fun showGreetMessage() {
        viewBinding.greeting.setText(R.string.main_greet)
    }

    override fun showToast(message: Int) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun clearMagicNumber() {
        viewBinding.magicNumber.setText("")
    }

    override fun startNewActivity() {
        startActivity(Intent(this, PlayActivity::class.java))
    }

}
