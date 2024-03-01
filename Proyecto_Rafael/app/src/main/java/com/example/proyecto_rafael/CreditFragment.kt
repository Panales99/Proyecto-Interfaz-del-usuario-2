package com.example.proyecto_rafael

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.proyecto_rafael.CreditFragment // Importa la clase CreditActivity si aún no lo has hecho
import com.example.proyecto_rafael.databinding.FragmentCreditBinding

class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = arguments?.getString("USERNAME")
        binding.welcomeText.text = "Usuario $username, estás usando la versión 1 de..."

        binding.contactButton.setOnClickListener {
            // Crear un intent para abrir CreditActivity
            val creditIntent = Intent(requireContext(), CreditFragment::class.java)

            // Agregar datos extras al intent si es necesario
            creditIntent.putExtra("USERNAME", username)

            // Iniciar la actividad
            startActivity(creditIntent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
