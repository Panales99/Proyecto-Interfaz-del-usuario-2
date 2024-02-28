package com.example.proyecto_rafael

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_rafael.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener el nombre de usuario del bundle
        val username = arguments?.getString("USERNAME")

        // Aquí puedes hacer lo que necesites con el nombre de usuario
        // Por ejemplo, mostrarlo en un TextView o utilizarlo de alguna otra manera

        // Configurar OnClickListener para el botón "Información Usuario"
        binding.btnUserInfo.setOnClickListener {
            // Crear un Bundle para pasar el nombre de usuario al UserInfoFragment
            val bundle = Bundle().apply {
                putString("USERNAME", username) // Utiliza la clave "USERNAME"
            }
            // Navegar al fragmento UserInfoFragment con el Bundle
            findNavController().navigate(R.id.action_menuFragment_to_userInfoFragment, bundle)
        }

        // Configurar OnClickListener para el botón "Salir"
        binding.btnSalir.setOnClickListener {
            // Navegar de vuelta al fragmento de inicio (LoginFragment)
            findNavController().popBackStack(R.id.loginFragment, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
