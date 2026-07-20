package com.example.learnkotlin.ui.login

import androidx.lifecycle.ViewModel
import com.example.learnkotlin.data.repository.AccountRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel - chứa logic xử lý và giữ state cho LoginScreen.
 * View (Compose) observe _uiState để hiển thị, và gọi các hàm ở đây khi user tương tác.
 */
class LoginViewModel : ViewModel() {

    private val accountRepository = AccountRepository()

    // StateFlow giữ trạng thái UI - Compose sẽ collect flow này
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    /**
     * Được gọi khi user thay đổi username TextField
     */
    fun onUsernameChange(newUsername: String) {
        _uiState.value = _uiState.value.copy(
            username = newUsername,
            usernameError = "" // Xóa lỗi khi user sửa
        )
    }

    /**
     * Được gọi khi user thay đổi password TextField
     */
    fun onPasswordChange(newPassword: String) {
        _uiState.value = _uiState.value.copy(
            password = newPassword,
            passwordError = "" // Xóa lỗi khi user sửa
        )
    }

    /**
     * Được gọi khi user bấm nút Login
     */
    fun onLoginClick() {
        val currentState = _uiState.value
        var usernameError = ""
        var passwordError = ""

        // Bước 1: Validate đầu vào
        if (currentState.username.isBlank()) {
            usernameError = "Username not empty!"
        }

        if (currentState.password.isBlank()) {
            passwordError = "Password not empty!"
        } else if (currentState.password.length < 8 || currentState.password.length > 16) {
            passwordError = "Password have 8-16 characters!"
        }

        // Nếu validate fail -> cập nhật state và return
        if (usernameError.isNotBlank() || passwordError.isNotBlank()) {
            _uiState.value = currentState.copy(
                usernameError = usernameError,
                passwordError = passwordError
            )
            return
        }

        // Bước 2: Kiểm tra tài khoản từ Repository (Model layer)
        val accountError = accountRepository.checkAccountExists(currentState.username)
        if (accountError != null) {
            _uiState.value = currentState.copy(usernameError = accountError)
            return
        }

        val passwordVerifyError = accountRepository.verifyPassword(
            currentState.username,
            currentState.password
        )
        if (passwordVerifyError != null) {
            _uiState.value = currentState.copy(passwordError = passwordVerifyError)
            return
        }

        // Bước 3: Login thành công
        _uiState.value = currentState.copy(
            usernameError = "",
            passwordError = "",
            isLoginSuccess = true
        )
    }

    /**
     * Được gọi sau khi đã navigate sang màn hình khác.
     * Reset state để nếu user quay lại Login thì không bị navigate lại.
     */
    fun onNavigated() {
        _uiState.value = LoginUiState()
    }
}
