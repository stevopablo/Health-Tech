package com.syntaxsurgeons.desafiofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailText: EditText = findViewById(R.id.loginInput)
        val passwordText: EditText = findViewById(R.id.passwordInput)
        val loginBtn: Button = findViewById(R.id.loginBtn)

        loginBtn.setOnClickListener {
            try {
                val email = emailText.text.toString().trim()
                val password = passwordText.text.toString().trim()

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Preencha os campos!", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, MainActivity::class.java)
//                    fazer intent para exportar
                    intent.putExtra("EmailUser", email)
                    startActivity(intent)
                    finish()
                }
            } catch (e: Exception) {
//                rastro do erro
                e.printStackTrace()
                Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
            } finally {
                Toast.makeText(this,"logado",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
