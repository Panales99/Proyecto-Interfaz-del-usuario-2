package com.example.proyecto_rafael

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_rafael.data.Moviles
import com.example.proyecto_rafael.databinding.MovilesItemBinding

class MovilesAdapter(
    private val movilesList: MutableList<Moviles>,
    private val onClickDelete: (Int) -> Unit,
    private val onClickImage: (Int, Moviles) -> Unit,
    private val onClickName: (Int, Moviles) -> Unit // Agregar el listener
) : RecyclerView.Adapter<MovilesAdapter.MovilesViewHolder>() {

    companion object {
        const val DRAWABLE = "drawable"
        const val CLON = "Clon"
    }

    inner class MovilesViewHolder(private val binding: MovilesItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movil: Moviles) {
            binding.apply {
                tvName.text = movil.nombre
                tvIntelligence.text = movil.almacenamiento.toString()
                tvPower.text = movil.ram.toString()

                val context = ivPhoto.context
                val idPhoto = context.resources.getIdentifier(movil.foto, DRAWABLE, context.packageName)
                ivPhoto.setImageResource(idPhoto)

                root.setOnClickListener {
                    // Llamar al listener onClickName
                    onClickName(adapterPosition, movil)
                }

                ivDelHero.setOnClickListener {
                    onClickDelete(adapterPosition)
                }

                ivPhoto.setOnClickListener {
                    if (!movil.nombre.contains(CLON)) {
                        val clonMovil = movil.copy(nombre = "$CLON ${movil.nombre}")
                        onClickImage(adapterPosition + 1, clonMovil)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovilesViewHolder {
        val binding = MovilesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovilesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovilesViewHolder, position: Int) {
        val movil = movilesList[position]
        holder.bind(movil)
    }

    override fun getItemCount(): Int {
        return movilesList.size
    }
}
