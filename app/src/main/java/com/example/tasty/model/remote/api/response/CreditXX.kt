package com.example.tasty.model.remote.api.response

import java.io.Serializable

data class CreditXX(
    val id: Int,
    val image_url: String,
    val name: String,
    val slug: String,
    val type: String
):Serializable