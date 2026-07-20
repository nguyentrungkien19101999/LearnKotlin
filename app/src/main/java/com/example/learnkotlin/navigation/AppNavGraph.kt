package com.example.learnkotlin.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnkotlin.ui.home.HomeScreen
import com.example.learnkotlin.ui.invoice.InvoiceScreen
import com.example.learnkotlin.ui.login.LoginScreen
import com.example.learnkotlin.ui.login.LoginViewModel
import com.example.learnkotlin.ui.profile.ProfileScreen

/**
 * Định nghĩa các route (đường dẫn màn hình)
 */
object Routes {
    const val LOGIN = "login"
    const val HOME = "home/{username}"
    const val PROFILE = "profile/{username}"
    const val INVOICE = "invoice"

    fun homeWithArg(username: String) = "home/$username"
    fun profileWithArg(username: String) = "profile/$username"
}

/**
 * NavGraph - quản lý điều hướng giữa các màn hình
 */
@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {
        // Màn hình Login
        composable(Routes.LOGIN) {
            val loginViewModel: LoginViewModel = viewModel()
            val uiState by loginViewModel.uiState.collectAsState()

            LaunchedEffect(uiState.isLoginSuccess) {
                if (uiState.isLoginSuccess) {
                    navController.navigate(Routes.homeWithArg(uiState.username)) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                    loginViewModel.onNavigated()
                }
            }

            LoginScreen(viewModel = loginViewModel)
        }

        // Màn hình Home
        composable(Routes.HOME) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            HomeScreen(
                username = username,
                onOpenProfile = {
                    navController.navigate(Routes.profileWithArg(username))
                },
                onLogout = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        // Màn hình Profile
        composable(Routes.PROFILE) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            ProfileScreen(
                username = username,
                onOpenInvoice = {
                    navController.navigate(Routes.INVOICE)
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // Màn hình Hóa đơn
        composable(Routes.INVOICE) {
            InvoiceScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
