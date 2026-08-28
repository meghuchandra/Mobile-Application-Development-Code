package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

// MainActivity is the starting point of the Android application.
class MainActivity : ComponentActivity() {

    // onCreate runs when the app starts.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent tells Jetpack Compose what UI to display.
        setContent {
            HappyBirthdayTheme {
                BirthdayCard()
            }
        }
    }
}

// This composable creates the complete birthday card screen.
@Composable
fun BirthdayCard() {

    // This variable remembers whether the Celebrate button was pressed.
    var celebrated by remember {
        mutableStateOf(false)
    }

    // Box lets us place the birthday card on top of a background.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4EC)),
        contentAlignment = Alignment.Center
    ) {

        // Card creates the white rounded birthday card in the center.
        Card(
            modifier = Modifier.padding(24.dp),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {

            // Column arranges all elements vertically.
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                // Birthday decorations.
                Text(
                    text = "🎉 🎂 🎈",
                    fontSize = 42.sp
                )

                // Main birthday heading.
                Text(
                    text = "Happy Birthday!",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                // Birthday message.
                Text(
                    text = "Wishing you a wonderful day filled with happiness, laughter, and great memories!",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                // Sender name.
                Text(
                    text = "From Meghan",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                // Button gives the app a small interactive feature.
                Button(
                    onClick = {
                        celebrated = true
                    }
                ) {
                    Text("Celebrate!")
                }

                // This message appears after the button is pressed.
                if (celebrated) {
                    Text(
                        text = "🎊 Have an amazing birthday! 🎊",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}