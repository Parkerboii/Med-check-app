package com.example.med_check_app

import MedicinPage
import OrderPage
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import  androidx.navigation.compose.rememberNavController
import com.example.med_check_app.data.DataScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            HomePage(navController = navController)
        }
        composable(route = Screen.MedicinPage.route){
            MedicinPage()
        }
        composable(route = Screen.ReminderPage.route){
            ReminderPage()
        }
        composable(route = Screen.OrderPage.route){
            OrderPage()
        }
        composable(route = Screen.DataScreen.route){
            DataScreen()
        }
    }
}