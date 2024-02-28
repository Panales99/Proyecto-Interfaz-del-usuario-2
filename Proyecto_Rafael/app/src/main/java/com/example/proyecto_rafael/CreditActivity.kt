package com.example.proyecto_rafael

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreditActivity : AppCompatActivity() {

    private lateinit var welcomeText: TextView
    private lateinit var contactButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        welcomeText = findViewById(R.id.welcomeText)
        contactButton = findViewById(R.id.contactButton)

        val username = intent.getStringExtra("USERNAME")

        welcomeText.text = "Usuario $username, estás usando la versión 1 de..."

        contactButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = android.net.Uri.parse("mailto:")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("tu_correo@gmail.com"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consslta de la app $username")
            try {
                startActivity(emailIntent)
            } catch (e: Exception) {
                // Manejar errores, por ejemplo, si no hay ninguna aplicación de correo instalada
                Toast.makeText(this, "No vamos a poder abrir correos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}