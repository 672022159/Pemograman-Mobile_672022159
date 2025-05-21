package com.example.tugas1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas1.databinding.ActivityMain1Binding

class MainActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityMain1Binding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("user_prefs", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            val savedUsername = preferences.getString("username", null)
            val savedPassword = preferences.getString("password", null)

            if (username == savedUsername && password == savedPassword) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                val namaLengkap = preferences.getString("nama", "")
                val intent = Intent(this, MainActivity3::class.java).apply {
                    putExtra("NAMA_LENGKAP", namaLengkap)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnToRegister.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
