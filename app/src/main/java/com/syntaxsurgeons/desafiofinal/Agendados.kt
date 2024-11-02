package com.syntaxsurgeons.desafiofinal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class Agendados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agendados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goToSeeMore = findViewById<ImageButton>(R.id.goToseeMore)
        goToSeeMore.setOnClickListener {
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }

        val backTo = findViewById<ImageButton>(R.id.backTo)
        backTo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val calendarButton = findViewById<ImageButton>(R.id.calendarButton)
        calendarButton.setOnClickListener {
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }

        val userButton = findViewById<ImageButton>(R.id.userButton)
        userButton.setOnClickListener {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
        }

        val canceBtn1 = findViewById<ImageButton>(R.id.CancelBtn1)
        canceBtn1.setOnClickListener {
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }

        val canceBtn2 = findViewById<ImageButton>(R.id.CancelBtn2)
        canceBtn2.setOnClickListener {
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }

        val canceBtn3 = findViewById<ImageButton>(R.id.CancelBtn3)
        canceBtn3.setOnClickListener {
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }
    }

}