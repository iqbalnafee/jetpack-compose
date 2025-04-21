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
            MyApp(content = { padding -> Greeting("Android", Modifier.padding(padding)) })
        }
    }
}

@Composable
fun MyApp(content: @Composable (PaddingValues) -> Unit) {
    JetpackComposePracticeTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            content(innerPadding)
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
    MyApp(content = { padding -> Greeting("Android", Modifier.padding(padding)) })
}