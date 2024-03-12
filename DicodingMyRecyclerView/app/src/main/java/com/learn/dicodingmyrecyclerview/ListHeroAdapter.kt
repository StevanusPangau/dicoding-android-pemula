package com.learn.dicodingmyrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learn.dicodingmyrecyclerview.databinding.ItemRowHeroBinding

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

//    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
//        return ListViewHolder(binding)
//    }

//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val (name, description, photo) = listHero[position]
////        holder.imgPhoto.setImageResource(photo)
//        Glide.with(holder.itemView.context)
//            .load(photo) // URL Gambar
//            .into(holder.binding.imgPhoto) // imageView mana yang akan diterapkan
//        holder.binding.tvName.text = name
//        holder.binding.tvDescription.text = description
//        holder.itemView.setOnClickListener {
//            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
//        }
//    }

//    override fun getItemCount(): Int = listHero.size

//    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
//        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
//        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
//    }

    // >>> Menggunakan binding <<<
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.binding.imgItemPhoto) // imageView mana yang akan diterapkan
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listHero.size

    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)
    // <<< Menggunakan binding >>>

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}