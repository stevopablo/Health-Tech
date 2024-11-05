package com.syntaxsurgeons.desafiofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.syntaxsurgeons.desafiofinal.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }

        binding.singInBtn.setOnClickListener {
            val emailText = binding.emailRegister.text.toString()
            val passwordText = binding.passoRegister.text.toString()
            val confirmPasswordText = binding.confirmPasswordRegister.text.toString()

            if (emailText.isNotEmpty() && passwordText.isNotEmpty() && confirmPasswordText.isNotEmpty()) {
                if (passwordText == confirmPasswordText) {
                    auth.createUserWithEmailAndPassword(emailText, passwordText).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this@Register, Login::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@Register, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "As senhas não são iguais", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
