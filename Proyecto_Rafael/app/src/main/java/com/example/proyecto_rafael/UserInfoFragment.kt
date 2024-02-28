package com.example.proyecto_rafael

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyecto_rafael.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener el nombre de usuario del bundle
        val username = arguments?.getString("USERNAME")

        // Configurar el TextView con el nombre de usuario
        binding.textViewUsername.text = "Usuario: $username"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
