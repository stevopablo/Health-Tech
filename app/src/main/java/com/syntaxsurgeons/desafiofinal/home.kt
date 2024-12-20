package com.syntaxsurgeons.desafiofinal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.time.LocalDateTime

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logouBtn: ImageButton = findViewById(R.id.logouBtn)
        logouBtn.setOnClickListener {
            Firebase.auth.signOut()
        }
//change email to nome
//        pegar intent
        val name = intent.getStringExtra("EmailUser")?: "Convidado"
        val userName: TextView = findViewById(R.id.helloUser)

        val Data = LocalDateTime.now()
        val dataHours = Data.hour

        if (dataHours < 12) {
            userName.text = "Bom dia, $name !"
        }else if (dataHours >= 12 && dataHours < 18) {
            userName.text = "Boa tarde, $name !"
        }else {
            userName.text = "Boa noite, $name !"
        }



        val calendarButton: ImageButton = findViewById(R.id.calendarButton)
        calendarButton.setOnClickListener {
            val intent = Intent(this@home, Agendados::class.java)
            startActivity(intent)
        }

        val settingsButton: ImageButton = findViewById(R.id.settingsButton)
        settingsButton.setOnClickListener {
            val intent = Intent(this@home, Config::class.java)
            startActivity(intent)
        }


        val addConsul = findViewById<ImageButton>(R.id.AddConsul)
        addConsul.setOnClickListener {
            val intent = Intent(this@home, Marcar::class.java)
            startActivity(intent)
        }

        val userButton: ImageButton = findViewById(R.id.userButton)
        userButton.setOnClickListener{
            val intent = Intent(this@home,User::class.java)
            startActivity(intent)
        }
    }



}