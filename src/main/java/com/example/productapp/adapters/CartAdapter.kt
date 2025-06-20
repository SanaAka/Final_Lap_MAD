package com.example.productapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import com.example.productapp.databinding.ItemCartBinding
import com.example.productapp.model.Product

class CartAdapter(private val products: List<Product>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = products[position]
        with(holder.binding) {
            tvName.text = product.name
            tvPrice.text = "$${product.price}"
            Picasso.get().load(product.imageUrl).into(ivImage)

        }
    }
}
