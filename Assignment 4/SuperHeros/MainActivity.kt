package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Starts the app.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SuperheroApp()
        }
    }
}

// Displays the superheroes.
@Composable
fun SuperheroApp() {

    // Superhero names and descriptions.
    val heroes = listOf(
        "Nick the Night and Day" to "The Jetpack Hero",
        "Reality Protector" to "Understands the absolute truth",
        "Andre the Giant" to "Mimics the light and night to blend in",
        "Benjamin the Brave" to "Harnesses the power of canary to develop bravely",
        "Magnificent Maru" to "Effortlessly glides in to save the day",
        "Dynamic Yasmine" to "Ability to shift to any form and energize"
    )

    // Creates a scrollable list.
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(heroes) { hero ->

            Column {
                Text(text = hero.first)
                Text(text = hero.second)
            }
        }
    }
}