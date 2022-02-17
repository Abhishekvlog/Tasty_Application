package com.example.tasty.model.remote.api.response

import java.io.Serializable

data class RenditionX(
    val aspect: String,
    val bit_rate: Any,
    val container: String,
    val content_type: String,
    val duration: Int,
    val file_size: Any,
    val height: Int,
    val maximum_bit_rate: Any,
    val minimum_bit_rate: Any,
    val name: String,
    val poster_url: String,
    val url: String,
    val width: Int
):Serializable