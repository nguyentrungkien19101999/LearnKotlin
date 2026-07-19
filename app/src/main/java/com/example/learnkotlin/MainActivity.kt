package com.example.learnkotlin

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import com.example.learnkotlin.ui.theme.LearnKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnKotlinTheme {
                GetLayout()
            }
        }
    }
}

@Composable
fun GetLayout() {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo login Screen")


        Spacer(Modifier.height(10.dp))

        UsernameTextField(
            username,
            onUsernameChange = {username = it})

        Spacer(Modifier.height(10.dp))

        PasswordTextField(
            password,
            onPasswordChange = {password = it}
        )

        Spacer(Modifier.height(30.dp))

        Button(onClick = { accountVerification() },
            modifier = Modifier.width(150.dp)) {
            Text("Login")
        }
    }
}

@Composable
fun PasswordTextField(password: String, onPasswordChange: (String) -> Unit) {
    OutlinedTextField(
        label = {Text("Password")},
        value = password,
        onValueChange = onPasswordChange,
        placeholder = {Text("8 - 16 characters")}
    )
}

@Composable
fun UsernameTextField(username: String, onUsernameChange: (String) -> Unit) {
    OutlinedTextField(
        label = {Text("Username")},
        value = username,
        onValueChange = onUsernameChange,
        placeholder = {Text("Username or Phone number")}
    )
}
private fun accountVerification() {

}
@Preview
@Composable
fun PreviewLayout() {
    GetLayout()
}