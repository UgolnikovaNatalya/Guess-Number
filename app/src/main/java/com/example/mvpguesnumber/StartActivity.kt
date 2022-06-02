package com.example.mvpguesnumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvpguesnumber.databinding.ActivityStartBinding


class StartActivity : AppCompatActivity() {

    private val viewBinding by viewBinding(
            ActivityStartBinding::bind,
            R.id.root
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        viewBinding.btnComputer.setOnClickListener {
            startGameWithComp()
        }

        viewBinding.btnFriend.setOnClickListener {
            startGameWithFriend()
        }
    }

    private fun startGameWithComp() {
        startActivity(Intent(this, ComputerGameActivity::class.java))
    }

    private fun startGameWithFriend() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}