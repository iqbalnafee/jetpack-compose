package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                Greeting("Android")
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackComposePracticeTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
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
        Greeting("Android")
    }
}