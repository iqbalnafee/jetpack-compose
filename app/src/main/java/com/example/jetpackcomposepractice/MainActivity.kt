package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractice.ui.theme.JetpackComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // In Kotlin, if the last parameter of a function is a lambda,
            // you can pass that lambda outside the parentheses.
            // And if you don’t need parentheses for anything else,
            // Kotlin even lets you drop the ()
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {

    // Creates a reactive state that remembers its value across recompositions


    //  Jetpack Compose re-runs your @Composable function when the value of counter changes
    //  this is called recomposition.
    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "I've been clicked $count times")
    }

    // var counter = 0
    // Every time the button is clicked, Compose rebuilds the UI.
    // And each time, it sets counter = 0 again.
}

@Composable
fun MyApp(content: @Composable () -> Unit /* means doesn't return anything visible*/) {
    JetpackComposePracticeTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "World", "There")) {
    Column { // vertical
        for (name: String in names) {
            Greeting(name = name)
            HorizontalDivider()
        }

        var counterState by remember { // only create this variable the first time this Composable is shown. After that, keep its value between recompositions

            // Creates a state holder specifically for an Int, initially 0
            mutableIntStateOf(0)
        }

        Counter(
            count = counterState,
            updateCount = { newCount ->
                counterState = newCount
            }
        )

        if(counterState > 5){
            Text(
                text = "I love to count",
                modifier = Modifier.padding(16.dp)
            )
        }

        // moving the state of the function to the caller is called state hoisting
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Yellow) {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .padding(16.dp)
                .background(Color.Magenta)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MyScreenContent()
    }
}