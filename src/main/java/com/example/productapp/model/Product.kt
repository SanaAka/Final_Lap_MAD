package com.example.productapp.model


import java.io.Serializable

data class Product(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int,
    val specs: Specs
) : Serializable
