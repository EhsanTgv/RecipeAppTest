package com.project.recipeapptest.di

import com.project.recipeapptest.network.RecipeService
import com.project.recipeapptest.network.model.RecipeDtoMapper
import com.project.recipeapptest.repository.RecipeRepository
import com.project.recipeapptest.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeService, recipeDtoMapper)
    }
}