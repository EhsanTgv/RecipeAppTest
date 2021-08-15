package com.project.recipeapptest.repository

import com.project.recipeapptest.domin.model.Recipe
import com.project.recipeapptest.domin.util.DomainMapper
import com.project.recipeapptest.network.RecipeService
import com.project.recipeapptest.network.model.RecipeDtoMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }

}