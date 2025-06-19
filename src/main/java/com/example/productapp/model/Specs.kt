package com.example.productapp.model

import java.io.Serializable

data class Specs(
    val os: String,
    val cpu: String,
    val memory: String,
    val screenSize: String
) : Serializable