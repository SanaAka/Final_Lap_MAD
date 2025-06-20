package com.example.productapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.productapp.databinding.ActivityProductDetailBinding
import com.example.productapp.model.Product
import com.example.productapp.utils.CartManager
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("product") as? Product
        if (product == null) {
            finish()
            return
        }

        with(binding) {
            tvName.text = product.name
            tvPrice.text = "$${product.price}"
           tvSpecs.text = listOf(
               "• OS: ${product.specs.os}",
               "• CPU: ${product.specs.cpu}",
               "• Memory: ${product.specs.memory}",
               "• Screen Size: ${product.specs.screenSize}"
           ).joinToString("\n")

            Picasso.get()
                .load(product.imageUrl)
                .resize(500, 500) // Optional: Resize for performance
                .centerCrop()
                .into(binding.ivImage)

            btnAddToCart.setOnClickListener {
                CartManager.addToCart(product)
                Toast.makeText(this@ProductDetailActivity, "Added to cart ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
