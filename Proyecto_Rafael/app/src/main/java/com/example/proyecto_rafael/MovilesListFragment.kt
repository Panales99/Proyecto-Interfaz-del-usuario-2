package com.example.proyecto_rafael


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_rafael.data.Datasource
import com.example.proyecto_rafael.data.Moviles
import com.example.proyecto_rafael.databinding.FragmentMovilesListBinding
import com.example.proyecto_rafael.databinding.FragmentFavItemListBinding
import androidx.navigation.fragment.findNavController


class MovilesListFragment : Fragment() {

    private var _binding: FragmentMovilesListBinding? = null
    private val binding get() = _binding!!

    private var listaMoviles = Datasource.getMovilesList()
    private lateinit var movilesAdapter: MovilesAdapter
    private var favItemListFragment: FavItemListFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovilesListBinding.inflate(inflater, container, false)

        binding.textView.text = getString(R.string.hero_list)
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        movilesAdapter = MovilesAdapter(listaMoviles,
            onClickDelete = { pos -> deleteMovil(pos) },
            onClickImage = { pos, movil -> cloneMovil(pos, movil) },
            onClickName = { pos, movil -> addToFavorites(movil) }
        )
        binding.rvHeroes.adapter = movilesAdapter
        binding.rvHeroes.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun deleteMovil(pos: Int) {
        listaMoviles.removeAt(pos)
        movilesAdapter.notifyItemRemoved(pos)
    }

    private fun cloneMovil(pos: Int, movil: Moviles) {
        listaMoviles.add(pos, movil)
        movilesAdapter.notifyItemInserted(pos)
    }

    private fun addToFavorites(movil: Moviles) {
        val bundle = Bundle().apply {
            putString("nombre", movil.nombre)
            putInt("ram", movil.ram)
            putInt("almacenamiento", movil.almacenamiento)
            // Puedes pasar otros datos del móvil según sea necesario
        }

        // Si favItemListFragment no es nulo y ya está adjunto, pasa el Bundle
        if (favItemListFragment?.isAdded == true) {
            favItemListFragment?.arguments = bundle
            // Navega hacia el fragmento de favoritos después de asignar los argumentos
            findNavController().navigate(R.id.action_menuFragment_to_favItemListFragment)
        } else {
            // Si no está adjunto, guarda el Bundle en una variable y asigna en onViewCreated de favItemListFragment
            favItemListFragment?.setArgumentsToSet(bundle)
        }
    }


    fun setFavItemListFragment(fragment: FavItemListFragment) {
        favItemListFragment = fragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
