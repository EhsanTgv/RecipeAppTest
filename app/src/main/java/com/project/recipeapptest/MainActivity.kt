package com.project.recipeapptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.recipeapptest.ui.theme.RecipeAppTestTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, RecipeListFragment())
            .commit()

//        setContent {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .verticalScroll(rememberScrollState())
//                    .background(color = Color(0xFFF2F2F2))
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.happy_meal_small),
//                    contentDescription = "",
//                    modifier = Modifier
//                        .height(300.dp)
//                        .fillMaxWidth(),
//                    contentScale = ContentScale.Crop
//                )
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                            text = "Happy Meal",
//                            fontSize = 26.sp
//                        )
//                        Text(
//                            text = "$5.99",
//                            fontSize = 17.sp,
//                            color = Color(0xff85bb65),
//                            modifier = Modifier.align(Alignment.CenterVertically)
//                        )
//                    }
//                    Spacer(modifier = Modifier.padding(top = 10.dp))
//                    Text(
//                        text = "800 Calories",
//                        fontSize = 17.sp
//                    )
//                    Spacer(modifier = Modifier.padding(top = 10.dp))
//                    Button(
//                        onClick = {},
//                        modifier = Modifier.align(Alignment.CenterHorizontally)
//                    ) {
//                        Text(text = "Order Now")
//                    }
//                }
//            }
//        }
    }
}
