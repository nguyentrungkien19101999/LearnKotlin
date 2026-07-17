package com.example.learnkotlin

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnkotlin.ui.theme.LearnKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnKotlinTheme {

            }
        }
    }
}

@Preview
@Composable
fun GetLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello World!",
            color = Color.Red,
            fontSize = 13.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "I'm KienNT",
            color = Color.Cyan,
            fontSize = 13.sp,
        )
    }
}