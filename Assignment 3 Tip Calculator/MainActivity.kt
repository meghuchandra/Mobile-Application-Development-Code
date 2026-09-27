package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlin.math.ceil

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                TipCalculatorApp()
            }
        }
    }
}

/*
 * Tip Calculator
 *
 * Allows the user to:
 * - Enter a bill amount
 * - Select a tip percentage with a slider
 * - Choose whether to round the tip up
 * - View the tip amount and total bill
 */
@Composable
fun TipCalculatorApp() {

    // Stores the bill amount entered by the user
    var billAmount by remember {
        mutableStateOf("")
    }

    // Stores the selected tip percentage
    var tipPercentage by remember {
        mutableFloatStateOf(15f)
    }

    // Stores whether the tip should be rounded up
    var roundUpTip by remember {
        mutableStateOf(false)
    }

    // Convert the bill amount from text to a number
    val bill = billAmount.toDoubleOrNull() ?: 0.0

    // Calculate the tip
    var tip = bill * (tipPercentage / 100.0)

    // Round the tip up if the user enables the option
    if (roundUpTip) {
        tip = ceil(tip)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        // App title
        Text(
            text = "Tip Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        // Bill amount input field
        OutlinedTextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            label = { Text("Bill Amount") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Display selected tip percentage
        Text(
            text = "Tip Percentage: ${tipPercentage.toInt()}%"
        )

        // Slider for selecting the tip percentage
        Slider(
            value = tipPercentage,
            onValueChange = { tipPercentage = it },
            valueRange = 0f..30f,
            steps = 29,
            modifier = Modifier.fillMaxWidth()
        )

        // Round-up option
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("Round Up Tip")

            Switch(
                checked = roundUpTip,
                onCheckedChange = { roundUpTip = it }
            )
        }

        // Calculated tip amount
        Text(
            text = "Tip Amount: $%.2f".format(tip),
            style = MaterialTheme.typography.headlineSmall
        )

        // Total bill including tip
        Text(
            text = "Total: $%.2f".format(bill + tip),
            style = MaterialTheme.typography.titleLarge
        )
    }
}