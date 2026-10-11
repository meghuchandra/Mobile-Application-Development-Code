package com.example.scrolllist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// MainActivity is the starting point of the application.
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Sets the application's user interface.
        setContent {
            MaterialTheme {
                ScrollListApp()
            }
        }
    }
}

// Creates the main screen containing a scrollable list.
@Composable
fun ScrollListApp() {

    // Creates 30 items to display in the list.
    val itemList = (1..30).map { "Item $it" }

    // Provides the basic screen layout.
    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            // Displays the application's title.
            Text(
                text = "Scroll List Application",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )

            // LazyColumn creates a vertically scrollable list.
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                // Creates a card for every item in the list.
                items(itemList) { item ->

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {

                        // Displays the item's name.
                        Text(
                            text = item,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    }
}