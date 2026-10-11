package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Stores the name and description of each superhero.
data class Superhero(
    val name: String,
    val description: String
)

// Main activity of the application.
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                SuperheroApp()
            }
        }
    }
}

// Displays the superhero application.
@Composable
fun SuperheroApp() {

    // List of six superheroes.
    val superheroes = listOf(
        Superhero(
            "Nick the Night and Day",
            "The Jetpack Hero"
        ),
        Superhero(
            "Reality Protector",
            "Understands the absolute truth"
        ),
        Superhero(
            "Andre the Giant",
            "Mimics the light and night to blend in"
        ),
        Superhero(
            "Benjamin the Brave",
            "Harnesses the power of canary to develop bravely"
        ),
        Superhero(
            "Magnificent Maru",
            "Effortlessly glides in to save the day"
        ),
        Superhero(
            "Dynamic Yasmine",
            "Ability to shift to any form and energize"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F7F0))
    ) {

        // Application heading.
        Text(
            text = "Superheroes",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        // Scrollable list of superheroes.
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(superheroes) { hero ->
                SuperheroCard(hero)
            }
        }
    }
}

// Displays one superhero card.
@Composable
fun SuperheroCard(hero: Superhero) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE4E8D9)
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
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = hero.description,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            // Displays a star instead of a Material Icon.
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        Color(0xFFB7D39B),
                        RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "★",
                    fontSize = 40.sp,
                    color = Color(0xFF426B39)
                )
            }
        }
    }
}