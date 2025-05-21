package com.example.tugas1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas1.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil nama lengkap dari Intent
        val namaLengkap = intent.getStringExtra("NAMA_LENGKAP") ?: "User"
        binding.tvWelcome.text = "Welcome, $namaLengkap!"
    }
}
