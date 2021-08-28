package com.project.recipeapptest.presentation.ui.recipe

sealed class RecipeEvent {

    class GetRecipeEvent(val id: Int) : RecipeEvent()
}
