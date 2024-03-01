package com.example.proyecto_rafael

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_rafael.data.Moviles  // Agrega la importación de la clase Movil
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

        val username = arguments?.getString("USERNAME")

        binding.btnUserInfo.setOnClickListener {
            val bundle = Bundle().apply {
                putString("USERNAME", username)
            }
            findNavController().navigate(R.id.action_menuFragment_to_userInfoFragment, bundle)
        }

        binding.btnSalir.setOnClickListener {
            findNavController().popBackStack(R.id.loginFragment, false)
        }

        binding.navMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemFragment1 -> {
                    findNavController().navigate(R.id.action_menuFragment_to_itemListFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.itemFragment2 -> {
                    val movilSeleccionado = obtenerMovilSeleccionado()
                    movilSeleccionado?.let { movil ->
                        val bundle = Bundle().apply {
                            putString("MOVIL_NOMBRE", movil.nombre)
                            putInt("MOVIL_RAM", movil.ram)
                            putInt("MOVIL_ALMACENAMIENTO", movil.almacenamiento)
                        }
                        findNavController().navigate(R.id.action_menuFragment_to_favItemListFragment, bundle)
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.itemFragment3 -> {
                    val bundle = Bundle().apply {
                        putString("USERNAME", username)
                    }
                    findNavController().navigate(R.id.action_menuFragment_to_userInfoFragment, bundle)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun obtenerMovilSeleccionado(): Moviles? {
        // Aquí deberías implementar la lógica para obtener el móvil seleccionado
        // Puedes obtenerlo de la lista, base de datos, o de donde sea que esté almacenado

        // Por ahora, devolvemos un móvil de ejemplo. Reemplázalo con la lógica adecuada.
        val ejemploMovil = Moviles("Ejemplo", 4, 64, "ejemplo_foto")
        return ejemploMovil
    }

}
