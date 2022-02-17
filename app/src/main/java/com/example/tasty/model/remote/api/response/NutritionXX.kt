package com.example.tasty.model.remote.api.response

import java.io.Serializable

data class NutritionXX(
    val calories: Int,
    val carbohydrates: Int,
    val fat: Int,
    val fiber: Int,
    val protein: Int,
    val sugar: Int,
    val updated_at: String
):Serializable