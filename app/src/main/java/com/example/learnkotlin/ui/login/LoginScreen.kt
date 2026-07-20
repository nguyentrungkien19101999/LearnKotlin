package com.example.learnkotlin.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnkotlin.R

/**
 * View layer - chỉ hiển thị UI dựa trên state từ ViewModel.
 * Không chứa logic xử lý, chỉ gọi ViewModel khi user tương tác.
 */
@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    // Collect state từ ViewModel - UI tự động re-compose khi state thay đổi
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo login Screen"
        )

        Spacer(Modifier.height(10.dp))

        // Username TextField
        UsernameTextField(
            username = uiState.username,
            errorMessage = uiState.usernameError,
            onUsernameChange = { viewModel.onUsernameChange(it) }
        )

        Spacer(Modifier.height(10.dp))

        // Password TextField
        PasswordTextField(
            password = uiState.password,
            errorMessage = uiState.passwordError,
            onPasswordChange = { viewModel.onPasswordChange(it) }
        )

        Spacer(Modifier.height(30.dp))

        // Login Button - chỉ gọi ViewModel, không xử lý gì ở đây
        Button(
            onClick = { viewModel.onLoginClick() },
            modifier = Modifier.width(150.dp)
        ) {
            Text("Login")
        }
    }
}

@Composable
fun UsernameTextField(
    username: String,
    errorMessage: String,
    onUsernameChange: (String) -> Unit
) {
    OutlinedTextField(
        label = { Text("Username") },
        value = username,
        onValueChange = onUsernameChange,
        placeholder = { Text("Username or Phone number") },
        singleLine = true,
        isError = errorMessage.isNotBlank(),
        supportingText = {
            if (errorMessage.isNotBlank()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    )
}

@Composable
fun PasswordTextField(
    password: String,
    errorMessage: String,
    onPasswordChange: (String) -> Unit
) {
    OutlinedTextField(
        label = { Text("Password") },
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { Text("8 - 16 characters") },
        singleLine = true,
        isError = errorMessage.isNotBlank(),
        supportingText = {
            if (errorMessage.isNotBlank()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
