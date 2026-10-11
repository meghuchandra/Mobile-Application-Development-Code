package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Stores information about each superhero.
data class Superhero(
    val name: String,
    val description: String,
    val emoji: String
)

// Main activity that starts the application.
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Displays the app using Jetpack Compose.
        setContent {
            MaterialTheme {
                SuperheroApp()
            }
        }
    }
}

// Creates the main superhero screen.
@Composable
fun SuperheroApp() {

    // List of six superheroes.
    val heroes = listOf(
        Superhero(
            "Nick the Night and Day",
            "The Jetpack Hero",
            "🦸"
        ),
        Superhero(
            "Reality Protector",
            "Understands the absolute truth",
            "🦸‍♀️"
        ),
        Superhero(
            "Andre the Giant",
            "Mimics the light and night to blend in",
            "💪"
        ),
        Superhero(
            "Benjamin the Brave",
            "Harnesses the power of canary to develop bravely",
            "🦸🏽"
        ),
        Superhero(
            "Magnificent Maru",
            "Effortlessly glides in to save the day",
            "🦸🏼‍♀️"
        ),
        Superhero(
            "Dynamic Yasmine",
            "Ability to shift to any form and energize",
            "⚡"
        )
    )

    // Displays the superheroes in a scrollable list.
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(heroes) { hero ->

            // Creates a rounded card for each superhero.
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.secondaryContainer
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Displays superhero name and description.
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = hero.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = hero.description,
                            fontSize = 14.sp
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    // Displays the superhero emoji.
                    Text(
                        text = hero.emoji,
                        fontSize = 36.sp
                    )
                }
            }
        }
    }
}