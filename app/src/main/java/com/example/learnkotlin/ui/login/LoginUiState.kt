package com.example.learnkotlin.ui.login

/**
 * Data class giữ toàn bộ trạng thái của màn hình Login.
 * ViewModel sẽ cập nhật state này, View (Compose) sẽ observe và hiển thị.
 */
data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val usernameError: String = "",
    val passwordError: String = "",
    val isLoginSuccess: Boolean = false
)
