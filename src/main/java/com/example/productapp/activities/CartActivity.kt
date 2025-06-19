package com.example.productapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productapp.adapters.CartAdapter
import com.example.productapp.databinding.ActivityCartBinding
import com.example.productapp.utils.CartManager

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cartItems = CartManager.getCartItems()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CartAdapter(cartItems)

        binding.btnCheckout.setOnClickListener {
            Toast.makeText(this, "Checkout clicked ", Toast.LENGTH_SHORT).show()
        }
    }
}
