package com.example.tugas1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullName.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()


            if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                binding.tvMessage.text = "Semua field harus diisi!"
                return@setOnClickListener
            }


            if (password.length < 8) {
                binding.tvMessage.text = "Password minimal 8 karakter!"
                return@setOnClickListener
            }


            if (password != confirmPassword) {
                binding.tvMessage.text = "Konfirmasi password tidak cocok!"
                return@setOnClickListener
            }


            binding.tvMessage.setTextColor(resources.getColor(android.R.color.holo_green_dark))
            binding.tvMessage.text = "Registrasi berhasil!"
        }
    }
}
