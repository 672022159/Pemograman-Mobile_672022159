package com.example.tugas1

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("user_prefs", MODE_PRIVATE)

        binding.btnRegister.setOnClickListener {
            val nama = binding.etNamaLengkap.text.toString()
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val confirm = binding.etConfirmPassword.text.toString()

            when {
                nama.isEmpty() || username.isEmpty() || password.isEmpty() || confirm.isEmpty() -> {
                    binding.tvMessage.text = "Semua kolom harus diisi"
                }
                password.length < 8 -> {
                    binding.tvMessage.text = "Password minimal 8 karakter"
                }
                password != confirm -> {
                    binding.tvMessage.text = "Konfirmasi password salah"
                }
                else -> {
                    preferences.edit().apply {
                        putString("nama", nama)
                        putString("username", username)
                        putString("password", password)
                        apply()
                    }
                    Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}
