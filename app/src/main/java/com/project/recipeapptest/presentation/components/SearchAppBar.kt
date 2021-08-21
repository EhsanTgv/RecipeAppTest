package com.project.recipeapptest.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.recipeapptest.presentation.ui.recipe_list.FoodCategory
import com.project.recipeapptest.presentation.ui.recipe_list.getAllFoodCategories

@ExperimentalComposeUiApi
@Composable
fun SearchAppBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
    selectedCategory: FoodCategory?,
    onSelectedCategoryChanged: (String) -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        elevation = 8.dp
    ) {
        val keyboardController = LocalSoftwareKeyboardController.current

        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(8.dp),
                    value = query,
                    onValueChange = { newValue ->
                        onQueryChanged(newValue)
                    },
                    label = {
                        Text(text = "Search")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                        )
                    },
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onExecuteSearch()
                            keyboardController?.hide()
                        }
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onSurface
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface
                    ),
                )
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 8.dp,
                        bottom = 8.dp,
                    )
            ) {
                itemsIndexed(
                    items = getAllFoodCategories()
                ) { index, category ->
                    FoodCategoryChip(
                        category = category.value,
                        isSelected = selectedCategory == category,
                        onSelectedCategoryChanged = {
                            onSelectedCategoryChanged(it)
                        },
                        onExecuteSearch = { onExecuteSearch() }
                    )
                }
            }
        }
    }
}