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
import com.google.firebase.auth.FirebaseAuth
import com.syntaxsurgeons.desafiofinal.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()

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
                    val intent = Intent(this@Login, home::class.java)
                    intent.putExtra("EmailUser", email)
                    startActivity(intent)
                    finish()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
            } finally {
                Toast.makeText(this,"Logado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
