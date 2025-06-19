package com.example.productapp.utils

import com.example.productapp.model.Product

object CartManager {
    private val cartItems = mutableListOf<Product>()

    fun addToCart(product: Product) {
        cartItems.add(product)
    }

    fun getCartItems(): List<Product> = cartItems

    fun clearCart() {
        cartItems.clear()
    }
}
