package com.example.proyecto_rafael

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicia MainActivity y finaliza SplashActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
