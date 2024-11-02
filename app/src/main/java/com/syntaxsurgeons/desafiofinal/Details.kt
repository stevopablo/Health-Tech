package com.syntaxsurgeons.desafiofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    val cancelBtn = findViewById<Button>(R.id.cancelBtn)
    cancelBtn.setOnClickListener {
        Toast.makeText(this,"Consulta cancelada",  Toast.LENGTH_SHORT).show()
    }

        val backTo = findViewById<ImageButton>(R.id.backTo)
        backTo.setOnClickListener(){
            val intent = Intent(this,Agendados::class.java)
            startActivity(intent)
        }
    }

}
