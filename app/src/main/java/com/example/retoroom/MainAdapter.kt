package com.example.retoroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retoroom.databinding.ItemUsuarioBinding
import com.example.retoroom.database.User

class MainAdapter(private val usuarios: List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.render(usuarios[position])
    }

    override fun getItemCount(): Int = usuarios.size


    class MainHolder(val binding: ItemUsuarioBinding):RecyclerView.ViewHolder(binding.root) {
        fun render(usuario: User){
            binding.tvUsuario.text = usuario.user_name
        }
    }
}