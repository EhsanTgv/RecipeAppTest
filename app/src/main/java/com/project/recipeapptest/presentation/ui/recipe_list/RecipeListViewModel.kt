package com.project.recipeapptest.presentation.ui.recipe_list

import androidx.lifecycle.ViewModel
import com.project.recipeapptest.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject constructor(
    private val randomString: String,
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    init {
        println("ViewModel : $randomString")
        println("ViewModel : $repository")
        println("ViewModel : $token")
    }

    fun getRepository() = repository

    fun getRandomString() = randomString

    fun getToken() = token
}