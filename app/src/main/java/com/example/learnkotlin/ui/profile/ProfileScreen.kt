package com.example.learnkotlin.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    username: String,
    onBack: () -> Unit = {},
    onOpenInvoice: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Username: $username",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Email: $username@example.com",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(Modifier.height(32.dp))

        // Button mở danh sách hóa đơn
        Button(
            onClick = onOpenInvoice,
            modifier = Modifier.width(150.dp)
        ) {
            Text("Hóa đơn")
        }

        Spacer(Modifier.height(12.dp))

        // Button quay lại
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.width(150.dp)
        ) {
            Text("Back")
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(username = "admin")
}
