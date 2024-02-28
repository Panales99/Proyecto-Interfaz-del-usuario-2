package com.example.proyecto_rafael

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_rafael.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val username = binding.editTextText.text.toString()
            if (username.isNotEmpty()) {
                val actionId = R.id.action_loginFragment_to_menuFragment
                val bundle = Bundle().apply {
                    putString("USERNAME", username) // Utiliza la clave "USERNAME"
                }
                findNavController().navigate(actionId, bundle)
            } else {
                binding.editTextText.error = "Por favor ingresa tu nombre de usuario"
            }
        }

        // Configurar el listener de clic para la ImageView de Facebook
        binding.imageViewFacebook.setOnClickListener {
            openSocialMedia("https://www.facebook.com/")
        }

        // Configurar el listener de clic para la ImageView de Twitter
        binding.imageViewTwitter.setOnClickListener {
            openSocialMedia("https://twitter.com/")
        }

        // Configurar el listener de clic para la ImageView de Instagram
        binding.imageViewInstagram.setOnClickListener {
            openSocialMedia("https://www.instagram.com/")
        }
    }

    private fun openSocialMedia(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
