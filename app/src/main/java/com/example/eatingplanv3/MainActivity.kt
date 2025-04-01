package com.example.eatingplanv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthyEatingApp()
        }
    }
}
@Composable
fun HealthyEatingApp() {
    var timeOfDay by remember { mutableStateOf("") }
    var meals by remember { mutableStateOf(listOf<String>()) }
    val mealOptions = mapOf(
        "breakfast" to listOf(
            "Option 1: Rolled oats with banana, 2 boiled eggs, black coffee (unsweetened)",
            "Option 2: 2 slices Sourdough toast with Peanut butter, black coffee (unsweetened)"
        ),
        "mid morning snack" to listOf(
            "Option 1: Quarter cup Greek yogurt, handful of berries with 2 tablespoon nuts of choice",
            "Option 2: Celery and peanut butter"
        ),
        "lunch" to listOf(
            "Option 1: Grilled chicken salad with brown rice and cucumber water",
            "Option 2: Mexican Turkey with quinoa bowl"
        ),
        "afternoon snack" to listOf(
            "Option 1: 1 Granny Smith apple with 2 tablespoon peanut butter",
            "Option 2: Biltong with nuts"
        ),
        "dinner" to listOf(
            "Option 1: Grilled salmon with fresh baby spinach and lightly steamed broccolini",
            "Option 2: 250g grilled steak with lightly steamed vegetables"
        ),
        "after dinner snack" to listOf(
            "Option 1: 2 pieces of dark chocolate",
            "Option 2: Quarter cup Greek yogurt with mixed berries"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFF0000FF)), // added  colour to the background of the app
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // added an image at the top of the app with a healthy eating theme
        Image(
            painter = painterResource(id = R.drawable.healthy),
            contentDescription = "Healthy Eating Theme",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) //
        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = timeOfDay,
            onValueChange = {
                timeOfDay = it
            },
            label = { Text("Enter time of day meal (e.g., Breakfast, Mid Morning Snack, Lunch, Afternoon Snack, Dinner, After Dinner Snack)") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            meals = mealOptions[timeOfDay]
                ?: listOf("Invalid input! Please enter a valid meal time.eg.,  Breakfast, Mid Morning Snack, Lunch, Afternoon Snack, Dinner, After Dinner Snack)")
        }) {
            Text("Get Meal Suggestions")
        }


        Spacer(modifier = Modifier.height(16.dp))

        // add clear a button
        Button(onClick = {
            timeOfDay = ""
            meals = emptyList()
        }) {
            Text("Clear")
        }

        Spacer(modifier = Modifier.height(16.dp))

        meals.forEach { meal ->
            Text(meal)
            Spacer(modifier = Modifier.height(4.dp)) // spacing for meals
        }

        // Display catchphrase only once
        Spacer(modifier = Modifier.weight(1f)) // This will hold the catchphrase at the bottom
        Text(
            text = "THE FIRST STEP TO A HEALTHY LIFE IS TO MAKE THE RIGHT CHOICE",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewHealthyEatingApp() {
    HealthyEatingApp()
}


