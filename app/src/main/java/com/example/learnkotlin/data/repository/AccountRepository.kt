package com.example.learnkotlin.data.repository

/**
 * Model layer - chứa dữ liệu và logic truy cập dữ liệu.
 * Hiện tại dùng fake data, sau này có thể thay bằng API hoặc Database.
 */
class AccountRepository {

    // Dữ liệu giả lập - sau này thay bằng gọi API
    private val fakeAccounts = mapOf(
        "admin" to "12345678",
        "user01" to "password01"
    )

    /**
     * Kiểm tra tài khoản có tồn tại không.
     * @return null nếu tồn tại, hoặc error message nếu không
     */
    fun checkAccountExists(username: String): String? {
        return if (fakeAccounts.containsKey(username)) {
            null // Tài khoản tồn tại, không có lỗi
        } else {
            "Account not available!"
        }
    }

    /**
     * Xác thực mật khẩu cho tài khoản.
     * @return null nếu đúng, hoặc error message nếu sai
     */
    fun verifyPassword(username: String, password: String): String? {
        val expectedPassword = fakeAccounts[username]
        return if (expectedPassword == password) {
            null // Mật khẩu đúng
        } else {
            "Incorrect password!"
        }
    }
}
