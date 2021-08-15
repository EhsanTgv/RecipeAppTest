package com.project.recipeapptest.network.responses

import com.google.gson.annotations.SerializedName
import com.project.recipeapptest.network.model.RecipeDto

data class RecipeSearchResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("results") var recipes: List<RecipeDto>,
)