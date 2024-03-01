package com.example.proyecto_rafael

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyecto_rafael.data.Moviles
import com.example.proyecto_rafael.databinding.FragmentFavItemListBinding

class FavItemListFragment : Fragment() {

    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!
    private var argumentsToSet: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->
            val nombre = bundle.getString("nombre")
            val ram = bundle.getInt("ram")
            val almacenamiento = bundle.getInt("almacenamiento")

            Log.d("FavItemListFragment", "Received data: Nombre=$nombre, RAM=$ram, Almacenamiento=$almacenamiento")

            binding.tvNombre.text = nombre
            binding.tvRAM.text = ram.toString()
            binding.tvAlmacenamiento.text = almacenamiento.toString()
        }
    }


    // Método para permitir la asignación de argumentos después de que el fragmento se ha adjuntado
    fun setArgumentsToSet(bundle: Bundle) {
        argumentsToSet = bundle
    }

    // Método para actualizar la información del móvil
    fun updateMovilInfo(movil: Moviles) {
        binding.tvNombre.text = movil.nombre
        binding.tvRAM.text = movil.ram.toString()
        binding.tvAlmacenamiento.text = movil.almacenamiento.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
