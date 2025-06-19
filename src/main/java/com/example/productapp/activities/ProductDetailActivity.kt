package com.example.productapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.productapp.databinding.ActivityProductDetailBinding
import com.example.productapp.model.Product
import com.example.productapp.utils.CartManager

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

            Glide.with(this@ProductDetailActivity)
                .load(product.imageUrl)
                .into(ivImage)

            btnAddToCart.setOnClickListener {
                CartManager.addToCart(product)
                Toast.makeText(this@ProductDetailActivity, "Added to cart ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
