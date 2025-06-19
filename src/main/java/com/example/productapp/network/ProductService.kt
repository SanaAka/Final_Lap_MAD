package com.example.productapp.network

import com.example.productapp.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("product-list.json")
    fun getProducts(): Call<List<Product>>
}
