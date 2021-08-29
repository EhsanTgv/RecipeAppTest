package com.project.recipeapptest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.recipeapptest.domin.model.Recipe
import com.project.recipeapptest.presentation.ui.recipe_list.PAGE_SIZE
import com.project.recipeapptest.presentation.ui.recipe_list.RecipeListEvent
import com.project.recipeapptest.presentation.ui.recipe_list.RecipeListFragmentDirections

@Composable
fun RecipeList(
    loading: Boolean,
    recipes: List<Recipe>,
    onChangeRecipeScrollPosition: (Int) -> Unit,
    page: Int,
    onTriggerEvent: (RecipeListEvent) -> Unit,
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        if (loading && recipes.isEmpty()) {
            LoadingRecipeListShimmer(250.dp)
        } else {
            LazyColumn {
                itemsIndexed(
                    items = recipes
                ) { index, recipe ->
                    onChangeRecipeScrollPosition(index)
                    if ((index + 5) >= (page * PAGE_SIZE) && !loading) {
                        onTriggerEvent(RecipeListEvent.NextPageEvent)
                    }
                    RecipeCard(
                        recipe = recipe,
                        onClick = {
                            navController.navigate(
                                RecipeListFragmentDirections.actionRecipeListFragmentToRecipeFragment(
                                    recipe.id ?: 0
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}